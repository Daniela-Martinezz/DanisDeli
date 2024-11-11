package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements MenuItem {
   //Attributes
    private String breadType;
    private String size;
    private boolean isToasted;
    private String meat;
    private boolean extraMeat;
    private String cheese;
    private boolean extraCheese;
    private List<String> toppings;
    private List<String> sauces;

    //Constructor
    public Sandwich(String breadType, String size, boolean isToasted, String meat, boolean extraMeat, String cheese, boolean extraCheese) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }
    public void addTopping(String topping) {
        toppings.add(topping);
    }
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }
    //Cost of a sandwich per size
    @Override
    public double getPrice() {
        double baseCost = 0.0;

        switch (size) {
            case "4\"":
                baseCost = 5.50;
                baseCost += 1.00; //meat
                baseCost += 0.75; //cheese
                if (extraMeat) baseCost += 0.50;
                if (extraCheese) baseCost += 0.30; //In case user adds extra on 4"
                break;
            case "8\"":
                baseCost = 7.00;
                baseCost += 2.00; //meat
                baseCost += 1.50; //cheese
                if (extraMeat) baseCost += 1.00;
                if (extraCheese) baseCost += .60;
                break;
            case "12\"":
                baseCost = 8.50;
                baseCost += 3.00; //meat
                baseCost += 2.25; //cheese
                if (extraMeat) baseCost += 1.50;
                if (extraCheese) baseCost += 0.90;
                break;
            default:
                System.out.println("Invalid size selected.");

        }
        return baseCost;
    }


    @Override
    public String getDescription() {
        return "Sandwich - " + size + " " + breadType +
        " with " + meat + " and " + cheese; //new: need for this idk?
    }
    @Override
    public String toString() {
        return "Sandwich\nBread: " + breadType +
                "\nSize: " + size +
                "\nMeat: " + meat + (extraMeat ? "extra" : "") +
                "\nCheese: " + cheese + (extraCheese ? "extra" : "") + //Explain: condition ? valueIfTrue : valueIfFalse
                "\nToppings: " + String.join(", ", toppings) +
                "\nSauces: " + String.join(", ", sauces);
    }
}
