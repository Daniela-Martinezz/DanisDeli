package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptFileManager {
        //bringing in menuItems as a list to create a receipt from orderItems.
    public static void customerReceipt(List<MenuItem> orderItems) {
        //creating date and time format which will also be used for the file name
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timeNow + ".txt"; //path for new file

        File customerReceiptFile = new File(fileName);

        //TODO: complete receipt format **MAKE IT NICER:)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerReceiptFile))) {
            //details written to receipt
            writer.write("========================================\n");
            writer.write("        *** Dani's Deli ***\n");
            writer.write("           Order Receipt\n");
            writer.write("========================================\n");

            writer.write("Order Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("========================================\n");
            writer.write("Items Ordered:\n");
            for (MenuItem item : orderItems) {
                writer.write( item + "\n\n");
            }
            double total = UserInterface.calculateTotal(orderItems);
            writer.write("\nTotal: $" + String.format("%.2f", total) + "\n");
            writer.write("====================================\n");
            writer.write("Thank you for visiting Dani's Deli!\n");


            System.out.println("Receipt saved to: " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred creating customer receipt file.");
        }
    }

}
