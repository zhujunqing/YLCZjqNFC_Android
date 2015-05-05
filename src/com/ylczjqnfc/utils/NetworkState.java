package com.ylczjqnfc.utils;

import java.util.List;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetworkState {

	/**
	 * 判断Android客户端网络是否连接方式1
	 * 
	 * @param context
	 * @return 真假
	 */
	public static boolean isNetworkAvailable(Context context) {

		try {
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (cm == null) {

			} else { // 如果仅仅是用来判断网络连接,则可以使用cm.getActiveNetworkInfo().isAvailable();
				NetworkInfo[] info = cm.getAllNetworkInfo();
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		/*
		 * 判断网络的第二种方式 try { ConnectivityManager connectivity =
		 * (ConnectivityManager) context
		 * .getSystemService(Context.CONNECTIVITY_SERVICE); if (connectivity !=
		 * null) {
		 * 
		 * NetworkInfo info = connectivity.getActiveNetworkInfo(); if (info !=
		 * null && info.isConnected()) { if (info.getState() ==
		 * NetworkInfo.State.CONNECTED) { return true; } }else{
		 * Toast.makeText(context, "网络连接超时", Toast.LENGTH_SHORT).show(); } } }
		 * catch (Exception e) { return false; }
		 */
		return false;
	}

	/**
	 * 判断GPS是否打开
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isGpsEnabled(Context context) {
		LocationManager lm = ((LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE));
		List<String> accessibleProviders = lm.getProviders(true);
		return accessibleProviders != null && accessibleProviders.size() > 0;
	}

	/**
	 * 判断WIFI是否打开
	 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel
				.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}

	/**
	 * 判断是否是3G网络
	 */
	public static boolean is3rd(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		if (networkINfo != null
				&& networkINfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是wifi还是3g网络,用户的体现性在这里了，wifi就可以建议下载或者在线播放。
	 */
	public static boolean isWifi(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		if (networkINfo != null
				&& networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {
			return true;
		}
		return false;
	}

}
