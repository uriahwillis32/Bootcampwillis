package org.example;

public class Drink {
    private DrinkSize size;
    private String flavor;


    public Drink(String flavor, DrinkSize size) {
        this.flavor = flavor;
        this.size = size;
    }

    public double getCost() {
        if (size == DrinkSize.SMALL) {
            return 2.00;
        }
        if (size == DrinkSize.MEDIUM) {
            return 2.50;
        }
        else{
            return 3.00;
        }
    }
    @Override
    public String toString() {
        return String.format("%s Drink (%s) - $%.2f", flavor, size, getCost());
    }
}






