package org.data.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DAOMongo<T> {
	private MongoClient mongoClient;
	private MongoDatabase database;

	public DAOMongo(){
		this.mongoClient = new MongoClient( "147.99.7.150" , 27017 );

		this.setDatabase(this.mongoClient.getDatabase("phis2015"));
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}
}
