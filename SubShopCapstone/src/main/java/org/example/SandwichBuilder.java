package org.example;

import java.util.Scanner;

public class SandwichBuilder {
    public static Sandwich buildSandwich(Scanner scanner) {
        Sandwich sandwich = null;

        try {
            System.out.println("--------------------------------------------------");
            System.out.println("              Signature Sandwiches");
            System.out.println("--------------------------------------------------");
            System.out.println("1) BLT");
            System.out.println("   - 8\" White bread, Bacon, Cheddar, Lettuce, Tomato, Ranch, Toasted");
            System.out.println("2) Philly Cheese Steak");
            System.out.println("   - 8\" White bread, Steak, American, Peppers, Mayo, Toasted");
            System.out.println("3) Build Your Own Sandwich");
            System.out.println("--------------------------------------------------");
            System.out.print("Select an option: ");
            int mainChoice = Integer.parseInt(scanner.nextLine());

            if (mainChoice == 1) {
                sandwich = SignatureSandwichBuilder.buildSignatureSandwich("BLT");
            } else if (mainChoice == 2) {
                sandwich = SignatureSandwichBuilder.buildSignatureSandwich("Philly");
            }

            if (mainChoice == 1 || mainChoice == 2) {
                System.out.println();
                System.out.println("Would you like to customize this sandwich?");
                System.out.println("1) Yes");
                System.out.println("2) No");
                int customize = Integer.parseInt(scanner.nextLine());
                if (customize == 2) {
                    return sandwich;
                }
            }

            System.out.println("--------------------------------------------------");
            System.out.println("                  Bread Selection");
            System.out.println("  (Included in base price of sandwich size)");
            System.out.println("--------------------------------------------------");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.println("0) Done");
            System.out.println();
            System.out.print("Select bread type: ");

            int typeOption = scanner.nextInt();
            scanner.nextLine();

            BreadType bread = null;
            switch (typeOption) {
                case 1:
                    bread = BreadType.WHITE;
                    break;
                case 2:
                    bread = BreadType.WHEAT;
                    break;
                case 3:
                    bread = BreadType.RYE;
                    break;
                case 4:
                    bread = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Invalid input, please enter a number 1 - 4.");
            }

            System.out.println("--------------------------------------------------");
            System.out.println("              Sandwich Size & Price");
            System.out.println("--------------------------------------------------");
            System.out.println("1) 4\"   Sandwich .............. $5.50");
            System.out.println("2) 8\"   Sandwich .............. $7.00");
            System.out.println("3) 12\"  Sandwich .............. $8.50");
            System.out.println();

            int sizeOption = scanner.nextInt();
            scanner.nextLine();

            SandwichSize size = null;
            switch (sizeOption) {
                case 1:
                    size = SandwichSize.FOUR_INCH;
                    break;
                case 2:
                    size = SandwichSize.EIGHT_INCH;
                    break;
                case 3:
                    size = SandwichSize.TWELVE_INCH;
                    break;
                default:
                    System.out.println("Invalid input, please enter a number 1 - 3.");
            }

            System.out.println("Would you like your Sandwich Toasted?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            int toastedOption = scanner.nextInt();
            scanner.nextLine();

            boolean toasted = false;
            switch (toastedOption) {
                case 1:
                    toasted = true;
                    break;
                case 2:
                    toasted = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter 1 or 2.");
            }

            sandwich = new Sandwich(size, bread, toasted);

            boolean run = true;
            while (run) {
                System.out.println("--------------------------------------------------");
                System.out.println("                    Meat Options");
                System.out.println("--------------------------------------------------");
                System.out.println("  Size      |  Base Price   |  Extra Portion Price");
                System.out.println("  --------- |  ------------ |  -------------------");
                System.out.println("   4 Inch   |     $1.00     |        +$0.50");
                System.out.println("   8 Inch   |     $2.00     |        +$1.00");
                System.out.println("  12 Inch   |     $3.00     |        +$1.50");
                System.out.println();
                System.out.println("Choose a meat (Select option 0 when done.):");
                System.out.println("1) Steak");
                System.out.println("2) Ham");
                System.out.println("3) Salami");
                System.out.println("4) Roast Beef");
                System.out.println("5) Chicken");
                System.out.println("6) Bacon");
                System.out.println("0) Done");
                System.out.println();

                System.out.print("Select an option: ");

                int choice = Integer.parseInt(scanner.nextLine());
                String meat = null;
                int quantity = 0;

                switch (choice) {
                    case 1:
                        meat = "Steak";
                        quantity = 1;
                        break;
                    case 2:
                        meat = "Ham";
                        quantity = 1;
                        break;
                    case 3:
                        meat = "Salami";
                        quantity = 1;
                        break;
                    case 4:
                        meat = "Roast Beef";
                        quantity = 1;
                        break;
                    case 5:
                        meat = "Chicken";
                        quantity = 1;
                        break;
                    case 6:
                        meat = "Bacon";
                        quantity = 1;
                        break;
                    case 0:
                        run = false;
                        continue;
                    default:
                        System.out.println("Invalid input, please enter a number 0 - 5.");
                        continue;
                }

                System.out.println("Would you like an extra portion?");
                System.out.println("1) Yes");
                System.out.println("2) No");

                int extraChoice = Integer.parseInt(scanner.nextLine());
                boolean isExtra = false;

                switch (extraChoice) {
                    case 1:
                        isExtra = true;
                        break;
                    case 2:
                        isExtra = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter number 1 or 2");
                }

                if (isExtra) {
                    quantity *= 2;
                }

                sandwich.addMeat(new Topping(meat, ToppingType.MEAT, quantity));
            }

            boolean Done3 = true;
            while (Done3) {
                System.out.println("--------------------------------------------------");
                System.out.println("                   Cheese Options");
                System.out.println("--------------------------------------------------");
                System.out.println("  Size      |  Base Price   |  Extra Portion Price");
                System.out.println("  --------- |  ------------ |  -------------------");
                System.out.println("   4 Inch   |     $0.75     |        +$0.30");
                System.out.println("   8 Inch   |     $1.50     |        +$0.60");
                System.out.println("  12 Inch   |     $2.25     |        +$0.90");
                System.out.println();
                System.out.println("Choose a cheese (Select option 0 when done.):");
                System.out.println("1) American");
                System.out.println("2) Provolone");
                System.out.println("3) Cheddar");
                System.out.println("4) Swiss");
                System.out.println("0) Done");
                System.out.println();
                System.out.print("Select an option: ");

                int choice = Integer.parseInt(scanner.nextLine());
                String cheese = null;
                int quantity = 0;
                switch (choice) {
                    case 1:
                        cheese = "American";
                        quantity = 1;
                        break;
                    case 2:
                        cheese = "Provolone";
                        quantity = 1;
                        break;
                    case 3:
                        cheese = "Cheddar";
                        quantity = 1;
                        break;
                    case 4:
                        cheese = "Swiss";
                        quantity = 1;
                        break;
                    case 0:
                        Done3 = false;
                        continue;
                    default:
                        System.out.println("Invalid input, please enter a number 0 - 4.");
                        continue;
                }

                System.out.println("Would you like it extra?");
                System.out.println("1) Yes");
                System.out.println("2) No");
                System.out.println();
                System.out.print("Select an option: ");

                int extraChoice = Integer.parseInt(scanner.nextLine());
                boolean isExtra = false;

                switch (extraChoice) {
                    case 1:
                        isExtra = true;
                        break;
                    case 2:
                        isExtra = false;
                        break;
                    default:
                        System.out.println("Invalid input, assuming not extra.");
                }

                if (isExtra) {
                    quantity *= 2;
                }

                sandwich.addCheese(new Topping(cheese, ToppingType.CHEESE, quantity));
            }

            boolean Done2 = true;
            while (Done2) {
                System.out.println("--------------------------------------------------");
                System.out.println("             Regular Toppings (No Charge)");
                System.out.println("--------------------------------------------------");
                System.out.println("Choose a topping (Select option 0 when done.):");
                System.out.println("1) Lettuce");
                System.out.println("2) Tomato");
                System.out.println("3) Onion");
                System.out.println("4) Pickles");
                System.out.println("5) Olives");
                System.out.println("6) Peppers");
                System.out.println("0) Done");
                System.out.println();
                System.out.print("Select an option: ");

                int choice = Integer.parseInt(scanner.nextLine());
                String topping = null;
                int quantity = 0;
                switch (choice) {
                    case 1:
                        topping = "Lettuce";
                        quantity = 1;
                        break;
                    case 2:
                        topping = "Peppers";
                        quantity = 1;
                        break;
                    case 3:
                        topping = "Onions";
                        quantity = 1;
                        break;
                    case 4:
                        topping = "Tomato";
                        quantity = 1;
                        break;
                    case 5:
                        topping = "Jalapenos";
                        quantity = 1;
                        break;
                    case 6:
                        topping = "Cucumbers";
                        quantity = 1;
                        break;
                    case 7:
                        topping = "Pickles";
                        quantity = 1;
                        break;
                    case 8:
                        topping = "Guacamole ";
                        quantity = 1;
                        break;
                    case 9:
                        topping = "Mushrooms";
                        quantity = 1;
                        break;
                    case 0:
                        Done2 = false;
                        continue;
                    default:
                        System.out.println("Invalid input, please enter a number 0 - 5.");
                        continue;
                }

                sandwich.addRegularTopping(new Topping(topping, ToppingType.REGULAR, quantity));
            }

            boolean Done1 = true;
            while (Done1) {
                System.out.println("--------------------------------------------------");
                System.out.println("                 Sauces (No Charge)");
                System.out.println("--------------------------------------------------");
                System.out.println("Choose a sauce (Select option 0 when done.):");
                System.out.println("1) Mayo");
                System.out.println("2) Mustard");
                System.out.println("3) Ketchup");
                System.out.println("4) Ranch");
                System.out.println("5) Vinaigrette");
                System.out.println("6) Thousand Islands");
                System.out.println("0) Done");
                System.out.println();
                System.out.print("Select an option: ");

                int choice = Integer.parseInt(scanner.nextLine());
                String sauce = null;
                switch (choice) {
                    case 1:
                        sauce = "Mayo";
                        break;
                    case 2:
                        sauce = "Mustard";
                        break;
                    case 3:
                        sauce = "Ketchup";
                        break;
                    case 4:
                        sauce = "Ranch";
                        break;
                    case 5:
                        sauce = "Thousand Islands";
                        break;
                    case 6:
                        sauce = "Vinaigrette";
                        break;
                    case 0:
                        Done1 = false;
                        continue;
                    default:
                        System.out.println("Invalid input, please enter a number 0 - 5.");
                        continue;
                }

                sandwich.addSauce(sauce);
            }

        } catch (Exception ex) {
            System.out.println("Invalid input, please enter a number between the given options.");
            scanner.nextLine();
        }
        try {
            return sandwich;
        }
        catch (NullPointerException ex) {
            System.out.println("Error: You entered a space as your selection for one of your sandwich options please return to the " +
                    "home screen try again and enter a number for the given options.");
        }
        return sandwich;
    }
}
