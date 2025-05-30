package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {

    public static void saveReceiptToFile(Order order) {
        try {

            DateTimeFormatter fileNameFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
            String timestamp = LocalDateTime.now().format(fileNameFormatter);
            String filename = "receipt_" + timestamp + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

                DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm");
                String dateTime = LocalDateTime.now().format(displayFormatter);

                writer.write("======= DELI-cious Receipt =======\n");
                writer.write("Date and Time: " + dateTime + "\n");
                writer.write("==================================\n\n");


                writer.write("Sandwiches:\n");
                if (order.getSandwiches().isEmpty()) {
                    writer.write("  None\n");
                } else {
                    int sandwichCount = 1;
                    for (Sandwich sandwich : order.getSandwiches()) {
                        writer.write(String.format("  Sandwich #%d:\n", sandwichCount++));
                        writer.write(String.format("    Size: %s\n", sandwich.getSize()));
                        writer.write(String.format("    Bread: %s\n", sandwich.getBreadType()));
                        writer.write(String.format("    Toasted: %s\n", sandwich.isToasted() ? "Yes" : "No"));

                        writer.write("    Meats:\n");
                        if (sandwich.getMeats().isEmpty()) {
                            writer.write("      None\n");
                        } else {
                            for (Topping meat : sandwich.getMeats()) {
                                boolean isExtra = meat.getQuantity() > 1;
                                double cost = meat.getCostForEachToppingEnum(sandwich.getSize());
                                writer.write(String.format("      - %s %s ($%.2f)\n",
                                        meat.getName(), isExtra ? "(extra)" : "", cost));
                            }
                        }

                        writer.write("    Cheeses:\n");
                        if (sandwich.getCheeses().isEmpty()) {
                            writer.write("      None\n");
                        } else {
                            for (Topping cheese : sandwich.getCheeses()) {
                                boolean isExtra = cheese.getQuantity() > 1;
                                double cost = cheese.getCostForEachToppingEnum(sandwich.getSize());
                                writer.write(String.format("      - %s %s ($%.2f)\n",
                                        cheese.getName(), isExtra ? "(extra)" : "", cost));
                            }
                        }

                        writer.write("    Toppings:\n");
                        if (sandwich.getRegulars().isEmpty()) {
                            writer.write("      None\n");
                        } else {
                            for (Topping topping : sandwich.getRegulars()) {
                                writer.write(String.format("      - %s\n", topping.getName()));
                            }
                        }

                        writer.write("    Sauces:\n");
                        if (sandwich.getSauces().isEmpty()) {
                            writer.write("      None\n");
                        } else {
                            for (String sauce : sandwich.getSauces()) {
                                writer.write(String.format("      - %s\n", sauce));
                            }
                        }

                        writer.write(String.format("    Sandwich Total: $%.2f\n", sandwich.getCost()));
                        writer.write("    ----------------------------\n");
                    }
                }


                writer.write("Drinks:\n");
                if (order.getDrinks().isEmpty()) {
                    writer.write("  None\n");
                } else {
                    for (Drink drink : order.getDrinks()) {
                        writer.write("  - " + drink + "\n");
                    }
                }


                writer.write("Chips:\n");
                if (order.getChips().isEmpty()) {
                    writer.write("  None\n");
                } else {
                    for (Chips chip : order.getChips()) {
                        writer.write("  - " + chip + "\n");
                    }
                }

                writer.write("----------------------------\n");

                double subtotal = order.getTotalCost();
                double tax = subtotal * 0.07;
                double total = subtotal + tax;

                writer.write(String.format("Subtotal: $%.2f%n", subtotal));
                writer.write(String.format("Tax (7%%): $%.2f%n", tax));
                writer.write(String.format("Total: $%.2f%n", total));

                writer.write("============================\n");
                writer.flush();
                System.out.println("Receipt saved to: " + filename);
            }
        } catch (IOException ex) {
            System.out.println("Failed to save receipt: " + ex.getMessage());
        }
    }
}
