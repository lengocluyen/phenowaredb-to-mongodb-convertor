package org.data.connection;

import org.bson.Document;
import org.data.form.ImgProcResult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class ImgProcResultDaoMongo extends DAOMongo<ImgProcResult>{
	
	public ImgProcResultDaoMongo(){
		super();
	}

	
	public int getResultidMax(){
		MongoCollection<Document> collection = this.getDatabase()
				.getCollection("imageanalysis");

		Document doc = collection.find().sort(Sorts.descending("configuration.resultid")).first(); // document avec resultid max
		
		Integer resultid = ((Document) doc.get("configuration")).getInteger("resultid"); // recuperation du resultid
				
		if (resultid == null)  //pas encore de document analyse dans la base
			return 0;
		else {
			return resultid;
		}
	}
}
