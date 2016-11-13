package maven.exercise.Topic5Exercise4;

import java.util.Date;

public class Student  extends BaseEntity {
	private String first_name, last_name;
	private Date birth_date;

	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirthDate() {
		return birth_date;
	}
	public void setBirthDate(Date birth_date) {
		this.birth_date = birth_date;
	}
}
