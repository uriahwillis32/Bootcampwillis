package org.example;

import java.util.Scanner;

public class ChipBuilder {

    public static Chips buildChips(Scanner scanner) {
        String chipType = null;
        boolean run = true;

        while (run) {
            System.out.println("--------------------------------------------------");
            System.out.println("                   Chips Selection");
            System.out.println("                (Each bag: $1.50)");
            System.out.println("--------------------------------------------------");
            System.out.println("1) Lay's Classic");
            System.out.println("2) Lay's BBQ");
            System.out.println("3) Doritos Nacho Cheese");
            System.out.println("4) Doritos Cool Ranch");
            System.out.println("5) Cheetos");
            System.out.println("6) Sun Chips");
            System.out.println("7) Ruffles");
            System.out.println("8) Miss Vickie’s Jalapeño");
            System.out.println("0) Done");
            System.out.println();
            System.out.print("Select chip type: ");


            int chipOption = -1;
            try {
                chipOption = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number 0 - 6.");
                continue;
            }

            switch (chipOption) {
                case 1:
                    chipType = "Lay's Classic";
                    run = false;
                    break;
                case 2:
                    chipType = "Doritos Nacho Cheese";
                    run = false;
                    break;
                case 3:
                    chipType = "Cheetos";
                    run = false;
                    break;
                case 4:
                    chipType = "Ruffles Sour Cream & Onion";
                    run = false;
                    break;
                case 5:
                    chipType = "SunChips";
                    run = false;
                    break;
                case 6:
                    chipType = "Fritos";
                    run = false;
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Invalid selection. Please enter a number 0 - 6.");
            }
        }
try {
    return new Chips(chipType);
}catch (NullPointerException ex) {
        System.out.println("Error: You entered a space as your chip type please return to the " +
                "home screen and enter the correct chip type.");
        return null;
    }

    }
}
