package org.data.connection;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;

public class DAOSesame<T> {
	private final Repository rep; 
	private RepositoryConnection connection;
	
	public DAOSesame() throws RepositoryException{
		String sesameServer = "http://localhost:8080/openrdf-sesame/";
		String repositoryID = "plants";
		rep = new HTTPRepository(sesameServer, repositoryID);			  //Stockage triplestore Sesame
		rep.initialize();
		setConnection(rep.getConnection());
	}

	public RepositoryConnection getConnection() {
		return connection;
	}

	public void setConnection(RepositoryConnection connection) {
		this.connection = connection;
	}

	public Repository getRep(){
		return rep;
	}
}
