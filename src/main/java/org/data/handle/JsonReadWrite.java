package org.data.handle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class JsonReadWrite {
	public boolean WriteToFile(List<LinkedHashMap<String,Object>> jsonObj, String filename, boolean formated){
		try{
			FileWriter file = new FileWriter(filename);
			int i=0;
			for(LinkedHashMap<String,Object> j:jsonObj){
				i++;
				String jsonString = new org.json.JSONObject(j).toString();
				//file.write("Document json "+i+"\n");
				if(formated)
					file.write(Utils.prettyJsonFormat(jsonString) +"\n");
				else
					file.write(jsonString +"\n");
				System.out.println("Writing the document " + i+": " + jsonString);
			}
			file.flush();
			System.out.println("Finish");
			file.close();
			return true;
		}
		catch(IOException eio){
			eio.printStackTrace();
			return false;
		}
	}
	public JSONObject ReadFromFile(String filename){
		JSONObject jsonObject = new JSONObject();
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader(filename));
			jsonObject = (JSONObject) obj;
			return jsonObject;
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
