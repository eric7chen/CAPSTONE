package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseCsv {
    
    private static String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("requires 1 argument of csv file");
            return;
        }

        List<List<String>> records = new ArrayList<List<String>>();
        String csv = args[0];
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
           String line;
           while((line = reader.readLine()) != null) {
               String[] values = line.split(COMMA_DELIMITER);
               records.add(Arrays.asList(values));
           }
           reader.close();
           
        } catch (IOException e) {
            if (e.getClass() == FileNotFoundException.class) {
                System.err.println("no such file");
            } else {
                System.err.println(e.toString());
            }
        }


    }
}