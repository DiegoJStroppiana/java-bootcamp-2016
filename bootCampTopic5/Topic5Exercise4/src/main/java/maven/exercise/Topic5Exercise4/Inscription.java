package maven.exercise.Topic5Exercise4;

import org.bson.types.ObjectId;


public class Inscription  extends BaseEntity{
	
	private ObjectId id_course;	
	private ObjectId id_student;
	
	
	private int year, first_note, second_note, third_note, final_note;
	
	public ObjectId getStudent() {
		return id_student;
	}
	public void setStudent(ObjectId id_student) {
		this.id_student = id_student;
	}
	public ObjectId getCourse() {
		return id_course;
	}
	public void setCourse(ObjectId course) {
		this.id_course = course;
	}
	public int getFirst_note() {
		return first_note;
	}
	public void setFirst_note(int first_note) {
		this.first_note = first_note;
	}
	public int getSecond_note() {
		return second_note;
	}
	public void setSecond_note(int second_note) {
		this.second_note = second_note;
	}
	public int getThird_note() {
		return third_note;
	}
	public void setThird_note(int third_note) {
		this.third_note = third_note;
	}
	public int getFinal_note() {
		return final_note;
	}
	public void setFinal_note(int final_note) {
		this.final_note = final_note;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
