package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = FileLoader.readFile();
        ShoppingCart cart = new ShoppingCart();

        boolean loop = true;


        while (loop) {
            System.out.println("Welcome to the store! Choose an option:");
            System.out.println("1. View all products");
            System.out.println("2. Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by name");
            System.out.println("5. Add to cart");
            System.out.println("6. Remove from cart");
            System.out.println("7. View cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        displayAllProducts(products, scanner);
                        break;
                    case 2:
                        searchBySku(products, cart, scanner);
                        break;
                    case 3:
                        searchByPriceRange(products, cart, scanner);
                        break;
                    case 4:
                        searchByName(products, cart, scanner);
                        break;
                    case 5:
                        cart.addProductBySku(products, scanner);
                        break;
                    case 6:
                        cart.removeProductBySku(scanner);
                        break;
                    case 7:
                        cart.displayCart(products, scanner);
                        break;
                    case 8:
                        checkoutItems(cart);
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Try again!");
                }
            } catch (Exception ex) {
                System.out.println("An unexpected error occurred.");
            }
        }
    }

    public static void displayAllProducts(List<Product> products, Scanner scanner) {
        try {

            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println("SKU: " + product.getSku() + " | Name: " + product.getProductName() +
                        " | Price: $" + product.getPrice());
            }
            // Ask user if they want to go back to the main menu
            System.out.println("\nPress 1 to go back to the main menu.");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                return;
            }
                return;

        } catch (Exception ex) {
            System.out.println("Error displaying products.");
        }
    }

    public static void searchBySku(List<Product> products, ShoppingCart cart, Scanner scanner) {
        try {
            System.out.println("Enter the SKU of the product you would like to search for:");
            String inputSku = scanner.nextLine();

            for (Product product : products) {
                if (product.getSku().equalsIgnoreCase(inputSku)) {
                    System.out.println("SKU: " + product.getSku() + " | Name: " + product.getProductName() +
                            " | Price: $" + product.getPrice());

                    System.out.println("Would you like to add this item to your cart?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");

                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        cart.getProducts().add(product);
                        System.out.println(product.getProductName() + " added to cart.");
                    } else {
                        System.out.println("Returning to main menu.");
                    }
                    return;
                }
            }
            System.out.println("No product found with that SKU.");
        } catch (Exception ex) {
            System.out.println("Error searching by SKU.");
        }
    }

    public static void searchByPriceRange(List<Product> products, ShoppingCart cart, Scanner scanner) {
        double value1 = 0;
        double value2 = 0;
        try {
            System.out.println("\nSet the price range for the product you would like to search for:");
            System.out.println("\n*Please note that the price range can start at no less than 12.99 and no more than 149.95" +
                    "                \"(Don't add any letters or special characters.));\n");
            System.out.print("Enter starting value: ");
            value1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter ending value: ");
            value2 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid price input. Returning to menu.");
            return;
        } catch (Exception ex) {
            System.out.println("Error setting price range.");
            return;
        }

        try {

            for (Product product : products) {
                if (product.getPrice() >= value1 && product.getPrice() <= value2) {

                    System.out.println("SKU: " + product.getSku() + " | Name: " + product.getProductName() +
                            " | Price: $" + product.getPrice());

                    System.out.println("Would you like to add this item to your cart?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        cart.getProducts().add(product);
                        System.out.println(product.getProductName() + " added to cart.");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error searching by price range.");
        }
    }

    public static void searchByName(List<Product> products, ShoppingCart cart, Scanner scanner) {
        try {
            System.out.println("Enter the name of the product you would like to search for:");
            String inputName = scanner.nextLine();

            for (Product product : products) {
                if (product.getProductName().equalsIgnoreCase(inputName)) {
                    System.out.println("SKU: " + product.getSku() + " | Name: " + product.getProductName() +
                            " | Price: $" + product.getPrice());

                    System.out.println("Would you like to add this item to your cart?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        cart.getProducts().add(product);
                        System.out.println(product.getProductName() + " added to cart.");
                    }
                    return;
                }
            }
            System.out.println("No product found with that name.");
        } catch (Exception ex) {
            System.out.println("Error searching by name.");
        }


        }

    public static void checkoutItems(ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);
        double totalAmount = cart.getCartTotal();

        System.out.println("Total amount for this order: " + totalAmount);

        System.out.print("Enter your payment amount: ");
        double payment = Double.parseDouble(scanner.nextLine());

        if (payment < totalAmount) {
            System.out.println("Insufficient payment.");
            return;
        }
        double change = payment - totalAmount;
        System.out.println("Change returned: " + change);

        printReceipt(cart, totalAmount, payment, change);

        System.out.println("Thank you for shopping at Online Shop!");
    }

    private static void printReceipt(ShoppingCart cart, double totalAmount, double payment, double change) {
        System.out.println("//////// RECEIPT //////////");
        System.out.println("Purchased Items:");


        for (Product product : cart.getProducts()) {
            System.out.println("\n | SKU: " + product.getSku() + "\n | Name: " + product.getProductName() + "\n | Price: $" + product.getPrice());
        }

        System.out.println("Total: $" + totalAmount);

        System.out.println("Amount Paid: $" + payment);

        System.out.println("Change Returned: $" + change);

    }
    }




