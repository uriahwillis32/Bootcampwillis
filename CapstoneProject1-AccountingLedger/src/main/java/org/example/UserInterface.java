package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static boolean running = true;

    public static void main(String[] args) {

        List<Transaction> transactions = TransactionFileManager.readFile();
        Scanner scanner = new Scanner(System.in);




        while (running) {
            displayHomeScreen();
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    Ledger.addDeposit(transactions, scanner);
                    break;
                case "B":
                    Ledger.makePayment(transactions, scanner);
                    break;
                case "C":
                    showLedgerMenu(transactions, scanner);
                    break;
                case "D":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayHomeScreen() {
        System.out.println("\n\\\\ Financial Ledger Home \\\\");
        System.out.println("A) Add Deposit");
        System.out.println("B) Make Payment (Debit)");
        System.out.println("C) View Ledger");
        System.out.println("D) Exit");
        System.out.print("Enter your choice: ");
    }



    private static void showLedgerMenu(List<Transaction> transactions, Scanner scanner) {
        boolean useLedgerMenu = true;

        while (useLedgerMenu) {
            System.out.println("\n\\\\ Ledger Menu \\\\");
            System.out.println("A) Display Full Ledger");
            System.out.println("B) View Only Deposits");
            System.out.println("C) View Only Payments");
            System.out.println("D) Reports");
            System.out.println("E) Home");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim().toUpperCase();
            //List<Transaction> filtered;

            switch (choice) {
                case "A":
                    //display all
                    Ledger.viewAllLedger(transactions);
                    break;
                case "B":
                    //display deposits only
                    Ledger.depositsFilter(transactions);
                    break;
                case "C":
                    //display only nagative entries or payements
                    Ledger.paymentsFilter(transactions);
                    break;
                case "D":
                    //display reports menu etc
                    reportsMenu(transactions, scanner);
                    break;
                case "E":
                    useLedgerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private static void reportsMenu(List<Transaction> transactions, Scanner scanner) {
        boolean useReportsMenu = true;

        while (useReportsMenu) {
            System.out.println("\n\\\\ Reports Menu \\\\");
            System.out.println("A) Month To Date");
            System.out.println("B) Previous Month");
            System.out.println("C) Year To Date");
            System.out.println("D) Previous Year");
            System.out.println("E) Search by Vendor");
            System.out.println("F) Back");
            System.out.print("Enter your choice: ");

            String userChoice = scanner.nextLine().trim().toUpperCase();

            switch(userChoice) {
                case "A":
                    Ledger.monthToDate(transactions);
                    break;
                case "B":
                    Ledger.previousMonth(transactions);
                    break;
                case "C":
                    Ledger.yearToDate(transactions);
                    break;
                case "D":
                    Ledger.previousYear(transactions);
                    break;
                case "E":
                    Ledger.searchByVendor(transactions, scanner);
                    break;
                case "F":
                    useReportsMenu = false;
                    break;
            }
        }
    }
}






