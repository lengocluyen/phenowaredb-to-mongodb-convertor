package org.data.connection;

import org.bson.Document;
import org.data.form.ImgProcProfile;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class ImgProcProfileDaoMongo extends DAOMongo<ImgProcProfile>{

	public ImgProcProfileDaoMongo(){
		super();
	}
	
	public int getImgprocprofileidMax(){
		MongoCollection<Document> collection = this.getDatabase()
				.getCollection("imageanalysisprocessing");

		Document doc = collection.find().sort(Sorts.descending("configuration.imgprocprofileid")).first(); // document avec imgprocprofileid max
		
		Integer imgprocprofileid = ((Document) doc.get("configuration")).getInteger("imgprocprofileid"); // recuperation de l'imgprocprofileid
				
		if (imgprocprofileid == null)  //pas encore de document profil d'analyse dans la base
			return 0;
		else {
			return imgprocprofileid;
		}
	}
}
