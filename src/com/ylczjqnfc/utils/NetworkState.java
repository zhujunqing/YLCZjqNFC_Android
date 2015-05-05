package com.ylczjqnfc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkState {

	/**
	 * 判断Android客户端网络是否连接
	 * 方式1
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
		 * 判断网络的第二种方式
		 * try { ConnectivityManager connectivity = (ConnectivityManager)
		 * context .getSystemService(Context.CONNECTIVITY_SERVICE); if
		 * (connectivity != null) {
		 * 
		 * NetworkInfo info = connectivity.getActiveNetworkInfo(); if (info !=
		 * null && info.isConnected()) { if (info.getState() ==
		 * NetworkInfo.State.CONNECTED) { return true; } }else{
		 * Toast.makeText(context, "网络连接超时", Toast.LENGTH_SHORT).show(); } } }
		 * catch (Exception e) { return false; }
		 */
		return false;
	}
}
