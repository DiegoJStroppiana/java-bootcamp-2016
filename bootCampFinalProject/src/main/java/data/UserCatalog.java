package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.User;



public class UserCatalog {
	
	private Statement statement;
	private ResultSet resultSet;
	private static UserCatalog userCatalog = null;
	
	
	private UserCatalog() {
	}
	
	public static UserCatalog getInstance() {
		if (userCatalog == null) {
			userCatalog = new UserCatalog();
		}
		return userCatalog;
	}
	
	
	public boolean newUser(String nick_name, String password, String first_name, String last_name) throws SQLException{
		Connection connect = ConnectionDB.getInstance().getConnection();
		User u = getUser(nick_name);
		if(u==null){			
			  String query = " INSERT INTO user (nick_name, password, first_name, last_name)"
			        + " VALUES (?, ?, ?, ?)";
		      PreparedStatement preparedStmt = connect.prepareStatement(query);
		      preparedStmt.setString (1, nick_name);
		      preparedStmt.setString (2, password);
		      preparedStmt.setString (3, first_name);
		      preparedStmt.setString (4, last_name);	
		      preparedStmt.execute();	
		return true;
		}
		return false;
		
	}
	
	public User getUser(String nick_name) throws SQLException{
		Connection connect = ConnectionDB.getInstance().getConnection();
		statement = connect.createStatement();
	    resultSet = statement.executeQuery("SELECT * FROM user WHERE nick_name='"+nick_name+"'");
	    if(!resultSet.next()){
	    	return null;
	    	}
		User u = new User(resultSet.getInt("user.id_user"),
					resultSet.getString("user.nick_name"),
					resultSet.getString("user.password"),
					resultSet.getString("user.first_name"),
					resultSet.getString("user.last_name"));
		return u;
		
	}
}
