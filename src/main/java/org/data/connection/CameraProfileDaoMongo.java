package org.data.connection;

import org.bson.Document;
import org.data.form.ImgAcqCameraProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Filters;

public class CameraProfileDaoMongo extends DAOMongo<ImgAcqCameraProfile>{
	MongoCollection<Document> collection = this.getDatabase()
			.getCollection("cameraprofile");
	
	public CameraProfileDaoMongo(){
		super();
	}
	
	public String getCameraProfileUri(int cameraProfileId){
		Document doc = this.collection.find(Filters.eq("imgacqcameraprofileid", cameraProfileId)).first();
		if(doc == null)
			return "";
		else
			return doc.getString("uri");
	}
	
	
	public int getCameraProfileUriMax(){	
		Document doc = this.collection.find().sort(Sorts.descending("_id")).first(); // dernier document cameraprofile insere dans la base																	
		System.out.println(doc);

		String uri = doc.getString("uri"); // recuperation de l'uri
		System.out.println(uri);

		if (uri == null)  //pas encore de document cameraprofile dans la base
			return 0;
		else {

			String numIncr = uri.substring(uri.length() - 3); // recuperation du numero incremente										
			System.out.println(numIncr);
			return Integer.parseInt(numIncr); // conversion en int
		}
	}

}
