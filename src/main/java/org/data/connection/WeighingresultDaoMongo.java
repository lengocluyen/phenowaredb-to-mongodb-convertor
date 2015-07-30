package org.data.connection;

import org.bson.Document;
import org.data.form.Weighingresult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class WeighingresultDaoMongo extends DAOMongo<Weighingresult>{
	private MongoCollection<Document> collection ;
	
	public WeighingresultDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("weighing"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public int getWeighingidMax(){
		Document doc = collection.find().sort(Sorts.descending("configuration.weighingid")).first(); // document avec weighingid max

		if (doc == null)  //pas encore de document pesee dans la base
			return 0;
		else {
			Integer weighingid= ((Document) doc.get("configuration")).getInteger("weighingid"); // recuperation du weighingid

			if (weighingid == null)
				return 0;
			else
				return weighingid ;
		}
	}

	public String getDateMax(){
		Document doc = collection.find().sort(Sorts.descending("_id")).first(); //document avec date max puisque les docs sont inseres par ordre de date

		if (doc == null)  //pas encore de document pesee dans la base
			return "1900-01-01";

		String date = doc.getString("date"); // recuperation de la date

		if (date == null)  
			return "1900-01-01";
		else {
			return date;
		}
	}
}
