package com.ylczjqnfc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Gson:用于解析json数据的工具类
 * @author Administrator
 *
 */
public class GsonTools {

	public GsonTools(){
		
	}
	/**
	 * 使用Gson进行解析，解析出来的是Person这个对象
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getT(String jsonString,Class<T> cls){
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 使用Gson进行解析，解析的是List<Person>数据
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getListT(String jsonString,Class<T> cls){
		List<T> list = new ArrayList<T>();
		try {
			Gson gson = new Gson();
			//解析了jsonString完了之后，将它丢到TypeToken<List<T>>这个当中，然后从T当中取出所有的类型
			list = gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 使用Gson进行解析，解析的是List<String>类型的数据
	 */
	public static List<String> getListStr(String jsonString){
		List<String> listStr = new ArrayList<String>();
		try {
			Gson gson = new Gson();
			listStr = gson.fromJson(jsonString,new TypeToken<List<String>>(){}.getType());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listStr;
	}
	
	/**
	 * 使用Gson进行解析，解析的是List<Map<String,Object>>类型的数据
	 */
	public static List<Map<String,Object>> listKeyMaps(String jsonString){
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		try {
			Gson gson = new Gson();
			listMap = gson.fromJson(jsonString, new TypeToken<List<Map<String,Object>>>(){}.getType());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listMap;
	}
}

