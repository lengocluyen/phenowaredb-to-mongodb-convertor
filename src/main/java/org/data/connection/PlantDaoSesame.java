package org.data.connection;

import org.data.form.Plant;
import org.openrdf.OpenRDFException;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryException;

public class PlantDaoSesame extends DAOSesame<Plant>{

	public PlantDaoSesame() throws RepositoryException{
		super();
	}
	
	public String getURIFromAlias(String alias){
		String uri ="";
		try {
			   ValueFactory factory = this.getRep().getValueFactory();
			  
				  String query = "SELECT ?plant  WHERE { ?plant <http://www.phenome-fppn.fr/object#hasAlias> ?alias } ";
				  TupleQuery tupleQuery = this.getConnection().prepareTupleQuery(QueryLanguage.SPARQL, query);
				  tupleQuery.setBinding("alias", factory.createLiteral(alias));
				  TupleQueryResult result = tupleQuery.evaluate();
				  try {
			              //while (result.hasNext()) {  // iterate over the result
						BindingSet bindingSet = result.next();
						uri = bindingSet.getValue("plant").stringValue();
			             // }
				  }
				  catch(Exception e){
					  System.out.println("plantAlias : " + alias);
					  e.printStackTrace();
				  }
				  finally {
				      result.close();
				  }
			}
			catch (OpenRDFException e) {
				e.printStackTrace();
			}
		return uri ;
	}
	
	public static void main(String[] args)  {
		try {
			PlantDaoSesame pds = new PlantDaoSesame();
			try{
				System.out.println(pds.getURIFromAlias("1713/PH207/ZM3839/WW/7/Loop25/ARCH2015-04-13"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				pds.getConnection().close();
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
