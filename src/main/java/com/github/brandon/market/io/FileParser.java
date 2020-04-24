package com.github.brandon.market.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileParser {
    static File file = new File("file.txt");

    public static void write(){
        //Print to file
        try  (  FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw); )  
        {   // this is a try with an argument list, because it's inside the () 
            //it assures that everything inside the () gets closed once this try is finished
            //this way we don't need to create a finally block and place the close inside

            pw.println("Printing on File");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public static void write(String var){
        //Print to file
        try  (  FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw); )  
        {   // this is a try with an argument list, because it's inside the () 
            //it assures that everything inside the () gets closed once this try is finished
            //this way we don't need to create a finally block and place the close inside

            pw.println(var);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public static void read(){
        //Read from file
		try  (  FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr); )
        {
            String line = br.readLine();
            while (br.readLine() != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}