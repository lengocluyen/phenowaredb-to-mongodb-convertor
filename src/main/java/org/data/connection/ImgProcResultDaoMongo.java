package org.data.connection;

import org.bson.Document;
import org.data.form.ImgProcResult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class ImgProcResultDaoMongo extends DAOMongo<ImgProcResult>{
	private MongoCollection<Document> collection ;
	
	public ImgProcResultDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("imageanalysis"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}


	public int getResultidMax(){

		Document doc = collection.find().sort(Sorts.descending("configuration.resultid")).first(); // document avec resultid max
		
		if (doc == null)
			return 0;
		
		Integer resultid = ((Document) doc.get("configuration")).getInteger("resultid"); // recuperation du resultid
				
		if (resultid == null)  //pas encore de document analyse dans la base
			return 0;
		else {
			return resultid;
		}
	}
}
