package org.data.handle;

import java.sql.Timestamp;
import java.util.Date;

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
	public static double convertToDouble(Object value){
		if(value==null)
			return -1.0;
		return Double.parseDouble(value.toString());
	}
	public static long convertToLong(Object value){
		if(value==null)
			return -1;
		return Long.parseLong(value.toString());
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
	public static String timePerformance(Date start, Date end){
		long diffInSeconds = (end.getTime() - start.getTime()) / 1000;

	    long diff[] = new long[] { 0, 0, 0, 0 };
	    /* sec */diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
	    /* min */diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
	    /* hours */diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
	    /* days */diff[0] = (diffInSeconds = (diffInSeconds / 24));

	    return String.format(
	        "%d day%s, %d hour%s, %d minute%s, %d second%s ago",
	        diff[0],
	        diff[0] > 1 ? "s" : "",
	        diff[1],
	        diff[1] > 1 ? "s" : "",
	        diff[2],
	        diff[2] > 1 ? "s" : "",
	        diff[3],
	        diff[3] > 1 ? "s" : "");
	}
}
