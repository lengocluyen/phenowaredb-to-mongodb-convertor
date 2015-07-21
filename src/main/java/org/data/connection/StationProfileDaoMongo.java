package org.data.connection;

import org.bson.Document;
import org.data.form.ImgAcqStationProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class StationProfileDaoMongo extends DAOMongo<ImgAcqStationProfile>{
	MongoCollection<Document> collection = this.getDatabase()
			.getCollection("stationprofile");
	
	public StationProfileDaoMongo(){
		super();
	}
	
	public String getStationProfileUri(int stationProfileId){
		Document doc = this.collection.find(Filters.eq("imgacqstationprofileid", stationProfileId)).first();
		if(doc == null)
			return "";
		else
			return doc.getString("uri");
	}
	
	
	public int getStationProfileUriNumIncrLastInserted(){	
		Document doc = this.collection.find().sort(Sorts.descending("_id")).first(); // dernier document stationprofile insere dans la base																	
		System.out.println(doc);

		String uri = doc.getString("uri"); // recuperation de l'uri
		System.out.println(uri);

		if (uri == null)  //pas encore de document stationprofile dans la base
			return 0;
		else {

			String numIncr = uri.substring(uri.length() - 3); // recuperation du numero incremente										
			System.out.println(numIncr);
			return Integer.parseInt(numIncr); // conversion en int
		}
	}
	
	
	public int getImgacqstationprofileidMax(){
		MongoCollection<Document> collection = this.getDatabase()
				.getCollection("stationprofile");

		Document doc = collection.find().sort(Sorts.descending("configuration.imgacqstationprofileid")).first(); //  document avec imgacqstationprofileid max
		
		Integer imgacqstationprofileid = ((Document) doc.get("configuration")).getInteger("imgacqstationprofileid"); // recuperation de l'imgacqstationprofileid
				
		if (imgacqstationprofileid == null)  //pas encore de document stationprofile dans la base
			return 0;
		else {
			return imgacqstationprofileid;
		}

	}
}
