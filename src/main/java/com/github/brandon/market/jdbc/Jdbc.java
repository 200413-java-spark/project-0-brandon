package com.github.brandon.market.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

    private static Jdbc instance;
    private String url;
    private String username;
    private String password;

    private Jdbc() {
        url = System.getProperty("database.url", "jdbc:postgresql://localhost:5432/mydb");
        username = System.getProperty("database.username", "mydb");
        password = System.getProperty("database.password", "mydb");
    }

    public static Jdbc getInstance() {
        if (instance == null) {
            instance = new Jdbc();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }    
/*
    public Connection connectionTest(){
        try (
            // Be sure to close all connections after use
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
        ){
            // executeUpdate() returns the number of rows affected for DML
            int rowCount = statement.executeUpdate("insert into Products values (4,'cheese',9)");
    
            // executeQuery() returns a ResultSet object for queries
            ResultSet inv = statement.executeQuery("select * from Products");
    
            // Loop through ResultSet for each row returned
            while(inv.next()) {
                System.out.println(inv.getInt("id"));
                System.out.println(inv.getString("Item"));
                System.out.println(inv.getInt("Quantity"));
            }
    
        } catch (SQLException ex) {
            
        } 
    
    }
*/

/*
    {

    // Loading the driver may not be necessary, but it's good to specify
    try {
        Class.forName("org.postgresql.Driver");
    } catch (java.lang.ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }

    // Pay attention to the url pattern
    String url = "jdbc:postgresql://localhost:5432/mydb";
    String username = "mydb";
    String password = "mydb";

    try (
        // Be sure to close all connections after use
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
    ){
        // executeUpdate() returns the number of rows affected for DML
        int rowCount = statement.executeUpdate("insert into Products values (4,'cheese',9)");

        // executeQuery() returns a ResultSet object for queries
        ResultSet inv = statement.executeQuery("select * from Products");

        // Loop through ResultSet for each row returned
        while(inv.next()) {
            System.out.println(inv.getInt("id"));
            System.out.println(inv.getString("Item"));
            System.out.println(inv.getInt("Quantity"));
        }

    } catch (SQLException ex) {
        
    } 
    
}*/
}
