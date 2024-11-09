package com.pluralsight;

import java.util.ArrayList;
import java.util.Arrays;

public class Topping {
    private String toppingName;
    private String size; //bring back diff price per size
    private boolean isExtra;

    public Topping(String toppingName, String size, boolean isExtra) {
        this.toppingName = toppingName;
        this.size = size;
        this.isExtra = isExtra;
    }

    //EXPLAIN: similar to bread, we will indicate diff prices per topping
    public double getToppingCost() {
        double basePrice = 0.0;
        double extraCharge = 0.0;

        switch (toppingName.toLowerCase()) {
            case "meat":
                switch (size) {
                    case "4\"":
                        basePrice = 1.00;
                        extraCharge = .50;
                        break;
                    case "8\"":
                        basePrice = 2.00;
                        extraCharge = 1.00;
                        break;
                    case "12\"":
                        basePrice = 3.00;
                        extraCharge = 1.50;
                        break;
                    default:
                        System.out.println("Invalid topping size");
                        break;
                }
                break;

            case "cheese":
                switch (size) {
                    case "4\"":
                        basePrice = 0.75;
                        extraCharge = 0.30;
                        break;
                    case "8\"":
                        basePrice = 1.50;
                        extraCharge = 0.60;
                        break;
                    case "12\"":
                        basePrice = 2.25;
                        extraCharge = 0.90; //*IDEA*: Do i need to add an option if they do not want cheese
                        break;
                    default:
                        System.out.println("Invalid cheese type");
                        break;
                }
                break;
            case "regular":
                // Regular toppings are free
                basePrice = 0.0;
                extraCharge = 0.0;
                break;

            default:
                System.out.println("Invalid topping type.");
                break;
        }

        // EXPLAIN: Add the extra charge if isExtra is true
        return isExtra ? basePrice + extraCharge : basePrice;
    }
}

