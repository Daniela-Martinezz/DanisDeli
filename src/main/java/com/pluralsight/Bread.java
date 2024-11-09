package com.pluralsight;

public class Bread {
    private String breadType;
    private String size;


    public Bread(String breadType, String size) {
        this.breadType = breadType;
        this.size = size;
    }
    public double getBreadCost() {
        //EXPLAIN: Switch statement for bread type along with prices.
        switch (size) {
            case "4\"":
                return 5.50; //EXPLAIN: base price
            case "8\"":
                return 7.00;
            case "12\"":
                return 8.50;
            default:
                System.out.println("Invalid size selected.");
                return 0;
        }

    }
        public String getType(){
            return breadType;
        }
        public String getSize() {
        return size;
        }

}
