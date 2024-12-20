package com.pluralsight;

public class Drink implements MenuItem {
    //ENUMS:
    //enum for drink sizes with prices
    public enum DrinkSize{
        S(2.00), M(2.50), L(3.00);

        private double price;

        DrinkSize(double price) {
            this.price = price;

        }
        public double getPrice() {
            return price;
        }

    }
    public enum DrinkFlavors{
        COCA_COLA, SPRITE, CRUSH, GINGER_ALE, GATORADE, ICED_TEA
    }

    //Attributes
    private DrinkSize size;
    private DrinkFlavors flavor;


    //Constructor w/ enums
    public Drink(DrinkSize size, DrinkFlavors flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    //using method from DrinkSize
    @Override
    public double getPrice() {
        return size.getPrice();
    }
    //using enum values
    @Override
    public String getDescription() {
        return "Soda\nSize: " + size + "\nType: " + flavor;
    }
    @Override
    public String toString() {
        return "Soda:\n" + size + ", " + flavor;
    }
}
