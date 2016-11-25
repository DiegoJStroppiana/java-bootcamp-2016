package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
	private static Connection connect = null;
	private static ConnectionDB connectionDB = null;

    
    private ConnectionDB() throws SQLException{ 
        try {
    		Class.forName("com.mysql.jdbc.Driver");
    	    connect = DriverManager.getConnection("jdbc:mysql://localhost/final_project","root","Globant2016");	    	    
    	  } catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	  }   	
    }
    public static ConnectionDB getInstance() throws SQLException{
    	if (connectionDB == null){
    		connectionDB = new ConnectionDB();
    	}
    	return connectionDB;
    }
    
   
    public Connection getConnection() throws SQLException{
    	return connect;
    }
    
    public void CloseConnection(){
    	connect = null;
    	connectionDB=null;
    }

}