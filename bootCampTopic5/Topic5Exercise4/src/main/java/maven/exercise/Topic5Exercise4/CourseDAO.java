package maven.exercise.Topic5Exercise4;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

public class CourseDAO extends BasicDAO<Course,String>{

	protected CourseDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
		// TODO Auto-generated constructor stub
	}

}
