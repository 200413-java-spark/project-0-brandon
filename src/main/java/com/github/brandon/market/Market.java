package com.github.brandon.market;

import com.github.brandon.market.io.FileParser;
import com.github.brandon.market.inventory.Product;
import com.github.brandon.market.jdbc.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program-0 Market Inventory
 *
 */
public class Market {

    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n \nWhat do you want to do?");
        System.out.println("1 - See inventory");
        System.out.println("2 - Add to inventory");
        System.out.println("0 - Close the program \n \n");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                Product.showInv();
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

        Connection connection = null;
        
        try {
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "mydb", "mydb");
            if (connection != null){
                System.out.println("Connected");
            } else {
                System.out.println("Not connected");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
 
        //ArrayList historyInput = new ArrayList();

        System.out.println("\n \n Welcome to Market Inventory Program");
        menu();
    }
}
