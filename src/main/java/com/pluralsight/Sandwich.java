package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements MenuItem {
    //ENUMS:
    public enum Bread{
        WHITE, WHEAT, RYE, WRAP
    }
    public enum Size{ //ensuring price can be reached in other classes
        SMALL(4.50), MEDIUM(7.00), LARGE(8.50);

        private double price;

        Size(double price) {
            this.price = price;

        }
        public double getBasePrice() {
            return price;
        }
    }
    public enum Meat{
        STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON
    }
    public enum Cheese{
        AMERICAN, PROVOLONE, CHEDDAR, SWISS
    }
    public enum Toppings{
        LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS,
        PICKLES, GUACAMOLE, MUSHROOMS
    }
    public enum Sauce{
        MAYO, MUSTARD, KETCHUP, RANCH,
        THOUSAND_ISLANDS, VINAIGRETTE
    }
    public enum Sides{
        AU_JUS, SAUCE //TODO implement sides to sandwich
    }

   //Attributes
    private Bread breadType;
    private Size sizeChosen;
    private boolean isToasted;
    private Meat meatSelected;
    private boolean extraMeat;
    private Cheese cheeseSelected;
    private boolean extraCheese;
    private Sides sides;
    private List<String> toppings;
    private List<String> sauces;

    //Constructor
    public Sandwich(Bread breadType, Size sizeChosen, boolean isToasted, Meat meatSelected, boolean extraMeat, Cheese cheeseSelected, boolean extraCheese, Sides sides) {
        this.breadType = breadType;
        this.sizeChosen = sizeChosen;
        this.isToasted = isToasted;
        this.meatSelected = meatSelected;
        this.extraMeat = extraMeat;
        this.cheeseSelected = cheeseSelected;
        this.extraCheese = extraCheese;
        this.sides = sides;
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
        double baseCost = sizeChosen.getBasePrice(); //using enums price

        switch (sizeChosen) {
            case SMALL:
                baseCost += 1.00; //meat
                baseCost += 0.75; //cheese
                if (extraMeat) baseCost += 0.50;
                if (extraCheese) baseCost += 0.30; //In case user adds extra on 4"
                break;
            case MEDIUM:
                baseCost += 2.00; //meat
                baseCost += 1.50; //cheese
                if (extraMeat) baseCost += 1.00;
                if (extraCheese) baseCost += .60;
                break;
            case LARGE:
                baseCost += 3.00; //meat
                baseCost += 2.25; //cheese
                if (extraMeat) baseCost += 1.50;
                if (extraCheese) baseCost += 0.90;
                break;
            default:
                System.out.println("Invalid size selected.");
                break;
        }
        return baseCost;
    }


    @Override
    public String getDescription() {
        return "Sandwich - " + sizeChosen + " " + breadType +
        " with " + meatSelected + " and " + cheeseSelected; //new: need for this idk?
    }

    @Override
    public String toString() {
        return "Sandwich - Bread: " + breadType + ", " +
                 " Size: " + sizeChosen + ", " +
                " Meat: " + meatSelected + (extraMeat ? " (extra)" : "") + ", " +
                " Cheese: " + cheeseSelected + (extraCheese ? " (extra)" : "") + ", " + //Explain: condition ? valueIfTrue : valueIfFalse
                " Toppings: " + String.join(", ", toppings) + ", " +
                " Sauces: " + String.join(", ", sauces) + ", " +
                " Sides: " + sides;
    }
}
