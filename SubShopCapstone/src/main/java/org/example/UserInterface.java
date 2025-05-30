package org.example;

import java.util.Scanner;
import org.example.Topping;
import org.example.ToppingType;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void display() {
        while (true) {
            System.out.println("==================================================");
            System.out.println("              Welcome to DELI-cious!");
            System.out.println("==================================================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {
                startNewOrder();
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }


    private static void startNewOrder() {
        Order order = new Order();

        while (true) {
            System.out.println("==================================================");
            System.out.println("                   ORDER MENU");
            System.out.println("==================================================");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println();
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    order.addSandwich(SandwichBuilder.buildSandwich(scanner));
                    break;
                case "2":
                    order.addDrink(DrinkBuilder.buildDrink(scanner));
                    break;
                case "3":
                    order.addChips(ChipBuilder.buildChips(scanner));
                    break;
                case "4":
                    order.displayOrderDetails();
                    System.out.print("Confirm order? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        OrderFileManager fileManager = new OrderFileManager();
                        OrderFileManager.saveReceiptToFile(order);
                    } else {
                        System.out.println("Order canceled.");
                    }
                    return;
                case "0":
                    System.out.println("Order canceled.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}