package com.github.brandon.market;

import com.github.brandon.market.io.FileParser;
import com.github.brandon.market.inventory.Product;
import com.github.brandon.market.jdbc.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program-0 Market Inventory
 *
 */
public class Market {

    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n**************************************");
        System.out.println("What do you want to do?");
        System.out.println("1 - See inventory");
        System.out.println("2 - Add to inventory");
        System.out.println("0 - Close the program");
        System.out.println("**************************************\n");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                Product.showInvMA();
                break;
            case 2:
                Product.addInv();
                break;
            case 0:
                System.exit(0);
            default:
                break;
        }

        menu();
    }

    public static void main(String[] args) {

        // FileParser.write();
        FileParser.read();
/*
        try (
            Connection connection2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "mydb", "mydb"                );
            Statement statement = connection2.createStatement();
        ){
            //int rowCount = statement.executeUpdate("insert into Products values (4,'cheese',9);");

            ResultSet inv = statement.executeQuery("select * from Products;");

            // Loop through ResultSet for each row returned
            while(inv.next()) {
                System.out.println(inv.getInt("prod_id") + " | " + inv.getString("prod_name") + " | " + inv.getInt("prod_qty"));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
*/
        //ArrayList historyInput = new ArrayList();

        System.out.println("\n \nWelcome to Market Inventory Program");
        menu();
    }
}
