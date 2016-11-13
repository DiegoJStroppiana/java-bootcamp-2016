package maven.exercise.Topic5Exercise4;

import org.mongodb.morphia.annotations.Embedded;

public class Course extends BaseEntity{
	
	private String course_name;
	@Embedded
	private Teacher id_teacher;
	private Integer hours_by_week;


	public String getCourse_Name() {
		return course_name;
	}
	public void setCourse_Name(String course_name) {
		this.course_name = course_name;
	}
	public Teacher getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(Teacher id_teacher) {
		this.id_teacher = id_teacher;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getHours_by_week() {
		return hours_by_week;
	}
	public void setHours_by_week(Integer hours_by_week) {
		this.hours_by_week = hours_by_week;
	}
	
	
}
