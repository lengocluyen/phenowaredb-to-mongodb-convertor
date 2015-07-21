package org.data.connection;

import org.bson.Document;
import org.data.form.Weighingresult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class WeighingresultDaoMongo extends DAOMongo<Weighingresult>{
	
	public WeighingresultDaoMongo(){
		super();
	}
	
	public int getWeighingidMax(){
		try{
			MongoCollection<Document> collection = this.getDatabase()
					.getCollection("weighing");

			Document doc = collection.find().sort(Sorts.descending("configuration.weighingid")).first(); // document avec weighingid max

			Integer weighingid = ((Document) doc.get("configuration")).getInteger("weighingid"); // recuperation du weighingid

			if (weighingid == null)  //pas encore de document pesee dans la base
				return 0;
			else {
				return weighingid;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
