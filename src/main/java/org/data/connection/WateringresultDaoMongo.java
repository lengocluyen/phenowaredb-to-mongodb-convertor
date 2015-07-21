package org.data.connection;

import org.bson.Document;
import org.data.form.Wateringresult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class WateringresultDaoMongo extends DAOMongo<Wateringresult>{
	
	public WateringresultDaoMongo(){
		super();
	}

	public int getWateringidMax(){
		MongoCollection<Document> collection = this.getDatabase()
				.getCollection("watering");

		Document doc = collection.find().sort(Sorts.descending("configuration.wateringid")).first(); // document avec wateringid max
		
		Integer wateringid = ((Document) doc.get("configuration")).getInteger("wateringid"); // recuperation du wateringid
				
		if (wateringid == null)  //pas encore de document irrigation dans la base
			return 0;
		else {
			return wateringid;
		}
	}
}
