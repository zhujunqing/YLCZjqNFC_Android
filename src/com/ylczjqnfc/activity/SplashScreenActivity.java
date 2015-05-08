package com.ylczjqnfc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.ylczjqnfc.R;
import com.ylczjqnfc.controller.GlobalVar;
import com.ylczjqnfc.http.HttpUtil;
import com.ylczjqnfc.pojo.Person;
import com.ylczjqnfc.utils.GsonTools;
import com.ylczjqnfc.utils.ImageFileCache;
import com.ylczjqnfc.utils.ImageGetFromHttp;
import com.ylczjqnfc.utils.ImageMemoryCache;
import com.ylczjqnfc.utils.LogUtil;
import com.ylczjqnfc.utils.NetworkState;

/**
 * 闪屏的类，同时也是第一个类
 * 
 * @author Administrator
 * 
 */
public class SplashScreenActivity extends Activity {

	private ImageView serverSplashImg;// 服务器的广告图片
	private ImageMemoryCache memoryCache;
	private ImageFileCache fileCache;
	private Context mContext;

	private final int GET_IDIMAG = 1;// 获取闪屏网络图片（(1)从内存缓存中获 (2)从文件缓存中获取
										// (3)从网络资源中下载获取）

	public Handler netHandler = new Handler(new Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case GET_IDIMAG:
				serverSplashImg.setImageBitmap(splashyBitmap);
				serverSplashImg.setVisibility(View.VISIBLE);
				break;

			default:
				break;
			}
			return false;
		}
	});

	String imgDownloadUrl = null;// 网络下载的地址
	Bitmap splashyBitmap = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashy);
		mContext = this;
		initViews();
		// 判断是否有网络
		if (NetworkState.isNetworkAvailable(mContext)) {
			if (imgDownloadUrl != null) {
				new Thread() {
					@Override
					public void run() {
						splashyBitmap = getBitmap(imgDownloadUrl);
						netHandler.sendEmptyMessage(GET_IDIMAG);
					};
				}.start();
			}
		} else {
			splashyBitmap = getBitmap(imgDownloadUrl);
			netHandler.sendEmptyMessage(GET_IDIMAG);
			Toast.makeText(mContext, "网络连接超时", 1).show();
		}
		
		new Thread(new MyThread()).start();
		splashy();
	}
	
	/**
	 * 初始化视图
	 */
	public void initViews() {
		serverSplashImg = (ImageView) findViewById(R.id.server_img_id);
		memoryCache = new ImageMemoryCache(this);
		fileCache = new ImageFileCache();
		imgDownloadUrl = getResources().getString(R.string.ad_img);// 网络图片地址
		GlobalVar.imgDownloadUrl = imgDownloadUrl;
	}

	private String versionMsg = "";
	
	private void splashy() {
		new Handler().postDelayed(new Runnable() {
			public void run() {
				// httpRequest(GET_ALPAY_LOGON);
				Intent intent = new Intent();
				intent.putExtra("versionMsg", versionMsg);
				intent.putExtra("sign", "");
				intent.setClass(SplashScreenActivity.this, MainActivity.class);
				startActivity(intent);
				onDestroy();
			}
		}, 3000);
	}
	
	// 获取广告图的方法
	public Bitmap getBitmap(String url) {
		// 从内存缓存中获取图片
		Bitmap result = null;
		try {
			result = memoryCache.getBitmapFromCache(url);
			if (result == null) {
				// 文件缓存中获取
				result = fileCache.getImage(url);
				if (result == null) {
					// 从网络获取
					result = ImageGetFromHttp.downloadBitmap(url);
					if (result != null) {
						fileCache.saveBitmap(result, url);
						memoryCache.addBitmapToCache(url, result);
					}
				} else {
					// 添加到内存缓存
					memoryCache.addBitmapToCache(url, result);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splashy, menu);
		return true;
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			HttpUtil httpUtil = new HttpUtil();
//			String jsonString = httpUtil.doHttpsPost(imgDownloadUrl, "1");
			String jsonString = httpUtil.doHttpsPost("http://192.168.1.229:8080/jsonProject2/json?action_flag=person", "1");
			
			Person person = GsonTools.getT(jsonString, Person.class);
			LogUtil.i(GlobalVar.TAG, "---->"+person.toString());
			String s = person.toString();
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
