package com.ylczjqnfc.http;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.ylczjqnfc.R;
import com.ylczjqnfc.controller.GlobalVar;

/**
 * 用于向服务器发送请求的工具类
 * @author Administrator
 *
 */
public class HttpUtil {
	private static Context mContext;
	public static final String URL = GlobalVar.imgDownloadUrl;
	private static final String norTime = "12000";
	private static final String rechangeTime = "30000";

	public HttpUtil(){
	}
	//向服务器发送请求
	/*public String Apdu_SendMessage(List<NameValuePair> firstParams)
			throws KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException, UnrecoverableKeyException, IOException {
		// 创建一个本地Cookie存储的实例
		CookieStore cookieStore = new BasicCookieStore();
		String apduOnlineResult = "";
		// 设置超时时间
		HttpParams httpParameters = new BasicHttpParams();
		int conTime = Integer.parseInt(rechangeTime);
		HttpConnectionParams.setConnectionTimeout(httpParameters, conTime);// Set
		int soTime = Integer.parseInt(rechangeTime);
		HttpConnectionParams.setSoTimeout(httpParameters, soTime);
		// 构造连接对象
		DefaultHttpClient httpclient = new DefaultHttpClient(httpParameters);
		// 构造证书对象（信任全部证书）
		TrustAllSSLSocketFactory socketFactory = new TrustAllSSLSocketFactory();
		Scheme sch = new Scheme("https", socketFactory, 443);
		httpclient.getConnectionManager().getSchemeRegistry().register(sch);
		// 返回接收对象
		HttpResponse httpResponse = null;
		// 返回状态
		int sta = 200;
		String strResult = null;
		// 设置连接地址
		String httpUrl = URL;
		// Toast.makeText(GlobalVar.conditions, httpUrl, Toast.LENGTH_SHORT)
		// .show();
		// HttpPost连接对象
		HttpPost httpRequest = new HttpPost(httpUrl);
		// 设置字符集
		HttpEntity httpentity = new UrlEncodedFormEntity(firstParams, "utf-8");
		// 设置参数
		httpRequest.setEntity(httpentity);
		// 设置user-agent
		httpRequest
				.setHeader(
						"USER-AGENT",
						"Mozilla/5.0 (Linux; U; AndroidPhoneBoco; zh-cn; HTC Desire Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
		String user_agent =
		// 手机型号（HTC Desire）
		android.os.Build.MODEL + ","
		// 操作系统版本号（Android 2.2）
				+ "Android " + android.os.Build.VERSION.RELEASE;
		httpRequest.setHeader("USER-AGENT", user_agent);
		// 设置编码格式
		httpRequest.setHeader("accept-charset", "utf-8");
		// 设置配置文件
//		if (GlobalVar.JSESSIONID != null) {
//			httpRequest.setHeader("Cookie", "JSESSIONID="
//					+ GlobalVar.JSESSIONID);
//		}用于消息推送,,,
		// 发送请求，取得HttpResponse
		try {
			httpResponse = httpclient.execute(httpRequest);
		} catch (Exception e) {
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("errorMsg", "请求失败");
				strResult = "msgType=" + HTTPMap.HTTP_FAILURE + "&data="
						+ jsonObj;
			} catch (JSONException e1) {

				e1.printStackTrace();
			}
			return strResult;
		}
		// 获得连接状态
		sta = httpResponse.getStatusLine().getStatusCode();
		// 通信异常处理
		if (sta != HttpStatus.SC_OK) {
			// 发送请求，取得HttpResponse
			try {
				httpResponse = httpclient.execute(httpRequest);
			} catch (Exception e) {
				JSONObject jsonObj = new JSONObject();
				try {
					jsonObj.put("errorMsg", "请求失败");
					strResult = "msgType=" + HTTPMap.HTTP_FAILURE + "&data="
							+ jsonObj;
				} catch (JSONException e1) {

					e1.printStackTrace();
				}
				return strResult;
			}
			// 获得连接状态
			sta = httpResponse.getStatusLine().getStatusCode();
			if (sta != HttpStatus.SC_OK) {
				String err = "服务器错误，错误代码：" + String.valueOf(sta);
				JSONObject jsonObj = new JSONObject();
				try {
					jsonObj.put("errorMsg", err);
					strResult = "msgType=" + HTTPMap.HTTP_FAILURE + "&data="
							+ jsonObj;
				} catch (JSONException e1) {

					e1.printStackTrace();
				}
				return strResult;
			}
		}

		if (httpRequest != null) {
			strResult = EntityUtils.toString(httpResponse.getEntity());
			// DswLog.e("", "" + strResult);
			// GetGsonData(strResult);
			apduOnlineResult = strResult;
		}
		cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
		List<Cookie> cookies = cookieStore.getCookies();
		
		for (int i = 0; i < cookies.size(); i++){
			// 这里是读取Cookie['JSESSIONID']的值存在静态变量中，保证每次都是同一个值
			if ("JSESSIONID".equals(cookies.get(i).getName())) {
//				GlobalVar.JSESSIONID = cookies.get(i).getValue();用于消息推送,,,
				break;
			}
		}
		String type = GetType(apduOnlineResult);
		MyAsynctask.GetGsonData(apduOnlineResult);
		return apduOnlineResult;
	}
	
	private static String GetType(String result) {
		String msgType = "";
		try {
			int end = result.indexOf("&");
			String head = result.substring(0, end);
			int head_head = head.indexOf("=");
			String head_text = head.substring(head_head + 1); // 0002
			msgType = head_text;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msgType;
	}*/
	
	/**
     * Post请求连接Https服务
     * @param serverURL  请求地址
     * @param jsonStr    请求报文
     * @return
     * @throws Exception
     */
    public static synchronized String doHttpsPost(String serverURL, String jsonStr)throws Exception {
        // 参数
        HttpParams httpParameters = new BasicHttpParams();
        // 设置连接超时
        HttpConnectionParams.setConnectionTimeout(httpParameters, 3000);
        // 设置socket超时
        HttpConnectionParams.setSoTimeout(httpParameters, 3000);
        // 获取HttpClient对象 （认证）
        HttpClient hc = HttpClientHelper.getHttpClient(httpParameters);
		HttpPost post = new HttpPost(serverURL);

        // 发送数据类型
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        // 接受数据类型
        post.addHeader("Accept", "application/json");
        // 请求报文
        StringEntity entity = new StringEntity(jsonStr, "UTF-8");
        post.setEntity(entity);
        post.setParams(httpParameters);
        HttpResponse response = null;
        try {
            response = hc.execute(post);
        } catch (UnknownHostException e) {
            throw new Exception("Unable to access " + e.getLocalizedMessage());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        int sCode = response.getStatusLine().getStatusCode();
        if (sCode == HttpStatus.SC_OK) {
            return EntityUtils.toString(response.getEntity());
        } else
            throw new Exception("StatusCode is " + sCode);
    }
	
}
