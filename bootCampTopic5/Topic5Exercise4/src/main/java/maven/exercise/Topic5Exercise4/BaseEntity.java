package maven.exercise.Topic5Exercise4;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

public abstract class BaseEntity {
	 
    @Id
    @Property("_id")
    protected ObjectId _id;
 
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return _id;
    }
 
    public void setId(String i) {
        this._id = new ObjectId(i);
    }
 

 
}