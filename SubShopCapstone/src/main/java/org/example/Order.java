package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private LocalDateTime dateTime = LocalDateTime.now();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(0,sandwich);
    }


    public void addDrink(Drink drink){
        drinks.add(0,drink);
    }


    public void addChips(Chips chip){
        chips.add(0,chip);
    }

    public double getTotalCost() {
        double subtotal = 0.0;

        for (Sandwich sandwich : sandwiches) {
            subtotal += sandwich.getCost();
        }

        for (Drink drink : drinks) {
            subtotal += drink.getCost();
        }

        for (Chips chip : chips) {
            subtotal += chip.getCost();
        }

        return subtotal;
    }

    public void displayOrderDetails() {
        System.out.println("\n===== ORDER DETAILS =====");

        System.out.println("Sandwiches:");
        if (sandwiches.isEmpty()) {
            System.out.println("  None");
        } else {
            int count = 1;
            for (Sandwich sandwich : sandwiches) {
                System.out.println("  Sandwich #" + count++ + ":");
                System.out.println("    " + sandwich);
            }
        }

        System.out.println("Drinks:");
        if (drinks.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Drink drink : drinks) {
                System.out.println("  - " + drink);
            }
        }

        System.out.println("Chips:");
        if (chips.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Chips chip : chips) {
                System.out.println("  - " + chip);
            }
        }

        System.out.println("----------------------------");

        double subtotal = getTotalCost();
        double tax = subtotal * 0.07;
        double total = subtotal + tax;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (7%%): $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);
    }


    public void saveReceiptToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("\n===== ORDER RECEIPT =====\n");
            writer.write("Date: " + dateTime + "\n");

            writer.write("Sandwiches:\n");
            if (sandwiches.isEmpty()) {
                writer.write("  None\n");
            } else {
                int count = 1;
                for (Sandwich sandwich : sandwiches) {
                    writer.write("  Sandwich #" + count++ + ":\n");
                    writer.write("    " + sandwich + "\n");
                }
            }

            writer.write("Drinks:\n");
            if (drinks.isEmpty()) {
                writer.write("  None\n");
            } else {
                for (Drink drink : drinks) {
                    writer.write("  - " + drink + "\n");
                }
            }

            writer.write("Chips:\n");
            if (chips.isEmpty()) {
                writer.write("  None\n");
            } else {
                for (Chips chip : chips) {
                    writer.write("  - " + chip + "\n");
                }
            }

            writer.write("----------------------------\n");

            double subtotal = getTotalCost();
            double tax = subtotal * 0.07;
            double total = subtotal + tax;

            writer.write(String.format("Subtotal: $%.2f%n", subtotal));
            writer.write(String.format("Tax (7%%): $%.2f%n", tax));
            writer.write(String.format("Total: $%.2f%n", total));

            writer.write("============================\n");
            writer.flush();
            System.out.println("Receipt saved to: " + filename);
        } catch (IOException ex) {
            System.out.println("Failed to save receipt: " + ex.getMessage());
        }
    }
}







