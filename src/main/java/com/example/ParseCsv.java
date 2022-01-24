package com.example;

import java.io.BufferedReader;
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
           
           for (List<String> record : records) {
               for (String entry : record) {
                   System.out.print(entry + ",");
               }
               System.out.print("\n");
           }
        } catch (IOException e) {
            System.err.println(e.toString());
        }


    }
}