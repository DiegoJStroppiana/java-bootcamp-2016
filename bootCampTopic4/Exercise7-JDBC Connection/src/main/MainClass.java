package main;

import java.sql.SQLException;

import data.ConnectionDB;

public class MainClass {

	public static void main(String[] args) {
	    try {
			ConnectionDB connection = new ConnectionDB();
			connection.consultTeachers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
