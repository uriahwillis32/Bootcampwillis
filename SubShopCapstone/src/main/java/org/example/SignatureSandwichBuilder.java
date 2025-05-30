package org.example;

public class SignatureSandwichBuilder {
    static Sandwich buildSignatureSandwich(String type) {
        Sandwich sandwich = new Sandwich(SandwichSize.EIGHT_INCH, BreadType.WHITE, true);
        switch (type) {
            case "BLT":
                sandwich.addMeat(new Topping("Bacon", ToppingType.MEAT, 1));
                sandwich.addCheese(new Topping("Cheddar", ToppingType.CHEESE, 1));
                sandwich.addRegularTopping(new Topping("Lettuce", ToppingType.REGULAR, 1));
                sandwich.addRegularTopping(new Topping("Tomato", ToppingType.REGULAR, 1));
                sandwich.addSauce("Ranch");
                break;
            case "Philly":
                sandwich.addMeat(new Topping("Steak", ToppingType.MEAT, 1));
                sandwich.addCheese(new Topping("American", ToppingType.CHEESE, 1));
                sandwich.addRegularTopping(new Topping("Peppers", ToppingType.REGULAR, 1));
                sandwich.addSauce("Mayo");
                break;
        }
        return sandwich;
    }
}
