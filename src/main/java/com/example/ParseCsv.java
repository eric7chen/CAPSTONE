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
        List<List<String>> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("English-Grid view.csv"));) {
           String line;
           while((line = reader.readLine()) != null) {
               String[] values = line.split(COMMA_DELIMITER);
               records.add(Arrays.asList(values));
           }
        } catch (IOException e) {
            System.err.println(e);
        }

        for (List<String> list : records) {
            for (String str : list) {
                System.out.print(str + ", ");
            }
            System.out.println();
        }

        System.out.println();

        List<List<String>> esRecords = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Spanish-Grid view.csv"));) {
           String line;
           while((line = reader.readLine()) != null) {
               String[] values = line.split(COMMA_DELIMITER);
               esRecords.add(Arrays.asList(values));
           }
        } catch (IOException e) {
            System.err.println(e);
        }

        for (List<String> list : esRecords) {
            for (String str: list) {
                System.out.print(str + ", ");
            }
            System.out.println();
        }
        
    }
}