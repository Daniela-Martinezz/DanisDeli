package com.pluralsight;

import java.util.List;

public class CustomerOrder {
    private String breadType;
    private String sizeChosen;
    private boolean isToasted;
    private String meatSelected;
    private String cheeseSelected;
    private List<String> toppings;
    private List<String> sauces;


    public CustomerOrder(String breadType, String sizeChosen, boolean isToasted, String meatSelected, String cheeseSelected, List<String> toppings, List<String> sauces) {
        this.breadType = breadType;
        this.sizeChosen = sizeChosen ;
        this.isToasted = isToasted;
        this.meatSelected = meatSelected;
        this.cheeseSelected = cheeseSelected;
        this.toppings = toppings;
        this.sauces = sauces;



    }
}
