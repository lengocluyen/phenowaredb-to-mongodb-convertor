package org.data.connection;

import org.bson.Document;
import org.data.form.ImgProcProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class ImgProcProfileDaoMongo extends DAOMongo<ImgProcProfile>{
	private MongoCollection<Document> collection ;
	
	public ImgProcProfileDaoMongo(){
		super();
		this.setCollection(this.getDatabase()
				.getCollection("imageanalysisprocessing"));
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public int getImgprocprofileidMax(){
		Document doc = collection.find().sort(Sorts.descending("configuration.imgprocprofileid")).first(); // document avec imgprocprofileid max
		
		if (doc == null)
			return 0;
		
		Integer imgprocprofileid = ((Document) doc.get("configuration")).getInteger("imgprocprofileid"); // recuperation de l'imgprocprofileid
				
		if (imgprocprofileid == null)  //pas encore de document profil d'analyse dans la base
			return 0;
		else {
			return imgprocprofileid;
		}
	}
}
