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
	
	public String getDateMax(){
		Document doc = collection.find().sort(Sorts.descending("_id")).first(); //document avec date max puisque les docs sont inseres par ordre de date

		if (doc == null)  //pas encore de document analyse dans la base
			return "1900-01-01";

		String date = doc.getString("imageAnalysisDate"); // recuperation de la date

		if (date == null)  
			return "1900-01-01";
		else {
			return date;
		}
	}
		
		public int getLastResultid(){
			Document doc = collection.find().sort(Sorts.descending("_id")).first(); //dernier document insere

			if (doc == null)  //pas encore de document analyse dans la base
				return 0;

			Integer resultid = ((Document) doc.get("configuration")).getInteger("resultid"); // recuperation du resultid

			if (resultid == null)  
				return 0;
			else {
				return resultid;
		}
	}
}
