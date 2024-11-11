package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;
   // static List<MenuItem> orderItems = new ArrayList<>();

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
     System.out.println("Select your bread: ");
     System.out.println("-White\n-Wheat\n-Rye\n-Wrap");
     String breadType = scanner.nextLine();

     System.out.println("\nSelect Size: ");
     System.out.println("-4\"\n-8\"\n-12\"");
     String sizeChosen = scanner.nextLine();

     System.out.println("Would you like your sandwich toasted? (yes/no)");
     boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        //Meat and cheese selections:
     System.out.println("\nSelect Meat: "); //TODO Depending on size, price changes
     System.out.println("-Steak\n-Ham\n-Salami\n-Roast Beef\n-Chicken\n-Bacon");
     String meatSelected = scanner.nextLine();

     System.out.println("Would you like to add extra meat (yes/no)");//TODO Extra meat fee, i wanna change menu to show the cost depending what size they choose
     boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

     System.out.println("Select Cheese: ");
     System.out.println("-American" + "\n-Provolone" + "\n-Cheddar" + "\n-Swiss");
     String cheeseSelected = scanner.nextLine();

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
         topping = scanner.nextLine();

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
             sauce = scanner.nextLine();

             if (!sauce.equalsIgnoreCase("done")) {
                 selectedSauces.add(sauce);

             }
         } while (!sauce.equalsIgnoreCase("done"));

     // Create the Sandwich object
     Sandwich sandwich = new Sandwich(breadType, sizeChosen, isToasted, meatSelected, extraMeat, cheeseSelected, extraCheese);
     for (String t : selectedToppings) sandwich.addTopping(t);
     for (String s : selectedSauces) sandwich.addSauce(s);

     return sandwich;

 }
    public static Chips chipsChosen() {
        System.out.println("Select chips for $1.50: ");
        System.out.println("Chips:" +
                "\n•Hot Cheetos  •Cheetos  •Jalapeño" +
                "\n•Lays •Doritos •BBQ");
        String chipsFlavor = scanner.nextLine().toLowerCase(); //avoiding case sensitivity

        //**chip object for flavor
        Chips chips = new Chips(chipsFlavor);

        //Returning chips
        return chips;
//new: Testing

    }
    public static Drink drinkChosen() {
        System.out.println("Select size for drink: ");
        System.out.println("• Small - $2.00" +
                "\n• Medium - $2.50" +
                "\n• Large - $3.00");
        String drinkSize = scanner.nextLine().toLowerCase(); //1st get size

        System.out.println("Select drink flavor: ");
        System.out.println("Drinks:" +
                "\n•Coca Cola  •Sprite  •Crush" +
                "\n•Ginger Ale •Gatorade •Iced Tea");
        String drinkFlavor = scanner.nextLine(); //2nd get flavor

        Drink drink = new Drink(drinkSize, drinkFlavor); //creating object

        return drink;
    }

    public static void checkout(List<MenuItem> orderItems) {
        System.out.println("Your order summary:");
        for (MenuItem item : orderItems) {
            System.out.println("- " + item);
            System.out.println(calculateTotal(orderItems));
        }
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
