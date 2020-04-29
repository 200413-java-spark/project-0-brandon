package com.github.brandon.market.inventory;

import java.util.Scanner;
import java.sql.*;

import com.github.brandon.market.io.FileParser;
import com.github.brandon.market.jdbc.Jdbc;

public class Product {
    private Jdbc jdbc;

    private String name;
    private int qty;

    static Scanner scanner = new Scanner(System.in);
    static String[][] inv = new String[3][2];

    public String getName(){
        return name;
    }

    public int getQty(){
        return qty;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    public static void addInv(){
        //Jdbc connection = Jdbc.getInstance(); 
        //Connection connection = Jdbc.getConnection();
        //
        String name;
        int qty;
        String query = "insert into Products (prod_name,prod_qty) values (?,?);";

        try (Connection connection = Jdbc.getConnection();
            PreparedStatement preStatement = connection.prepareStatement(query);) 
        {
            System.out.println("Type Product Name: ");
            name = scanner.nextLine();
            preStatement.setString(1, name);
            System.out.println("Type Product Quantity: ");
            qty = scanner.nextInt();
            preStatement.setInt(2, qty);

            preStatement.executeBatch();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void showInv(){
        try (
            Connection connection = Jdbc.getConnection();
            Statement statement = connection.createStatement();
        ){
            ResultSet inv = statement.executeQuery("select * from Products;");
            System.out.println("id | Name    | Quantity\n");

            // Loop through ResultSet for each row returned
            while(inv.next()) {
                System.out.println(inv.getInt("prod_id") + " | " + inv.getString("prod_name") + " | " + inv.getInt("prod_qty"));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void addInvMA() {
        int i = 0;
        int j = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 2; j++) {
                if (j==0) {
                    System.out.println("Enter the name of the product number " + (i+1));
                    inv[i][j] = scanner.nextLine();
                    FileParser.write(inv[i][j]);
                } else if (j==1) {
                    System.out.println("Enter the quantity for product " + (i+1));
                    inv[i][j] = scanner.nextLine();
                    FileParser.write(inv[i][j]);
                }
            }
        }
    }

    public static void showInvMA() {
        int i = 1;
        int j = 1;

        for (i=0; i<=2; i++){
            for (j=0; j<=1; j++) {
                if (j==0) {
                    System.out.println((i+1) + " - Product name: " + inv[i][j]);
                } else if (j==1) {
                    System.out.println((i+1) + " - Product quantity: " + inv[i][j]);
                }
            }
        }
    }

}