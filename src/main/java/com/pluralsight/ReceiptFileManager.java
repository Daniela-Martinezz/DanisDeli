package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ReceiptFileManager {

    public static void customerReceipt(List<String> orderItems) {
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timeNow + ".txt"; //path for new file

        File customerReceiptFile = new File(fileName);

        //TODO: complete receipt format **MAKE IT NICER:)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerReceiptFile))) {
            //details written to receipt
            writer.write("==== Dani's Deli Order Receipt ====\n");
            writer.write("Order Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");
            writer.write("Items Ordered:\n");
            for (String item : orderItems) {
                writer.write("- " + item + "\n");
            }
           // writer.write("\nTotal: $" + calculateTotal(orderItems) + "\n"); // add calculateTotal
            writer.write("====================================\n");
            writer.write("Thank you for visiting Dani's Deli!\n");

            System.out.println("Receipt saved to: " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred creating customer receipt file.");
        }
    }

}
