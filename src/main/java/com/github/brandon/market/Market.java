package com.github.brandon.market;

import com.github.brandon.market.io.FileParser;
import com.github.brandon.market.inventory.Product;

import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Program-0  Market Inventory
 *
 */
public class Market {

    static Scanner scanner = new Scanner(System.in);

    public static void menu(){
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

        FileParser.write();
        FileParser.read();
 
        //ArrayList historyInput = new ArrayList();

        System.out.println("\n \n Welcome to Market Inventory Program");
        menu();
    }
}
