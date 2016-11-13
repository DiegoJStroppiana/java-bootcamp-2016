package maven.exercise.Topic5Exercise4;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class Teacher extends BaseEntity{
	

	private String last_name;
	private String first_name;
	private Date date_of_birth;
	

	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	

}
