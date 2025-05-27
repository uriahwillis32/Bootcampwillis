package org.example;

public class Topping {
    private ToppingType type;
    private String name;
    private int quantity;

    // ✅ Constructor you need
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
        double base = 0.0;

        if (type == ToppingType.MEAT) {
            if (size == SandwichSize.FOUR_INCH) {
                base = 1.0;
            } else if (size == SandwichSize.EIGHT_INCH) {
                base = 2.0;
            } else if (size == SandwichSize.TWELVE_INCH) {
                base = 3.0;
            }

            if (quantity > 1) {
                if (size == SandwichSize.FOUR_INCH) {
                    base += (quantity - 1) * 0.5;
                } else if (size == SandwichSize.EIGHT_INCH) {
                    base += (quantity - 1) * 1.0;
                } else if (size == SandwichSize.TWELVE_INCH) {
                    base += (quantity - 1) * 1.5;
                }
            }

        } else if (type == ToppingType.CHEESE) {
            if (size == SandwichSize.FOUR_INCH) {
                base = 0.75;
            } else if (size == SandwichSize.EIGHT_INCH) {
                base = 1.5;
            } else if (size == SandwichSize.TWELVE_INCH) {
                base = 2.25;
            }

            if (quantity > 1) {
                if (size == SandwichSize.FOUR_INCH) {
                    base += (quantity - 1) * 0.3;
                } else if (size == SandwichSize.EIGHT_INCH) {
                    base += (quantity - 1) * 0.6;
                } else if (size == SandwichSize.TWELVE_INCH) {
                    base += (quantity - 1) * 0.9;
                }
            }
        }

        return base;
    }
}
