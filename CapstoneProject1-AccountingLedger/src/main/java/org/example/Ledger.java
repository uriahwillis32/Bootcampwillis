package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Ledger {


   /*public static void customSearch(List<Transaction> transactions, Scanner scanner) {
        System.out.println("\n//// Custom Search ////");

        try {
            System.out.print("Start Date (yyyy-MM-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("End Date (yyyy-MM-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter Description (optional, press Enter to skip): ");
            String descriptionInput = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter Vendor Name (optional, press Enter to skip): ");
            String vendorInput = scanner.nextLine().trim().toLowerCase();

            System.out.print("Minimum Amount: ");
            BigDecimal minAmount = new BigDecimal(scanner.nextLine());

            System.out.print("Maximum Amount: ");
            BigDecimal maxAmount = new BigDecimal(scanner.nextLine());

            System.out.println("\nMatching Transactions:");

            for (Transaction transaction : transactions) {
                LocalDate date = transaction.getDate();
                BigDecimal amount = transaction.getAmount();
                String description = transaction.getDescription().toLowerCase();
                String vendor = transaction.getVendor().toLowerCase();

                boolean dateInRange = (date.isEqual(startDate) || date.isAfter(startDate)) &&
                        (date.isEqual(endDate) || date.isBefore(endDate));
                boolean amountInRange = amount.compareTo(minAmount) >= 0 &&
                        amount.compareTo(maxAmount) <= 0;
                boolean matchesDescription = descriptionInput.isEmpty() || description.contains(descriptionInput);
                boolean matchesVendor = vendorInput.isEmpty() || vendor.contains(vendorInput);

                if (dateInRange && amountInRange && matchesDescription && matchesVendor) {
                    System.out.println("Date | Time | Description | Vendor | Amount");
                    System.out.println(transaction.toString());
                }
            }

        } catch (Exception ex) {
            System.out.println("Invalid input. Please ensure dates are in yyyy-MM-dd and amounts are numbers.");
        }
    }

*/

    //Home screen options

    public static void addDeposit(List<Transaction> transactions, Scanner scanner) {
        System.out.println("\n(/Make Deposit/)");

        try {
            System.out.print("Enter Person/Vendor/Company name: ");
            String vendor = scanner.nextLine();

            System.out.print("Enter a description for this payment: ");
            String description = scanner.nextLine();

            System.out.print("Enter your deposit amount: ");
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Deposit must be greater than 0.");
                return;
            }

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            Transaction deposit = new Transaction(date, time, description, vendor, amount);
            TransactionFileManager.appendTransaction(deposit);
            transactions.add(deposit);

            System.out.println("Deposit successfully added.");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid amount. Please enter a valid number.");
        } catch (Exception ex) {
            System.out.println("An error occurred while adding the deposit.");
        }
    }



    public static void makePayment(List<Transaction> transactions, Scanner scanner) {
        System.out.println("\n(/Make Payment/)");

        try {
            System.out.print("Enter Person/Vendor/Company name: ");
            String vendor = scanner.nextLine();

            System.out.print("Enter a description for this payment: ");
            String description = scanner.nextLine();

            System.out.print("Enter your payment amount: ");
            BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Payment amount must be greater than 0.");
                return;
            }

            amount = amount.multiply(new BigDecimal("-1")); // Converts to a negative
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            Transaction payment = new Transaction(date, time, description, vendor, amount);
            TransactionFileManager.appendTransaction(payment);
            transactions.add(payment);

            System.out.println("Payment successfully added.");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid amount. Please enter a valid number.");
        } catch (Exception ex) {
            System.out.println("An error occurred while making the payment.");
        }
    }



    //View Ledger menu options

    public static void viewAllLedger(List<Transaction> transactions ) {
        System.out.println("Here is a list of your transaction history...");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }


    public static void depositsFilter(List<Transaction> transactions) {

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                System.out.println(transaction.toString());
            }
        }
    }

    public static void paymentsFilter(List<Transaction> transactions) {

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                System.out.println(transaction.toString());
            }
        }
    }


    // report menu options



    public static void monthToDate(List<Transaction> transactions) {
        LocalDate today = LocalDate.now();

        System.out.println("Month To Date Transaction");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();

            if (date.getMonth() == today.getMonth() && date.getYear() == today.getYear()) {
                System.out.println(transaction.toString());
            }
        }
    }

    public static void previousMonth(List<Transaction> transactions) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        System.out.println("Previous Month Transactions");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getMonth() == lastMonth.getMonth() &&
                    transaction.getDate().getYear() == lastMonth.getYear()) {
                System.out.println(transaction.toString());
            }
        }
    }


    public static void yearToDate(List<Transaction> transactions) {
        int currentYear = LocalDate.now().getYear();

        System.out.println("Year to Date Transactions");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == currentYear) {
                System.out.println(transaction.toString());
            }
        }
    }

    public static void previousYear(List<Transaction> transactions) {
        int lastYear = LocalDate.now().minusYears(1).getYear();

        System.out.println("Previous Year Transactions");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == lastYear) {
                System.out.println(transaction.toString());
            }
        }
    }

    public static void searchByVendor(List<Transaction> transactions, Scanner scanner) {
        System.out.print("Enter vendor name to search: ");
        String input = scanner.nextLine().trim().toLowerCase();

        System.out.println(" Transactions for given Vendor: ");

        System.out.println("Date | Time | Description | Vendor | Amount");
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().toLowerCase().contains(input)) {
                System.out.println(transaction.toString());
            }
        }
    }
}




