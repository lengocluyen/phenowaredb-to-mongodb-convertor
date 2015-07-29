package org.data.connection;

import org.bson.Document;
import org.data.form.ImgAcqCameraProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Filters;

public class CameraProfileDaoMongo extends DAOMongo<ImgAcqCameraProfile>{
	private MongoCollection<Document> collection ;
	
	public CameraProfileDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
			.getCollection("cameraprofile"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}


	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}



	public String getCameraProfileUri(int cameraProfileId){
		Document doc = this.collection.find(Filters.eq("configuration.imgacqcameraprofileid", cameraProfileId)).first();
		if(doc == null)
			return "";
		
		
		String uri = doc.getString("uri"); // recuperation de l'uri
		if (uri == null)
			return "";
		else
			return uri;
	}
	
	
	public int getCameraProfileUriNumIncrLastInserted(){	
		Document doc = this.collection.find().sort(Sorts.descending("_id")).first(); // dernier document cameraprofile insere dans la base																	
		System.out.println(doc);

		if (doc == null)  //pas encore de document cameraprofile dans la base
			return 0;
		else {
			String uri = doc.getString("uri"); // recuperation de l'uri
			System.out.println(uri);
			if(uri == null)
				return 0;
			else{
				String numIncr = uri.substring(uri.length() - 3); // recuperation du numero incremente										
				System.out.println(numIncr);
				return Integer.parseInt(numIncr); // conversion en int
			}
		}
	}
	
	
	public int getImgacqcameraprofileidMax(){
		Document doc = collection.find().sort(Sorts.descending("configuration.imgacqcameraprofileid")).first(); //  document avec imgacqcameraprofileid max
				
		if (doc == null)  //pas encore de document stationprofile dans la base
			return 0;
		else {
			return ((Document) doc.get("configuration")).getInteger("imgacqcameraprofileid"); // recuperation de l'imgacqcameraprofileid
		}

	}

	public static void main(String[] args) {
		CameraProfileDaoMongo cpdm = new CameraProfileDaoMongo();
		System.out.println(cpdm.getCameraProfileUri(15));
	}
}
