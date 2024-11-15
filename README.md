# Java Sandwich Shop Application

## Overview

This Java-based Sandwich Shop application simulates a virtual sandwich store where customers can customize sandwiches, drinks, and chips. The app allows users to build their own sandwiches with various bread types, sizes, meats, cheeses, toppings, and sauces. It then calculates the order's total cost and generates a formatted receipt.

## Features

- **Custom Sandwich Builder**: Users can create a sandwich by selecting bread type, size, toasted preference, meat and cheese options, toppings, and sauces.
- **Drink and Chips Options**: Customers can add drinks and chips to their order.
- **Order Summary and Receipt**: A detailed receipt displays itemized selections, quantities, and total cost. Receipts are saved for record-keeping.

## Class Structure

### Main Components

- **Main**: The main entry point of the application, initializing the user interface.
- **UserInterface**: Handles the interaction with customers, including item selection, order customization, and checkout.
- **MenuItem Interface**: Defines the structure for all menu items, including methods for getting descriptions and calculating prices.

### Classes

- **Sandwich**: Represents a customizable sandwich. Implements `MenuItem` and includes options for bread type, size, toast, meat and cheese, toppings, and sauces.
- **Drink**: Represents a drink selection. Implements `MenuItem` and includes attributes for drink size and type.
- **Chips**: Represents a chips selection. Implements `MenuItem` and includes options for flavor and size.

### Supporting Classes

- **ReceiptFileManager**: Manages receipt creation and storage. Handles receipt formatting for improved readability.
- **OrderHandling**: Manages order processing, including calculating the total cost, managing discounts, and confirming orders.

## Usage

1. Start the program by running the `Main` class.
2. Follow the on-screen prompts to customize your sandwich, select drinks and chips, and review the order.
3. Confirm the order to generate a receipt. The receipt will display all items and the total price, saved in a readable format.


### Demo: Ordering a Menu Items:
![MakingAnOrder](https://github.com/user-attachments/assets/f267e0a9-08a4-478b-82f2-6dc06b9aed17)

**Description**: The user can customize their sandwich fully. They are also able to order a drink and chips from the menu. The program confirms with the user and then creates a receipt or clears the selections. 
### Demo: Viewing Receipt:
![Receipt](https://github.com/user-attachments/assets/b2aacdf3-9e42-4b74-8c35-9c09e1442b8a)

**Description**: The user's receipt from the demo.

### UML Diagram
![UML_Sandwich drawio](https://github.com/user-attachments/assets/946e4c49-b5e4-4a0c-a344-50ed8fd0881a)
