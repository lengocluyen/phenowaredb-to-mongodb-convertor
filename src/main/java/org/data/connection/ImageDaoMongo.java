package org.data.connection;

import org.bson.Document;
import org.data.form.Image;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;



public class ImageDaoMongo extends DAOMongo<Image>{

	public ImageDaoMongo(){
		super();
	}
	
	public int getImageUriMax() {
		MongoCollection<Document> collection = this.getDatabase()
				.getCollection("image");

		Document doc = collection.find().sort(Sorts.descending("_id")).first(); // dernier document image insere dans la base																	
		System.out.println(doc);

		String uri = doc.getString("uri"); // recuperation de l'uri
		System.out.println(uri);

		if (uri == null)  //pas encore de document image dans la base
			return 0;
		else {

			String numIncr = uri.substring(uri.length() - 9); // recuperation du numero incremente										
			System.out.println(numIncr);
			return Integer.parseInt(numIncr); // conversion en int
		}
	}
	
	public static void main(String[] args) {
		ImageDaoMongo idm = new ImageDaoMongo();
		System.out.println(idm.getImageUriMax());
	}
}

