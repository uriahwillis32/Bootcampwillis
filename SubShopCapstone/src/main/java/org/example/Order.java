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
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }

        System.out.println("Drinks:");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }

        System.out.println("Chips:");
        for (Chips chip : chips) {
            System.out.println(chip);
        }

        double subtotal = getTotalCost();
        double tax = subtotal * 0.07;
        double total = subtotal + tax;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (7%%): $%.2f%n", tax);
        System.out.printf("Total: $%.2f%n", total);
    }
}





