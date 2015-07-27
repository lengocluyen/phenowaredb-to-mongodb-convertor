package org.data.connection;

import org.bson.Document;
import org.data.form.Image;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;



public class ImageDaoMongo extends DAOMongo<Image>{
	private MongoCollection<Document> collection ;

	public ImageDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("image"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public int getImageUriNumIncrLastInserted() {
		Document doc = collection.find().sort(Sorts.descending("_id")).first(); // dernier document image insere dans la base

		if (doc == null)   //pas encore de document image dans la base
			return 0;
		
		String uri = doc.getString("uri"); // recuperation de l'uri

		if (uri == null)  //pas de champ "uri"
			return 0;
		else {

			String numIncr = uri.substring(uri.length() - 9); // recuperation du numero incremente										
			System.out.println(numIncr);
			return Integer.parseInt(numIncr); // conversion en int
		}
	}
	
	public int getImgidMax(){
		Document doc = collection.find().sort(Sorts.descending("configuration.imgid")).first(); // document avec imgid max
		
		if (doc == null)  //pas encore de document image dans la base
			return 0;
		
		Integer imgid = ((Document) doc.get("configuration")).getInteger("imgid"); // recuperation de l'imgid
				
		if (imgid == null)  
			return 0;
		else {
			return imgid;
		}

	}
	
	public String getImageUriFromId(int id){
		Document doc = collection.find(Filters.eq("configuration.imgid", id)).first();
		if(doc == null)  //cet id est absent dans la base mongodb
			return "";
		
		String uri = doc.getString("uri"); // recuperation de l'uri
		
		if(uri == null)
			return "";
		else
			return uri;
	}
	
	public String getImageUriFromGuid(String guid){
		Document doc = collection.find(Filters.eq("fileName", guid)).first();
		if(doc == null)  //guid absent dans la base mongodb
			return "";
		
		String uri = doc.getString("uri"); // recuperation de l'uri
		
		if(uri == null)
			return "";
		else
			return uri;
	}
	
	public static void main(String[] args) {
		ImageDaoMongo idm = new ImageDaoMongo();
		System.out.println(idm.getImageUriNumIncrLastInserted());
		System.out.println("uri : "+idm.getImageUriFromId(903038));
		System.out.println(idm.getImgidMax());
	}
}

