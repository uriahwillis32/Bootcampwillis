package org.example;

import java.util.Scanner;
import org.example.Topping;
import org.example.ToppingType;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n/ Welcome to DELI-cious /");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
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
            System.out.println("/ ORDER MENU /");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    order.addSandwich(buildSandwich());
                    break;
                case "2":
                    order.addDrink(buildDrink());
                    break;
                case "3":
                    order.addChips(buildChips());
                    break;
                case "4":
                    order.displayOrderDetails();
                    System.out.print("Confirm order? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        order.saveReceiptToFile("receipt.txt");
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

    private static Drink buildDrink() {
        String flavor = null;
        boolean goBack = true;

        while (goBack) {
            System.out.println("Choose Beverage: ");
            System.out.println("1) Coca-Cola");
            System.out.println("2) Sprite");
            System.out.println("3) Fanta Orange");
            System.out.println("4) Barq's Root Beer");
            System.out.println("5) Dr. Pepper");
            System.out.println("6) Diet Coke");
            System.out.println("0) Go Back");
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
            System.out.println("Choose Drink Size:");
            System.out.println("1) SMALL");
            System.out.println("2) MEDIUM");
            System.out.println("3) LARGE");
            System.out.println("0) GO BACK");
            System.out.print("Select an option: ");

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

        return new Drink(flavor, size);
    }

    private static Chips buildChips() {
        String chipType = null;
        boolean run = true;

        while (run) {
            System.out.println("Choose Chip Type:");
            System.out.println("1) Lay's Classic");
            System.out.println("2) Doritos Nacho Cheese");
            System.out.println("3) Cheetos");
            System.out.println("4) Ruffles Sour Cream & Onion");
            System.out.println("5) SunChips");
            System.out.println("6) Fritos");
            System.out.println("0) Back");
            System.out.print("Enter option number: ");

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

        return new Chips(chipType);
    }

    private static Sandwich buildSandwich() {
        Sandwich sandwich = null;
        try {
            System.out.println("Select bread:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.print("Select an option: ");

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

            System.out.println("Select Sandwich Size: ");
            System.out.println("1) Four Inch ");
            System.out.println("2) Eight Inch ");
            System.out.println("3) Twelve Inch");
            System.out.print("Select an option: ");

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
                System.out.println("\nChoose a meat (or 0 to finish):");
                System.out.println("1) Steak");
                System.out.println("2) Ham");
                System.out.println("3) Salami");
                System.out.println("4) Roast Beef");
                System.out.println("5) Chicken");
                System.out.println("6) Bacon");
                System.out.println("0) Done");
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

                System.out.println("Would you like extra?");
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
                System.out.println("\nChoose a cheese (or 0 to finish):");
                System.out.println("1) American");
                System.out.println("2) Provolone");
                System.out.println("3) Cheddar");
                System.out.println("4) Swiss");
                System.out.println("0) Done");
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
                System.out.println("0) Go Back");
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
                    case 0:
                        continue;
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
                System.out.println("\nChoose a regular topping (or 0 to finish):");
                System.out.println("1) Lettuce");
                System.out.println("2) Peppers");
                System.out.println("3) Onions");
                System.out.println("4) Tomato");
                System.out.println("5) Jalapenos");
                System.out.println("6) Cucumbers");
                System.out.println("7) Pickles");
                System.out.println("7) Guacamole");
                System.out.println("7) Mushrooms");
                System.out.println("0) Done");
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
                System.out.println("\nChoose a sauce (or 0 to finish):");
                System.out.println("1) Mayo");
                System.out.println("2) Mustard");
                System.out.println("3) Ketchup");
                System.out.println("4) Thousand Islands");
                System.out.println("5) Vinaigrette");
                System.out.println("0) Done");
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
                        sauce = "Thousand Islands";
                        break;
                    case 5:
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

        return sandwich;
    }
}