package com.github.brandon.market;

import java.util.Scanner;
/**
 * Program-0  Market Inventory
 *
 */
public class Market {

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
                } else if (j==1) {
                    System.out.println("Enter the quantity for product " + (i+1));
                    inv[i][j] = scanner.nextLine();
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

    public static void menu(){
        System.out.println("\n \nWhat do you want to do?");
        System.out.println("1 - See inventory");
        System.out.println("2 - Add to inventory");
        System.out.println("0 - Close the program \n \n");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                showInv();
                break;
            case 2:
                addInv();
                break;
            case 0:
                System.exit(0);
            default:
                break;
        }

        menu();     
    }

    public static void main(String[] args) {
        System.out.println("\n \n Welcome to Market Inventory Program");
        menu();
    }
}
