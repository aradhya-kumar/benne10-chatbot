package com.cerebro;    

import org.apache.commons.csv.*; // For parsing CSV files
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FAQData {

    // Inner class to represent a Question-Answer pair
    public static class QA {
        String question;
        String answer;

        // Constructor to initialize question and answer
        public QA(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    // Method to load FAQ data from a CSV file and return a list of QA pairs
    public static List<QA> loadData(String filePath) throws IOException {
        List<QA> faqList = new ArrayList<>(); 

        // Create a Reader to read the CSV file with UTF-8 encoding
        Reader in = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);

        // Parse the CSV file assuming the first line contains headers
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader() 
                .parse(in);

        // Iterate over each CSV record (row)
        for (CSVRecord record : records) {
            
            String question = record.get("question");
            String answer = record.get("answer");

            faqList.add(new QA(question, answer));
        }

        return faqList; 
    }
}
