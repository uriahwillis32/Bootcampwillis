package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Ledger {

    // Custom Search
    public static void customSearch(List<Transaction> transactions, Scanner scanner) {
        System.out.println("What is the Start Date for your search? (yyyy-MM-dd)\nType here: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.println("What is the End Date for your search? (yyyy-MM-dd)\nType here: ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter Description:\nType here:");
        String descriptionInput = scanner.nextLine().trim().toLowerCase();

        System.out.println("What is the vendor name?\nType here: ");
        String vendorInput = scanner.nextLine();

        System.out.println("What is the Minimum amount?\nType here: ");
        BigDecimal minimum = new BigDecimal(scanner.nextLine());

        System.out.println("What is the Maximum amount?\nType here: ");
        BigDecimal maximum = new BigDecimal(scanner.nextLine());

        System.out.println("Searching for matching transactions...\n");

        for (Transaction transaction : transactions) {
            BigDecimal amount = transaction.getAmount();
            LocalDate transactionDate = transaction.getDate(); // Declare transactionDate here

            // Compare vendor, amount, and dates
            if (vendorInput.equalsIgnoreCase(transaction.getVendor())
                    && amount.compareTo(minimum) >= 0
                    && amount.compareTo(maximum) <= 0
                    && descriptionInput.equalsIgnoreCase(transaction.getDescription())
                    && (transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate))
                    && (transactionDate.isEqual(endDate) || transactionDate.isBefore(endDate))) {
                System.out.println(transaction);
            }
        }
    }





    //Home screen options

    public static void addDeposit(List<Transaction> transactions, Scanner scanner) {
        // Here you will prompt for deposit details
        // how much  is the deposit amount?
        //Ask for vendor, amount, description
        System.out.println("\n(/Make Deposit/)");

        System.out.println("\nEnter Person/Vendor/Company name:");
        String vendor = scanner.nextLine().trim();

        System.out.println("\nEnter your payment amount:");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Deposit entered cant be negative and must be more than 0.");
        }

        String description = "Deposit Sent";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction deposit = new Transaction(date, time, description, vendor, amount);

        TransactionFileManager.appendTransaction(deposit);
        transactions.add(deposit);

        System.out.println("Deposit successfully added.");

    }


    public static void makePayment(List<Transaction> transactions, Scanner scanner) {
        // Same as the deposit but you are subtracting money.( - )
        System.out.println("\n(/Make Payment/)");

        System.out.println("\nEnter Person/Vendor/Company name:");
        String vendor = scanner.nextLine().trim();

        System.out.println("\nEnter your payment amount:");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        amount = amount.multiply(BigDecimal.valueOf(-1));

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Deposit entered cant be negative and must be more than 0.");

        }
        String description = "Payment Sent";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction payment = new Transaction(date, time, description, vendor, amount);

        TransactionFileManager.appendTransaction(payment);
        transactions.add(payment);

        System.out.println("Payment successfully added.");


    }


    //View Ledger menu options

    public static void viewAllLedger(List<Transaction> transactions ) {
        System.out.println("Here is a list of your transaction history...");
        for (Transaction transaction : transactions) {
            System.out.println(" | Date: " + transaction.getDate() +
                    " | Time: " + transaction.getTime() +
                    " | Description: " + transaction.getDescription() +
                    " | Vendor: " + transaction.getVendor() +
                    " | Amount: $" + transaction.getAmount());
            ;
        }
    }


    public static void depositsFilter(List<Transaction> transactions) {

        for (Transaction transaction : transactions) {
            if (transaction.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }

    public static void paymentsFilter(List<Transaction> transactions) {

        for (Transaction transaction : transactions) {
            if (transaction.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }


    // report menu options



    public static void monthToDate(List<Transaction> transactions) {
        LocalDate today = LocalDate.now();

        System.out.println("Month To Date Transaction");

        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();

            if (date.getMonth() == today.getMonth() && date.getYear() == today.getYear()) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }

    public static void previousMonth(List<Transaction> transactions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        System.out.println("Previous Month Transactions");

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getMonth() == lastMonth.getMonth() &&
                    transaction.getDate().getYear() == lastMonth.getYear()) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }


    public static void yearToDate(List<Transaction> transactions) {
        int currentYear = LocalDate.now().getYear();

        System.out.println("Year to Date Transactions");

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == currentYear) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }

    public static void previousYear(List<Transaction> transactions) {
        int lastYear = LocalDate.now().minusYears(1).getYear();

        System.out.println("Previous Year Transactions");

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == lastYear) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }

    public static void searchByVendor(List<Transaction> transactions, Scanner scanner) {
        System.out.print("Enter vendor name to search: ");
        String input = scanner.nextLine().trim().toLowerCase();

        System.out.println(" Transactions for given Vendor: ");

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().toLowerCase().contains(input)) {
                System.out.println(" | Date: " + transaction.getDate() +
                        " | Time: " + transaction.getTime() +
                        " | Description: " + transaction.getDescription() +
                        " | Vendor: " + transaction.getVendor() +
                        " | Amount: $" + transaction.getAmount());
            }
        }
    }

}




