package main;

import java.sql.SQLException;

import data.ConnectionDB;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
			new ConnectionDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
