package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItems{
    private String size;
    private String breadType;
    private List<Toppings> toppings;
    private boolean toasted;

    public Sandwich(String size, String breadType, boolean toasted ) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }
}
