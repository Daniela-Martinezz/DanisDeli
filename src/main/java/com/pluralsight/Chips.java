package com.pluralsight;

public class Chips implements MenuItem {
    //ENUMS:
    public enum ChipFlavor {
        HOT_CHEETOS, CHEETOS, JALAPENO, LAYS, DORITOS,
        BBQ
    }
    //Attributes
    private ChipFlavor chipsFlavor;
    private double chipsPrice = 1.50;

    //Constructor
    public Chips(ChipFlavor chipsFlavor) {
        this.chipsFlavor = chipsFlavor;
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
        return "Chips:\n" + chipsFlavor;
    }
}

