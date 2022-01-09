package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmetsahin
 */
public class Database {

    private String dbUrl = "jdbc:mysql://localhost:3306/hastane";
    private String dbUser = "root";
    private String dbPassword = "root";
    private String dbDriver = "com.mysql.jdbc.Driver";

    public void loadDriver() {
	try {
	    Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public Connection getConnection() {
	Connection connection = null;
	try {
	    this.loadDriver();
	    connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return connection;

    }
    
}
