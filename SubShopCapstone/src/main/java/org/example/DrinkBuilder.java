package org.example;

import java.util.Scanner;

public class DrinkBuilder {

    public static Drink buildDrink(Scanner scanner) {
        String flavor = null;
        boolean goBack = true;

        while (goBack) {
            System.out.println("--------------------------------------------------");
            System.out.println("                  Beverages ($1.50)");
            System.out.println("--------------------------------------------------");
            System.out.println("Choose a beverage:");
            System.out.println("1) Coca-Cola");
            System.out.println("2) Sprite");
            System.out.println("3) Fanta Orange");
            System.out.println("4) Barq's Root Beer");
            System.out.println("5) Dr. Pepper");
            System.out.println("6) Diet Coke");
            System.out.println("0) Go Back");
            System.out.println();
            System.out.print("Select an option: ");

            int drinkOption = -1;
            try {
                drinkOption = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number 0 - 6.");
                continue;
            }

            switch (drinkOption) {
                case 1:
                    flavor = "Coca-Cola";
                    goBack = false;
                    break;
                case 2:
                    flavor = "Sprite";
                    goBack = false;
                    break;
                case 3:
                    flavor = "Fanta Orange";
                    goBack = false;
                    break;
                case 4:
                    flavor = "Barq's Root Beer";
                    goBack = false;
                    break;
                case 5:
                    flavor = "Dr. Pepper";
                    goBack = false;
                    break;
                case 6:
                    flavor = "Diet Coke";
                    goBack = false;
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Invalid selection. Please enter a number 0 - 6.");
            }
        }

        DrinkSize size = null;
        boolean selectingSize = true;

        while (selectingSize) {
            System.out.println("--------------------------------------------------");
            System.out.println("                  Drink Selection");
            System.out.println("--------------------------------------------------");
            System.out.println("1) Small  (12 oz) ............ $2.00");
            System.out.println("2) Medium (20 oz) ............ $2.50");
            System.out.println("3) Large  (32 oz) ............ $3.00");
            System.out.println("0) Done");
            System.out.println();
            System.out.print("Select drink size: ");

            int sizeOption = -1;
            try {
                sizeOption = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number 0 - 3.");
                continue;
            }

            switch (sizeOption) {
                case 1:
                    size = DrinkSize.SMALL;
                    selectingSize = false;
                    break;
                case 2:
                    size = DrinkSize.MEDIUM;
                    selectingSize = false;
                    break;
                case 3:
                    size = DrinkSize.LARGE;
                    selectingSize = false;
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Invalid selection. Please enter a number 0 - 3.");
            }
        }
        try {
            return new Drink(flavor, size);
        }
        catch (NullPointerException ex) {
            System.out.println("Error: You entered a space as your drink size or flavor please return to the " +
                    "home screen and enter the size and flavor for your drink.");
        }
            return new Drink(flavor, size);
    }
}
