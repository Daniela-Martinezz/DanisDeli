package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;
    private static List<String> toppingMenu = List.of( //EXPLAIN: create list
            "LETTUCE", "PEPPERS", "ONIONS", "TOMATOES", "JALAPENOS", "CUCUMBERS",
            "PICKLES", "GUACAMOLE", "MUSHROOMS"
    );
    private static List<String> sauceMenu = List.of(
            "MAYO", "MUSTARD", "KETCHUP", "RANCH", "THOUSAND ISLANDS", "VINAIGRETTE"
    );
    //1st Menu:
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
        System.out.println("Add item: \n" +
                "1) Add Sandwich \n" +
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
                System.out.println("Order cancelled.");
                orderItems.clear(); //EXPLAIN: clearing all items out of cart
                orderComplete = true;
                break;
            default:
                System.out.println("Invalid input");
        }
    }
 }
 public static Sandwich customizeSandwich() {

    //Step 1: select bread type. * Sandwich.Bread is enum from sandwich class
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

    //Step 2: selecting sandwich size
    Sandwich.Size sizeChosen = null;
    while (sizeChosen == null) {
        System.out.println("Select Size: ");
        System.out.println("-S (4\")\n-M (8\")\n-L (12\")");
        try {
            sizeChosen = Sandwich.Size.valueOf(scanner.nextLine().toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size, please try again.");
        }
    }


    //Step 3: toasted or not?
     System.out.println("Would you like your sandwich toasted? (yes/no)");
     boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

     //Step 4: select meat
     Sandwich.Meat meatSelected = null;
     while (meatSelected == null) {
     System.out.println("\nSelect Meat: ");
     System.out.println("-Steak\n-Ham\n-Salami\n-Roast Beef\n-Chicken\n-Bacon");
       try{
           meatSelected = Sandwich.Meat.valueOf(scanner.nextLine().toUpperCase().trim());
       } catch (IllegalArgumentException e) {
           System.out.println("Invalid meat selection, please try again.");
       }
     }

     //Step 5: extra meat?
     System.out.println("Would you like to add extra meat (yes/no)");
     boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

     //Step 6: Select cheese!
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
     //Step 7: extra cheese?
     System.out.println("Would you like to add extra cheese (yes/no)");
     boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");

     //Step 8: Topping selection:
     List<String> selectedToppings = new ArrayList<>(); //list to store selected toppings
     boolean addingToppings = true;

     System.out.println("Topping Selection: ");
     for (int i = 0; i < toppingMenu.size(); i++) {
         System.out.println((i + 1) + ". " + toppingMenu.get(i));
     }
     //SELECT:
     while (addingToppings) {
         System.out.println("Enter the number of the topping you'd like to add (or 0 to finish): ");
         int toppingChoice = scanner.nextInt();
         scanner.nextLine();

         if (toppingChoice == 0){
             //finished adding toppings
             addingToppings = false;
         } else if (toppingChoice > 0 && toppingChoice <= toppingMenu.size()) {
             //valid choice
             String topping = toppingMenu.get(toppingChoice - 1);
             selectedToppings.add(topping);
             System.out.println(topping + " added to your sandwich.");
         } else {
             //invalid input
             System.out.println("Invalid choice. Please choose a valid topping number.");
         }
     }

     //Step 9: sauce selection:
     List<String> selectedSauces = new ArrayList<>();
     boolean addingSauces = true;
     System.out.println("Sauce Selection: ");
     for (int i = 0; i < sauceMenu.size(); i++) {
         System.out.println((i + 1) + ". " + sauceMenu.get(i));
     }
     while (addingSauces) {
         System.out.println("Enter the number of the sauce you'd like to add (or 0 to finish): ");
         int sauceChoice = scanner.nextInt();
         scanner.nextLine();

         if (sauceChoice == 0) {
             addingSauces = false; //completed adding sauces
         } else if (sauceChoice > 0 && sauceChoice <= sauceMenu.size()) {
             String sauce = sauceMenu.get(sauceChoice - 1);
             selectedSauces.add(sauce);
             System.out.println(sauce + " added to your sandwich.");
         } else {
             System.out.println("Invalid choice. Please choose a valid sauce number.");

         }
     }
     Sandwich.Sides sides = null;
     while (sides == null) {
         System.out.println("Choose a side: ");
         System.out.println("-Au Jus\n-Sauce");

         String input = scanner.nextLine().toUpperCase().replace(" ", "_");

         try {
             sides = Sandwich.Sides.valueOf(input);
         } catch (IllegalArgumentException e) {
             System.out.println("Invalid side choice, please try again.");
         }
     }
     // Create the Sandwich object
     Sandwich sandwich = new Sandwich(breadType, sizeChosen, isToasted, meatSelected, extraMeat, cheeseSelected, extraCheese, sides, selectedToppings, selectedSauces);

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

        //DRINK MENU:
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
            System.out.println(item + "  (" + String.format("$%.2f", item.getPrice()) +")" + "\n----------------------------------------");
            //System.out.println("----------------------------------------");

        }
        System.out.println("Total: " + String.format("$%.2f", calculateTotal(orderItems)));
        System.out.println("\nWould you like to confirm your order?");
        System.out.println("1) Confirm \n" + "2) Cancel \n");
        int input = scanner.nextInt();
        scanner.nextLine();

            switch (input) {
                case 1:
                    ReceiptFileManager.customerReceipt(orderItems);
                    System.out.println("Order confirmed. Receipt saved!");
                    break;
                case 2:
                    orderItems.clear();
                    System.out.println("Order Cancelled.");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

        public static double calculateTotal(List<MenuItem> orderItems) {
        double total = 0.0;

       for (MenuItem item : orderItems) {
           total += item.getPrice();
        }
        return total;
        }
}
