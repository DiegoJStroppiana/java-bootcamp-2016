package maven.exercise.Topic5Exercise4;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

public class InscriptionDAO extends BasicDAO<Inscription,String>{

	protected InscriptionDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}

}
