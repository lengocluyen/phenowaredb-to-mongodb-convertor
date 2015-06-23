package org.data.handle;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Utils {
	public static int convertToInt(Object value){
		if(value==null)
			return -1;
		return Integer.parseInt(value.toString());
	}
	public static String convertToString(Object value){
		if(value==null)
			return "";
		return value.toString();
	}
	public static boolean convertToBool (Object value){
		if(value==null)
			return false;
		return true;
	}
	public static Timestamp convertToTimestamp (Object value){
		if(value ==null)
			return new Timestamp(new java.util.Date().getTime());
		else
			return Timestamp.valueOf(value.toString());
	}
	public static String prettyJsonFormat(String json){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
}
