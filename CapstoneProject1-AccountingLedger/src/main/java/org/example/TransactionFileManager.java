package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {

    public static List<Transaction> readFile(){
        try{
            java.io.FileReader fileReader = new java.io.FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //skip the first line
            bufferedReader.readLine();

            String input;

            List<Transaction> transactions = new ArrayList<>();
            while ((input = bufferedReader.readLine()) != null){
                String[] row = input.split("\\|");

                LocalDate date = LocalDate.parse(row[0]);
                LocalTime time = LocalTime.parse(row[1]);
                String description = row[2];
                String vendor = row[3];
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(row[4]));
                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }

            bufferedReader.close();

            return transactions;
        }
        catch (IOException ex){
            System.out.println("Failed to load csv file");
            return new ArrayList<>();
        }
    }


    public static void appendTransaction(Transaction transaction) {
        String filePath = "src/main/resources/transactions.csv";
        File file = new File(filePath);

        try {
            // Step 1: Make sure the folder exists
            File folder = file.getParentFile();
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Step 2: Check if file exists and is empty
            boolean fileExists = file.exists();
            boolean isEmpty = !fileExists || file.length() == 0;

            // Step 3: Open file in append mode
            FileWriter writer = new FileWriter(file, true);

            // Step 4: Write header if it's a new or empty file
            if (isEmpty) {
                writer.write("date|time|description|vendor|amount\n");
            }

            // Step 5: Write the transaction
            writer.write(transaction.toString() + "\n");

            // Step 6: Close the writer
            writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong while saving the transaction.");
            e.printStackTrace();
        }
    }
}


