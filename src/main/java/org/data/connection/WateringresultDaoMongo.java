package org.data.connection;

import org.bson.Document;
import org.data.form.Wateringresult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class WateringresultDaoMongo extends DAOMongo<Wateringresult>{
	private MongoCollection<Document> collection ;
	
	public WateringresultDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("watering"));
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public int getWateringidMax(){
		Document doc = collection.find().sort(Sorts.descending("configuration.wateringid")).first(); // document avec wateringid max
		
		if (doc == null)
			return 0;
		
		Integer wateringid = ((Document) doc.get("configuration")).getInteger("wateringid"); // recuperation du wateringid
				
		if (wateringid == null)  //pas encore de document irrigation dans la base
			return 0;
		else {
			return wateringid;
		}
	}
}
