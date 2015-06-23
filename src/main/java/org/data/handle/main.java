package org.data.handle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;

import info.aduna.iteration.Iterations;

import org.data.connection.WeighingresultDao;
import org.data.form.Weighingresult;
import org.data.jsonconvertor.Convertor;
import org.data.jsonconvertor.JsonReadWrite;
import org.json.simple.JSONObject;
import org.openrdf.*;
import org.openrdf.model.Model;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.model.vocabulary.FOAF;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.model.vocabulary.XMLSchema;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryResult;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.Rio;
import org.openrdf.sail.memory.MemoryStore;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExportJsonData();
	}
	public static void ExportJsonData(){
		String file = "test.json";
		WeighingresultDao wrd = new WeighingresultDao(null);
		ResultSet rs = wrd.resultSet();
		List<LinkedHashMap<String,Object>> jsons = Convertor.WeighingResultConvertToJson(rs);
		JsonReadWrite jrw = new JsonReadWrite();
		jrw.WriteToFile(jsons, file,true);
	}
	public static void TestSQLConnection(){
		WeighingresultDao wrd = new WeighingresultDao(null);
		List<Weighingresult> rsw = wrd.all();
		for(Weighingresult i: rsw){
			System.out.print(i.getWeighingid()+"\t");
			System.out.print(i.getStudyname()+"\t");
			System.out.print(i.getTaskid()+"\t");
			System.out.print(i.getTagname()+"\t");
			System.out.print(i.getPlantid()+"\t");
			System.out.print(i.getResultdate()+"\t");
			System.out.print("\n");
		}
	}
	public static void TestRDFStore() {
		try {
			//

			Repository rep = new SailRepository(new MemoryStore());
			rep.initialize();
			ValueFactory f = rep.getValueFactory();
			String namespace = "http://example.org";
			URI john = f.createURI(namespace, "john");
			RepositoryConnection conn = rep.getConnection();

			conn.add(john, RDF.TYPE, FOAF.PERSON);
			conn.add(john, RDFS.LABEL,
					f.createLiteral("John", XMLSchema.STRING));
			RepositoryResult<Statement> statements = conn.getStatements(null,
					null, null, true);
			Model model = Iterations.addAll(statements, new LinkedHashModel());
			model.setNamespace("rdf", RDF.NAMESPACE);
			model.setNamespace("rdfs", RDFS.NAMESPACE);
			model.setNamespace("xsd", XMLSchema.NAMESPACE);
			model.setNamespace("foaf", FOAF.NAMESPACE);
			model.setNamespace("ex", namespace);
			Rio.write(model, System.out, RDFFormat.TURTLE);
			conn.close();
		} catch (Exception ex) {

		}
	}

}
