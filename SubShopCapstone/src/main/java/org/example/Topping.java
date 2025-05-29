package org.example;

public class Topping {
    private ToppingType type;
    private String name;
    private int quantity;


    public Topping(String name, ToppingType type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public ToppingType getType() {
        return type;
    }

    public double getCostForEachToppingEnum(SandwichSize size) {
        double originalCost = 0.0;

        if (type == ToppingType.MEAT) {
            if (quantity >= 1) {
                if (size == SandwichSize.FOUR_INCH) {
                    originalCost = 1.00 + (quantity - 1) * 0.50;
                } else if (size == SandwichSize.EIGHT_INCH) {
                    originalCost = 2.00 + (quantity - 1) * 1.00;
                } else if (size == SandwichSize.TWELVE_INCH) {
                    originalCost = 3.00 + (quantity - 1) * 1.50;
                }
            }
        } else if (type == ToppingType.CHEESE) {
            if (quantity >= 1) {
                if (size == SandwichSize.FOUR_INCH) {
                    originalCost = 0.75 + (quantity - 1) * 0.30;
                } else if (size == SandwichSize.EIGHT_INCH) {
                    originalCost = 1.50 + (quantity - 1) * 0.60;
                } else if (size == SandwichSize.TWELVE_INCH) {
                    originalCost = 2.25 + (quantity - 1) * 0.90;
                }
            }
        }


        if (type == ToppingType.MEAT && quantity == 1) {
            if (size == SandwichSize.FOUR_INCH) {
                originalCost = 1.00;
            } else if (size == SandwichSize.EIGHT_INCH) {
                originalCost = 2.00;
            } else if (size == SandwichSize.TWELVE_INCH) {
                originalCost = 3.00;
            }
        } else if (type == ToppingType.CHEESE && quantity == 1) {
            if (size == SandwichSize.FOUR_INCH) {
                originalCost = 0.75;
            } else if (size == SandwichSize.EIGHT_INCH) {
                originalCost = 1.50;
            } else if (size == SandwichSize.TWELVE_INCH) {
                originalCost = 2.25;
            }
        }

        return originalCost;

        }
    }




