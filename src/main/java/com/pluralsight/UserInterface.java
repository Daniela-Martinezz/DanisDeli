package com.pluralsight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;

    public static void display() {
        while (!exit) {
            System.out.println("Welcome to Dani's Deli!\n"+
                    "1) New Order\n"+
                    "0) Exit\n");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                   newOrder();
                   break;
                case 0:
                    exit = true; //EXPLAIN: Exiting program
                    System.out.println("Thank you for visiting Dani's Deli! Have a great day! :)");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    public static void newOrder() {
       List<MenuItem> orderItems = new ArrayList<>();
        boolean orderComplete = false;

        while (!orderComplete) {
        System.out.println("1) Add Sandwich \n" +
                "2) Add Drink\n" +
                "3) Add Chips\n" +
                "4) Checkout\n" +
                "0) Cancel Order\n");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1:
                Sandwich sandwich = customizeSandwich();
                orderItems.add(sandwich);
                System.out.println("Sandwich added to order.");
                break;
            case 2:
                Drink drink = drinkChosen();
                orderItems.add(drink);
                System.out.println("Drink added to order.");
                break;
            case 3:
               Chips chips = chipsChosen();
               orderItems.add(chips);
                System.out.println("Chips added to order.");
                break;
            case 4:
                checkout(orderItems);
                orderComplete = true;
                break;
            case 0:
                System.out.println("Order canceled.");
                orderItems.clear(); //EXPLAIN: clearing all items out of cart
                orderComplete = true;
                break;
            default:
                System.out.println("Invalid input");
        }
    }
 }
 public static Sandwich customizeSandwich() {

        //new: Making sure user chooses only items from menu
    Sandwich.Bread breadType = null;
    while (breadType == null) {
        System.out.println("Select your bread: ");
        System.out.println("-White\n-Wheat\n-Rye\n-Wrap");
        try {
            breadType = Sandwich.Bread.valueOf(scanner.nextLine().toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid bread type, please try again.");
        }
    }

    Sandwich.Size sizeChosen = null;
    while (sizeChosen == null) {
        System.out.println("Select Size: ");
        System.out.println("-Small(4\") -Medium(8\") -Large(12\"");
        try {
            sizeChosen = Sandwich.Size.valueOf(scanner.nextLine().toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size, please try again.");
        }
    }


     System.out.println("Would you like your sandwich toasted? (yes/no)");
     boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        //Meat selection:
     Sandwich.Meat meatSelected = null;
     while (meatSelected == null) {
     System.out.println("\nSelect Meat: "); //TODO Depending on size, price changes
     System.out.println("-Steak\n-Ham\n-Salami\n-Roast Beef\n-Chicken\n-Bacon");
       try{
           meatSelected = Sandwich.Meat.valueOf(scanner.nextLine().toUpperCase().trim());
       } catch (IllegalArgumentException e) {
           System.out.println("Invalid meat selection, please try again.");
       }
     }

     System.out.println("Would you like to add extra meat (yes/no)");//TODO Extra meat fee, i wanna change menu to show the cost depending what size they choose
     boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

     //Cheese selection
     Sandwich.Cheese cheeseSelected = null;
     while (cheeseSelected == null) {
         System.out.println("Select Cheese: ");
         System.out.println("-American" + "\n-Provolone" + "\n-Cheddar" + "\n-Swiss");
         try {
             cheeseSelected = Sandwich.Cheese.valueOf(scanner.nextLine().toUpperCase().trim());
         } catch (IllegalArgumentException e) {
             System.out.println("Invalid cheese selected. Please try again.");
         }
     }

     System.out.println("Would you like to add extra cheese (yes/no)");
     boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");

     List<String> selectedToppings = new ArrayList<>();
     System.out.println("Choose your toppings (type \"done\" when finished): ");
     String topping;

     do {
         System.out.println("Toppings:" +
                 "\n•Lettuce  •Peppers  •Onions" +
                 "\n•Tomatoes •Jalapeños •Cucumbers" +
                 "\n•Pickles  •Guacamole •Mushrooms");
         topping = scanner.nextLine().toUpperCase().trim();

         if (!topping.equalsIgnoreCase("done")) {
             selectedToppings.add(topping);
         }
     } while (!topping.equalsIgnoreCase("done")); //will run until user types done

         List<String> selectedSauces = new ArrayList<>();
         System.out.println("Choose your sauces (type \"done\" when finished): ");
         String sauce;

         do {
             System.out.println("Sauces:" +
                     "\n•Mayo  •Mustard  •Ketchup" +
                     "\n•Ranch •Thousand Islands •Vinaigrette");
             sauce = scanner.nextLine().toUpperCase().trim();

             if (!sauce.equalsIgnoreCase("done")) {
                 selectedSauces.add(sauce);

             }
         } while (!sauce.equalsIgnoreCase("done"));

     Sandwich.Sides sides = null;
     while (sides == null) {
         System.out.println("Choose a side: ");
         System.out.println("-Au Jus   -Sauce");

         String input = scanner.nextLine().toUpperCase().replace(" ", "_");
         try {
             sides = Sandwich.Sides.valueOf(input);
         } catch (IllegalArgumentException e) { //new: why does IOEXEPTION NW, LEARN DIFF**
             System.out.println("Invalid side choice, please try again.");
         }
     }

     // Create the Sandwich object
     Sandwich sandwich = new Sandwich(breadType, sizeChosen, isToasted, meatSelected, extraMeat, cheeseSelected, extraCheese, sides);
     for (String t : selectedToppings) sandwich.addTopping(t);
     for (String s : selectedSauces) sandwich.addSauce(s);

     return sandwich;

 }
    public static Chips chipsChosen() {
        Chips.ChipFlavor chipFlavor = null;
        while (chipFlavor == null) {
            System.out.println("Select chips for $1.50: ");
            System.out.println("Chips:" +
                    "\n•Hot Cheetos •Cheetos  •Jalapeno" +
                    "\n•Lays •Doritos •BBQ");

            String input = scanner.nextLine().toUpperCase().replace(" ", "_"); //new: For the enums to be read properly.

            try {
                chipFlavor = Chips.ChipFlavor.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid chip flavor selected. Please try again.");
            }
        }
        Chips chips = new Chips(chipFlavor);
        return chips;
    }
    public static Drink drinkChosen() {
        Drink.DrinkSize drinkSize = null;
        while (drinkSize == null) {
            System.out.println("Select size for drink: ");
            System.out.println("• S - $2.00" +
                    "\n• M - $2.50" +
                    "\n• L - $3.00");

            try {
                drinkSize = Drink.DrinkSize.valueOf(scanner.nextLine().toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid size selected. Please try again.");
            }
        }

        Drink.DrinkFlavors drinkFlavors = null;
        while (drinkFlavors == null) {
            System.out.println("Select drink flavor: ");
            System.out.println("Drinks:" +
                    "\n•Coca Cola  •Sprite  •Crush" +
                    "\n•Ginger Ale •Gatorade •Iced Tea");

            String input = scanner.nextLine().toUpperCase().replace(" ", "_");

            try {
                drinkFlavors = Drink.DrinkFlavors.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid drink flavor selected. Please try again");
            }

        }
        Drink drink = new Drink(drinkSize, drinkFlavors);
        return drink;
    }
    public static void checkout(List<MenuItem> orderItems) {
        System.out.println("Your order summary:");
        for (MenuItem item : orderItems) { //loop to show everything purchased
            System.out.println(item);
        }
        System.out.println("$" + calculateTotal(orderItems));
        System.out.println("1) Confirm \n" + "2) Cancel \n");
        int input = scanner.nextInt();
        scanner.nextLine();

            switch (input) {
                case 1:
                    ReceiptFileManager.customerReceipt(orderItems);
                    System.out.println("Order confirmed. Receipt saved!");
                    break;
                case 0:
                    orderItems.clear();
                    System.out.println("Order Cancelled.");
                    break;
                default:
                    System.out.println("Invalid Input");
            } //TODO: Add checkout confirmation
        }

        public static double calculateTotal(List<MenuItem> orderItems) {
        double total = 0.0;

       for (MenuItem item : orderItems) {
           total += item.getPrice();
        }
        return total;
        }
}
