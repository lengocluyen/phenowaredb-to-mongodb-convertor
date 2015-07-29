package org.data.connection;

import org.bson.Document;
import org.data.form.ImgAcqStationProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class StationProfileDaoMongo extends DAOMongo<ImgAcqStationProfile>{
	private MongoCollection<Document> collection ;
	
	public StationProfileDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("stationprofile"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public String getStationProfileUri(int stationProfileId){
		Document doc = this.collection.find(Filters.eq("configuration.imgacqstationprofileid", stationProfileId)).first();
		if(doc == null)
			return "";
		
		String uri = doc.getString("uri");
		
		if (uri == null)
			return "";
		else
			return uri;
	}
	
	
	public int getStationProfileUriNumIncrLastInserted(){	
		Document doc = this.collection.find().sort(Sorts.descending("_id")).first(); // dernier document stationprofile insere dans la base																	
		System.out.println(doc);


		if (doc == null)  //pas encore de document stationprofile dans la base
			return 0;
		else {
			String uri = doc.getString("uri"); // recuperation de l'uri
			System.out.println(uri);
			if (uri == null)
				return 0;
			else{
			String numIncr = uri.substring(uri.length() - 3); // recuperation du numero incremente										
			System.out.println(numIncr);
			return Integer.parseInt(numIncr); // conversion en int
			}
		}
	}
	
	
	public int getImgacqstationprofileidMax(){

		Document doc = collection.find().sort(Sorts.descending("configuration.imgacqstationprofileid")).first(); //  document avec imgacqstationprofileid max
				
		if (doc == null)  //pas encore de document stationprofile dans la base
			return 0;
		else {
			return ((Document) doc.get("configuration")).getInteger("imgacqstationprofileid"); // recuperation de l'imgacqstationprofileid
		}

	}
	
	public static void main(String[] args) {
		StationProfileDaoMongo cpdm = new StationProfileDaoMongo();
		System.out.println(cpdm.getStationProfileUri(15));
	}
}
