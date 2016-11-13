package maven.exercise.Topic5Exercise4;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String dbName = new String("high_school_mongodb");
        MongoClient mongo = new MongoClient();
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongo, dbName);     
        morphia.mapPackage("maven.exercise.Topic5Exercise4");
               
        
        InscriptionDAO inscriptionDAO = new InscriptionDAO(mongo, morphia, dbName);
    	Query<Inscription> query = datastore.createQuery(Inscription.class);
        query.and(       
          query.criteria("final_note").greaterThan(4),
          query.criteria("id_course").equal(new ObjectId("000000000000000000000001")),
          query.criteria("year").equal(2015)
          
        );        
        QueryResults<Inscription> inscriptionGreaterThanFour =  inscriptionDAO.find(query); 
        
        StudentDAO studentDAO = new StudentDAO(mongo,morphia,dbName);
              
        
        for (Inscription ins : inscriptionGreaterThanFour) {
        	Query<Student> query2 = datastore.createQuery(Student.class);
        	query2.and(       
        			query2.criteria("_id").equal(ins.getStudent())
        	        );    
            QueryResults<Student> student= studentDAO.find(query2); 
            System.out.println("First name: " + student.get().getFirst_name() + " Last name: " + student.get().getLast_name() + " Final note: " + ins.getFinal_note());
        } 
    }
}
