package com.github.brandon.market;

import com.github.brandon.market.io.FileParser;
import com.github.brandon.market.inventory.Product;
import com.github.brandon.market.jdbc.Jdbc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program-0 Market Inventory
 *
 */
public class Market {

    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\n******************************************");
        System.out.println(" What do you want to do?");
        System.out.println(" 1 - See Inventory");
        System.out.println(" 2 - Add new Product to the Inventory");
        System.out.println(" 3 - Buy Product (Increase Quantity)");
        System.out.println(" 4 - Client Purchase (Decrease Quantity)");
        System.out.println(" 0 - Close the program");
        System.out.println("******************************************\n");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                Product.showInv();
                break;
            case 2:
                Product.addInv();
                break;
            case 3:
                Product.buyInv();
                break;
            case 4:
                Product.sellInv();
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
        //FileParser.read();

        System.out.println("\n \nWelcome to Market Inventory Program");
        menu();
    }
}
