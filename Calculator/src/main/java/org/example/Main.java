package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our calculator. For addition type a, for multiplication type ,m for division type d for subtraction type s.");


        //Scanner scanner = new Scanner(System.in);

        //System.out.println("Enter first whole number");
        //Integer userFirstNumber = scanner.nextInt();

        //System.out.println("Enter second whole number");

        //Integer userSecondNumber = scanner.nextInt();

        //System.out.printf(" %d + %d =:", userFirstNumber, userSecondNumber);

        //System.out.println(userFirstNumber + userSecondNumber);

        Scanner scanner = new Scanner(System.in);

        // Ask for the operation
        System.out.println("What operation would you like to perform? (add, multiply, divide, subtract):");
        String operation = scanner.nextLine().toLowerCase();

        // Ask for the numbers
        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        // Perform the operation using switch
        switch (operation) {
            case "a":
                System.out.println("Result: " + (num1 + num2));
                System.out.println("Result: ");
                break;

            case "m":
                System.out.println("Result: " + (num1 * num2));
                break;

            case "d":
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    break;
                }

            case "s":
                System.out.println("Result " + (num1 - num2));
                break;



            default:
                System.out.println("Invalid operation.");
                break;
        }

        scanner.close();
    }
}








