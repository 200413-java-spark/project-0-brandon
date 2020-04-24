package com.github.brandon.market.inventory;

import java.util.Scanner;

import com.github.brandon.market.io.FileParser;

public class Product {

    static Scanner scanner = new Scanner(System.in);
    static String[][] inv = new String[3][2];

    public static void addInv() {
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

    public static void showInv() {
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