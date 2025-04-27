package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }


    public void displayCart(List<Product> products, Scanner scanner) {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart contains the following products:");
            for (Product product : products) {
                System.out.println("SKU: " + product.getSku() + " | Name: " + product.getProductName() +
                        " | Price: $" + product.getPrice());
            }
        }
        // Ask user if they want to go back to the main menu
        System.out.println("\nPress 1 to go back to the main menu.");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            return;
        }
        return;
    }



    //TODO add product to cart
    public void addProductBySku(List<Product> products, Scanner scanner) {
        System.out.println("Enter the SKU of the product you would like to add to the cart:");
        System.out.print("| Type Here: ");
        String inputSku = scanner.nextLine();

        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(inputSku)) {
                this.products.add(product); // <-- using `this` to refer to the cart's products list
                System.out.println("// " + product.getProductName() + " added to cart.");
                return;
            }
        }
        System.out.println("Incorrect SKU, please try again.");
    }



    //TODO remove product from cart method
    //You will need the SKU of the product you want to remove
    //Loop through the list of products
    //Check to see if the SKU matches
    //Get that Product, then use the remove method AFTER the loop


    public void removeProductBySku(Scanner scanner) {
        System.out.println("Enter the SKU of the product you would like to remove from the cart:");
        System.out.print("| Type Here: ");
        String inputSku = scanner.nextLine();

        for (Product product : this.products) { // Only search inside the cart
            if (product.getSku().equalsIgnoreCase(inputSku)) {
                this.products.remove(product);
                System.out.println("// " + product.getProductName() + " removed from cart.");
                return;
            }
        }
        System.out.println("Incorrect SKU, please try again.");
    }




    //TODO get cart total method

    public double getCartTotal() {
        double total = 0;
        for (Product product : this.products) {
            total += product.getPrice();
        }
        return total;
    }

    public List<Product> getProducts() { return products; }
}

