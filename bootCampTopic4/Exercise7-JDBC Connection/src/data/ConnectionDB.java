package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class ConnectionDB {
	  private Connection connect = null;
      private Statement statement = null;
      private ResultSet resultSet = null;
     
      public ConnectionDB() throws SQLException{
      try {
		Class.forName("com.mysql.jdbc.Driver");
	    connect = DriverManager.getConnection("jdbc:mysql://localhost/high_school","root","Globant2016");    
	  } catch (ClassNotFoundException e) {
		e.printStackTrace();
	  }

      }
      
      public void consultTeachers(){
          try {
			statement = connect.createStatement();
	        resultSet = statement
                      .executeQuery("SELECT teacher.last_name, teacher.first_name, day_of_the_week, start_time, end_time, course_name"
                    		  +" FROM teacher INNER JOIN course on teacher.id_teacher=course.id_teacher"
                    		  +" INNER JOIN schedule_time st ON st.id_course=course.id_course"
                    		  +" WHERE teacher.id_teacher=1"
                    		  +" ORDER BY st.day_number");
	        writeResultSet(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
      }
      
      private void writeResultSet(ResultSet resultSet) throws SQLException {
    	  resultSet.next();
    	  String teacherLastName = resultSet.getString("teacher.last_name");
          String teacherFirstName = resultSet.getString("teacher.first_name");
    	  System.out.println("Teacher: " + teacherLastName + ", " + teacherFirstName);
    	  System.out.println("Schedule: ");
    	  resultSet.previous();
          while (resultSet.next()) {           
                  String dayOfTheWeek = resultSet.getString("day_of_the_week");
                  Time startTime = resultSet.getTime("start_time");
                  Time endTime = resultSet.getTime("end_time");
                  String courseName = resultSet.getString("course_name");
                  System.out.println(dayOfTheWeek + " " + startTime + " " + endTime +" " + courseName);
          }
  }      
}

