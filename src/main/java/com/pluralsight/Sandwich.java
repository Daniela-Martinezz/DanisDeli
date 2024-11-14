package com.pluralsight;

import java.util.List;

public class Sandwich implements MenuItem {
    //ENUMS:
    public enum Bread{
        WHITE, WHEAT, RYE, WRAP
    }
    public enum Size{ //ensuring price can be reached in other classes
        S(4.50), M(7.00), L(8.50);

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
    public enum Sides{
        AU_JUS, SAUCE
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
    public Sandwich(Bread breadType, Size sizeChosen, boolean isToasted, Meat meatSelected, boolean extraMeat, Cheese cheeseSelected, boolean extraCheese, Sides sides, List<String> toppings, List<String> sauces) {
        this.breadType = breadType;
        this.sizeChosen = sizeChosen;
        this.isToasted = isToasted;
        this.meatSelected = meatSelected;
        this.extraMeat = extraMeat;
        this.cheeseSelected = cheeseSelected;
        this.extraCheese = extraCheese;
        this.sides = sides;
        this.toppings = toppings;
        this.sauces = sauces;
    }
    //Cost of a sandwich per size
    @Override
    public double getPrice() {
        double baseCost = sizeChosen.getBasePrice(); //using enums price

        switch (sizeChosen) {
            case S:
                baseCost += 1.00; //meat
                baseCost += 0.75; //cheese
                if (extraMeat) baseCost += 0.50;
                if (extraCheese) baseCost += 0.30; //In case user adds extra on 4"
                break;
            case M:
                baseCost += 2.00; //meat
                baseCost += 1.50; //cheese
                if (extraMeat) baseCost += 1.00;
                if (extraCheese) baseCost += .60;
                break;
            case L:
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
        return "Sandwich: " + sizeChosen + ", " + breadType + (isToasted ? " (T)" : " ") +
        " with " + meatSelected + (extraMeat ? " (+)" : " ") + ", " + cheeseSelected + (extraCheese ? " (+)" : " ") + ", " + String.join(", ", toppings) + ", " + String.join(", ", sauces);
    }

    @Override
    public String toString() {
        return String.format("Sandwich:\n- %s, %s%s\n- %s%s, - %s%s\n- %s\n- %s\n- %s",
                sizeChosen, breadType, (isToasted ? " (T)" : " "), meatSelected, (extraMeat ? " (extra)" : ""),
                cheeseSelected, (extraCheese ? " (extra)" : ""),
                String.join(", ", toppings), String.join(", ", sauces), sides);
    }
}
