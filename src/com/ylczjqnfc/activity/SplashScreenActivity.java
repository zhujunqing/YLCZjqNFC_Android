package com.ylczjqnfc.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ylczjqnfc.R;
import com.ylczjqnfc.utils.ImageFileCache;
import com.ylczjqnfc.utils.ImageGetFromHttp;
import com.ylczjqnfc.utils.ImageMemoryCache;
import com.ylczjqnfc.utils.NetworkState;

public class SplashScreenActivity extends Activity {

	private ImageView serverSplashImg;//服务器的广告图片
	private ImageMemoryCache memoryCache;
	private ImageFileCache fileCache;
	private Context mContext;
	
	private final int GET_IDIMAG = 1;//获取闪屏网络图片（(1)从内存缓存中获 (2)从文件缓存中获取 (3)从网络资源中下载获取）
	
	
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

	String imgDownloadUrl = null;//网络下载的地址
	Bitmap splashyBitmap = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashy);
		mContext = this;
		initViews();
		
		if(NetworkState.isNetworkAvailable(mContext)){
			if (imgDownloadUrl != null) {
				new Thread() {
					@Override
					public void run() {
						splashyBitmap = getBitmap(imgDownloadUrl);
						netHandler.sendEmptyMessage(GET_IDIMAG);
					};
				}.start();
			}
		}else{
			splashyBitmap = getBitmap(imgDownloadUrl);
			netHandler.sendEmptyMessage(GET_IDIMAG);
			Toast.makeText(mContext, "网络连接超时", 1).show();
		}
		
	}
	
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
	
	public void initViews(){
		serverSplashImg = (ImageView)findViewById(R.id.server_img_id);
		memoryCache = new ImageMemoryCache(this);
		fileCache = new ImageFileCache();
		imgDownloadUrl = getResources().getString(R.string.ad_img);// 网络图片地址
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splashy, menu);
		return true;
	}

}
