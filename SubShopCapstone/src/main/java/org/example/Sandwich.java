package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted;
    private List<Topping> meats = new ArrayList<>();
    private List<Topping> cheeses = new ArrayList<>();
    private List<Topping> regulars = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(SandwichSize size, BreadType breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public void addMeat(Topping meat) {
        meats.add(meat);
    }

    public void addCheese(Topping cheese) {
        cheeses.add(cheese);
    }

    public void addRegularTopping(Topping regular) {
        regulars.add(regular);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public double getCost() {
        double base = 0.0;

        if (size == SandwichSize.FOUR_INCH) {
            base = 5.5;
        } else if (size == SandwichSize.EIGHT_INCH) {
            base = 7.0;
        } else if (size == SandwichSize.TWELVE_INCH) {
            base = 8.5;
        }

        for (int i = 0; i < meats.size(); i++) {
            base += meats.get(i).getCostForEachToppingEnum(size);
        }

        for (int i = 0; i < cheeses.size(); i++) {
            base += cheeses.get(i).getCostForEachToppingEnum(size);
        }

        return base;
    }
}
