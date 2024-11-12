package com.pluralsight;

public class Chips implements MenuItem {
    //Attributes
    private String chipsFlavor;
    private double chipsPrice;

    public Chips(String chipsFlavor) {
        this.chipsFlavor = chipsFlavor;
        this.chipsPrice = 1.50;
    }
    //enum:
    public enum chipTypes{
       hot_cheetos, cheetos, jalapeno, lays, doritos,
        bbq

    }

    public String getChipsFlavor() {
        return chipsFlavor;
    }

    public double getChipsPrice() {
        return chipsPrice;
    }

    @Override
    public double getPrice() {
        return chipsPrice;
    }

    @Override
    public String getDescription() {
        return "Chips\nFlavor: " + chipsFlavor;
    }
    @Override
    public String toString() {
        return "Chips - Flavor: " + chipsFlavor;
    }
}

