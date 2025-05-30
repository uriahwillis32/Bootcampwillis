package org.example;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public List<Chips> getChips() {
        return chips;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(0,sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(0,drink);
    }

    public void removeDrink(Drink drink){
        drinks.remove(drink);
    }

    public void addChips(Chips chip){
        chips.add(0,chip);
    }

    public void removeChips(Chips chip){
        chips.remove(chip);
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
        System.out.println("\n===== DELI-cious Order Details =====");

        System.out.println("Sandwiches:");
        if (sandwiches.isEmpty()) {
            System.out.println("  None");
        } else {
            int sandwichCount = 1;
            for (Sandwich sandwich : sandwiches) {
                System.out.printf("  Sandwich #%d:\n", sandwichCount++);
                System.out.printf("    Size: %s\n", sandwich.getSize());
                System.out.printf("    Bread: %s\n", sandwich.getBreadType());
                System.out.printf("    Toasted: %s\n", sandwich.isToasted() ? "Yes" : "No");

                System.out.println("    Meats:");
                if (sandwich.getMeats().isEmpty()) {
                    System.out.println("      None");
                } else {
                    for (Topping meat : sandwich.getMeats()) {
                        boolean isExtra = meat.getQuantity() > 1;
                        double cost = meat.getCostForEachToppingEnum(sandwich.getSize());
                        System.out.printf("      - %s %s ($%.2f)\n", meat.getName(), isExtra ? "(extra)" : "", cost);
                    }
                }

                System.out.println("    Cheeses:");
                if (sandwich.getCheeses().isEmpty()) {
                    System.out.println("      None");
                } else {
                    for (Topping cheese : sandwich.getCheeses()) {
                        boolean isExtra = cheese.getQuantity() > 1;
                        double cost = cheese.getCostForEachToppingEnum(sandwich.getSize());
                        System.out.printf("      - %s %s ($%.2f)\n", cheese.getName(), isExtra ? "(extra)" : "", cost);
                    }
                }

                System.out.println("    Toppings:");
                if (sandwich.getRegulars().isEmpty()) {
                    System.out.println("      None");
                } else {
                    for (Topping topping : sandwich.getRegulars()) {
                        System.out.printf("      - %s\n", topping.getName());
                    }
                }

                System.out.println("    Sauces:");
                if (sandwich.getSauces().isEmpty()) {
                    System.out.println("      None");
                } else {
                    for (String sauce : sandwich.getSauces()) {
                        System.out.printf("      - %s\n", sauce);
                    }
                }

                System.out.printf("    Sandwich Total: $%.2f\n", sandwich.getCost());
                System.out.println("    ----------------------------");
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
        System.out.println("============================\n");
    }
}







