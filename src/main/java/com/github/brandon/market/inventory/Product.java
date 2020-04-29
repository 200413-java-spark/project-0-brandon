package com.github.brandon.market.inventory;

import java.lang.*;
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
            while (qty < 0) {
                System.out.println("Product Quantity cannot be less than 0. Please type again:");
                qty = scanner.nextInt();
            }
            preStatement.setInt(2, qty);
            preStatement.addBatch();
            scanner.skip("\n");

            preStatement.executeBatch();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static int checkIdUpdate(int idSc) {
        int qtyVer;
        try ( Connection connection = Jdbc.getConnection();
            Statement verStatement = connection.createStatement();) 
        {
            ResultSet rs = verStatement.executeQuery("select * from Products;");
            while(rs.next()) {
                if (idSc == rs.getInt("prod_id")){
                    qtyVer = rs.getInt("prod_qty");
                    return qtyVer;
                }
            }
            return -1;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return -1;
    }

    public static void buyInv(){
        int idSc=-1;
        int idVer;
        int qtyVer = -1;
        int qty = 0;
        int value;
        String query = "update Products set prod_qty=? where prod_id=?;";

        try (Connection connection = Jdbc.getConnection();
            PreparedStatement preStatement = connection.prepareStatement(query);
            Statement statement = connection.createStatement();)
        {
            //Selecting first to know what's stored before updating
            ResultSet inv = statement.executeQuery("select * from Products;");
            System.out.println("id | Name   | Quantity\n");
            while(inv.next()) {
                System.out.println(inv.getInt("prod_id") + " | " + inv.getString("prod_name") + " | " + inv.getInt("prod_qty"));
            }
            ResultSet rs = statement.executeQuery("select * from Products;");

            //Where update starts
            while (qtyVer == -1) {
                System.out.println("Type ID for Product that was bought (Increase Inventory). Must be a valid ID: ");
                idSc = scanner.nextInt();
                qtyVer = checkIdUpdate(idSc);
            }
            
            while (qty <1) {
                System.out.println("Type the quantity that was bought. It must be at least one: ");
                qty = scanner.nextInt();
            }
            int sum = Integer.sum(qty, qtyVer);
            preStatement.setInt(1, sum);
            preStatement.setInt(2, idSc);
            preStatement.addBatch();
            scanner.skip("\n");

            preStatement.executeBatch();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void sellInv(){
        int idSc=-1;
        int idVer;
        int qtyVer = -1;
        int qty = 0;
        int value;
        String query = "update Products set prod_qty=? where prod_id=?;";

        try (Connection connection = Jdbc.getConnection();
            PreparedStatement preStatement = connection.prepareStatement(query);
            Statement statement = connection.createStatement();)
        {
            //Selecting first to know what's stored before updating
            ResultSet inv = statement.executeQuery("select * from Products;");
            System.out.println("id | Name   | Quantity\n");
            while(inv.next()) {
                System.out.println(inv.getInt("prod_id") + " | " + inv.getString("prod_name") + " | " + inv.getInt("prod_qty"));
            }
            ResultSet rs = statement.executeQuery("select * from Products;");

            //Where update starts
            while (qtyVer == -1) {
                System.out.println("Type ID of the Product Purchased by Client (Inventory Decrease). Must be a valid ID: ");
                idSc = scanner.nextInt();
                qtyVer = checkIdUpdate(idSc);
            }

            int sub = -1;

            while ((qty <1) && (sub<0)) {
                System.out.println("Type the quantity Purchased by the client. Must be at least one: ");
                qty = scanner.nextInt();
                sub = qtyVer - qty;
            }
            int sum = Integer.sum(qty, qtyVer);
            preStatement.setInt(1, sub);
            preStatement.setInt(2, idSc);
            preStatement.addBatch();
            scanner.skip("\n");

            preStatement.executeBatch();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void verSellInv(){

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
