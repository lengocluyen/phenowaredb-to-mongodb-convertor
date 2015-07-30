package org.data.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

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

	public int getImageUriNumIncrLastInserted(String datestr) {
		Document doc = null;
		//Document doc = collection.find().sort(Sorts.descending("_id")).first(); // dernier document image insere dans la base
		Calendar date = new GregorianCalendar();
		Date thedate;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
		try {
			thedate = fmt.parse(datestr.substring(0,23)); //rq : parse ne supporte par les microsecondes
			System.out.println("datestr : "+datestr);
			System.out.println("thedate : "+fmt.format(thedate));
			date.setTime(thedate);
			Calendar dateStartYear = new GregorianCalendar(date.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);  // premier jour de l'annee de date
			Calendar dateEndYear = new GregorianCalendar(date.get(Calendar.YEAR), Calendar.DECEMBER, 31, 23, 59, 59); // dernier jour de l'annee de date
			System.out.println("date : "+fmt.format(date.getTime())+"\n dateStartYear : "+fmt.format(dateStartYear.getTime())+"\n dateEndYear : "+fmt.format(dateEndYear.getTime()));
			doc = collection.find(Filters.and(
					Filters.gte("date", fmt.format(dateStartYear.getTime())),
					Filters.lte("date", fmt.format(dateEndYear.getTime())))
					).sort(Sorts.descending("_id")).first(); // dernier document image insere dans la base pour l'annee de datestr

			
		} catch (ParseException e) {
			System.out.println("Erreur : format de la date " + datestr + " incorrect. Par défaut, l'URI de cette image va être défini par rapport à l'année courante.");
			e.printStackTrace();
			doc = collection.find().sort(Sorts.descending("_id")).first(); // dernier document image insere dans la base
		}
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
	
	public String getDateMax(){
		//Document doc = collection.find().sort(Sorts.descending("date")).first(); // document avec date max
		Document doc = collection.find().sort(Sorts.descending("_id")).first(); //document avec date max puisque les docs sont inseres par ordre de date
		
		if (doc == null)  //pas encore de document image dans la base
			return "1900-01-01";
		
		String date = doc.getString("date"); // recuperation de la date
				
		if (date == null)  
			return "1900-01-01";
		else {
			return date;
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
//		System.out.println(idm.getImageUriNumIncrLastInserted("2015-03-12 12:00:08.342879"));
//		System.out.println("uri : "+idm.getImageUriFromId(903038));
//		System.out.println(idm.getImgidMax());
		System.out.println(idm.getDateMax());
	}
}

