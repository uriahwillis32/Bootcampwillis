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

    public BreadType getBreadType() {
        return breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<Topping> getMeats() {
        return meats;
    }

    public List<Topping> getCheeses() {
        return cheeses;
    }

    public List<Topping> getRegulars() {
        return regulars;
    }

    public List<String> getSauces() {
        return sauces;
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
        double originalcost = 0.0;

        if (size == SandwichSize.FOUR_INCH) {
            originalcost = 5.50;
        } else if (size == SandwichSize.EIGHT_INCH) {
            originalcost = 7.00;
        } else if (size == SandwichSize.TWELVE_INCH) {
            originalcost = 8.50;
        }

        for (Topping meat : meats) {
            originalcost += meat.getCostForEachToppingEnum(size);
        }

        for (Topping cheese : cheeses) {
            originalcost += cheese.getCostForEachToppingEnum(size);
        }

        return originalcost;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ").append(size);
        sb.append(", Bread: ").append(breadType);
        sb.append(", Toasted: ").append(toasted ? "Yes" : "No");

        if (!meats.isEmpty()) {
            sb.append("\n  Meats: ");
            for (Topping meat : meats) {
                sb.append(meat.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Remove trailing comma
        }

        if (!cheeses.isEmpty()) {
            sb.append("\n  Cheeses: ");
            for (Topping cheese : cheeses) {
                sb.append(cheese.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (!regulars.isEmpty()) {
            sb.append("\n  Toppings: ");
            for (Topping topping : regulars) {
                sb.append(topping.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (!sauces.isEmpty()) {
            sb.append("\n  Sauces: ");
            for (String sauce : sauces) {
                sb.append(sauce).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }

}
