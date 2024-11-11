package com.pluralsight;

public class Drink implements MenuItem {
    //Attributes
    private String size;
    private String flavor;

    //Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

    }
    @Override
    public double getPrice() {
        double drinkCost = 0.0;

        switch (size) {
            case "small":
                drinkCost = 2.00;
                break;
            case "medium":
                drinkCost = 2.50;
                break;
            case "large":
                drinkCost = 3.00;
                break;
        }
        return drinkCost;
    }

    @Override
    public String getDescription() {
        return "Soda\nSize: " +
                size + "\nType: " + flavor;
    }
    @Override
    public String toString() {
        return "Soda\nSize: " +
                size + "\nType: " + flavor;
    }
}
