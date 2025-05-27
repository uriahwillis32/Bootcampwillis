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
                        order.saveReceipt();
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

    private static Sandwich buildSandwich() {
        System.out.println("Select bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

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
               System.out.println("Invalid size.");
       }

        System.out.println("Select Sandwich Size: ");
        System.out.println("1) Four Inch ");
        System.out.println("2) Eight Inch ");
        System.out.println("3) Twelve Inch");

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
                System.out.println("Invalid size.");
        }

        System.out.print("Would you like your Sandwich Toasted? ");

        System.out.println("\n1) Yes");
        System.out.println("2) No");
        int toastedOption = scanner.nextInt();

        boolean toasted = false;
        switch (toastedOption){
            case 1:
                toasted = true;
                break;
            case 2:
                toasted = false;
                break;
            default:
                System.out.println("Invalid option.");
        }

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        boolean run = true;
            while (run) {
                System.out.println("\nChoose a meat (or 0 to finish):");
                System.out.println("1) Turkey");
                System.out.println("2) Ham");
                System.out.println("3) Roast Beef");
                System.out.println("4) Chicken");
                System.out.println("5) Salami");
                System.out.println("0) Done");

                int choice = Integer.parseInt(scanner.nextLine());
                String meat = null;

                switch (choice) {
                    case 1:
                        meat = "Turkey";
                        break;
                    case 2:
                        meat = "Ham";
                        break;
                    case 3:
                        meat = "Roast Beef";
                        break;
                    case 4:
                        meat = "Chicken";
                        break;
                    case 5:
                        meat = "Salami";
                        break;
                    case 0:
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        continue;
                }

                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

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
                        System.out.println("Invalid choice. Assuming not extra.");
                        isExtra = false;
                }

                if (isExtra) {
                    quantity *= 2;
                }

                sandwich.addMeat(new Topping(meat, ToppingType.MEAT, quantity));
            }



// === Cheese Selection ===
        while (true) {
            System.out.println("\nChoose a cheese (or 0 to finish):");
            System.out.println("1) American");
            System.out.println("2) Swiss");
            System.out.println("3) Cheddar");
            System.out.println("4) Provolone");
            System.out.println("0) Done");

            int choice = Integer.parseInt(scanner.nextLine());
            String cheese = null;

            switch (choice) {
                case 1:
                    cheese = "American";
                    break;
                case 2:
                    cheese = "Swiss";
                    break;
                case 3:
                    cheese = "Cheddar";
                    break;
                case 4:
                    cheese = "Provolone";
                    break;
                case 0:
                    break; // exit loop
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            if (choice == 0) break;

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.println("Would you like it extra?");
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
                    System.out.println("Invalid input, assuming not extra.");
            }

            if (isExtra) {
                quantity *= 2;
            }

            sandwich.addCheese(new Topping(cheese, ToppingType.CHEESE, quantity));
        }

// === Regular Toppings ===
        while (true) {
            System.out.println("\nChoose a regular topping (or 0 to finish):");
            System.out.println("1) Lettuce");
            System.out.println("2) Tomato");
            System.out.println("3) Pickles");
            System.out.println("4) Onions");
            System.out.println("5) Cucumbers");
            System.out.println("0) Done");

            int choice = Integer.parseInt(scanner.nextLine());
            String topping = null;

            switch (choice) {
                case 1:
                    topping = "Lettuce";
                    break;
                case 2:
                    topping = "Tomato";
                    break;
                case 3:
                    topping = "Pickles";
                    break;
                case 4:
                    topping = "Onions";
                    break;
                case 5:
                    topping = "Cucumbers";
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            if (choice == 0) break;

            sandwich.addRegularTopping(new Topping(topping, ToppingType.REGULAR, 0));
        }

// === Sauces ===
        while (true) {
            System.out.println("\nChoose a sauce (or 0 to finish):");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ranch");
            System.out.println("4) Chipotle");
            System.out.println("5) Oil & Vinegar");
            System.out.println("0) Done");

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
                    sauce = "Ranch";
                    break;
                case 4:
                    sauce = "Chipotle";
                    break;
                case 5:
                    sauce = "Oil & Vinegar";
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
                    continue;
            }

            if (choice == 0) break;

            sandwich.addSauce(sauce);
        }

        return sandwich;
    }

    private static Drink buildDrink() {
        System.out.println("Choose Beverage: ");
        System.out.println("1) Coca-Cola");
        System.out.println("2) Sprite");
        System.out.println("3) Fanta Orange");
        System.out.println("4) Barq's Root Beer");
        System.out.println("5) Dr. Pepper");
        System.out.println("6) Diet Coke");
        System.out.println("0) Next");
        System.out.print("Enter option number: ");

        int drinkOption = 0;
        try {
            drinkOption = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please enter a number between 0 and 6.");
        }
        String flavor = null;

        switch (drinkOption){
            case 1:
                flavor = "Coca-Cola";
                break;
            case 2:
                flavor = "Sprite";
                break;
            case 3:
                flavor = "Fanta Orange";
                break;
            case 4:
                flavor = "Barq's";
                break;
            case 5:
                flavor = "Dr. Pepper";
                break;
            case 6:
                flavor = "Diet Coke";
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid selection. Try again.");
        }

        DrinkSize size = null;
        while (size == null) {
            System.out.println("Choose Drink Size:");
            System.out.println("1) SMALL");
            System.out.println("2) MEDIUM");
            System.out.println("3) LARGE");
            System.out.print("Enter option number: ");

            int sizeOption;
            try {
                sizeOption = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (sizeOption) {
                case 1:
                    size = DrinkSize.SMALL;
                    break;
                case 2:
                    size = DrinkSize.MEDIUM;
                    break;
                case 3:
                    size = DrinkSize.LARGE;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }

        return new Drink(flavor, size);
    }

    private static Chips buildChips() {
        String chipType = null;

        while (chipType == null) {
            System.out.println("Choose Chip Type:");
            System.out.println("1) Lay's Classic");
            System.out.println("2) Doritos Nacho Cheese");
            System.out.println("3) Cheetos");
            System.out.println("4) Ruffles Sour Cream & Onion");
            System.out.println("5) SunChips");
            System.out.println("6) Fritos");
            System.out.println("0) Other");

            System.out.print("Enter option number: ");
            int chipOption;
            try {
                chipOption = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (chipOption) {
                case 1:
                    chipType = "Lay's Classic";
                    break;
                case 2:
                    chipType = "Doritos Nacho Cheese";
                    break;
                case 3:
                    chipType = "Cheetos";
                    break;
                case 4:
                    chipType = "Ruffles Sour Cream & Onion";
                    break;
                case 5:
                    chipType = "SunChips";
                    break;
                case 6:
                    chipType = "Fritos";
                    break;
                case 0:
                    System.out.print("Enter chip type: ");
                    chipType = scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }

        return new Chips(chipType);
    }
}
