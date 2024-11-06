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

    public void customerReceipt(List<String> orderItems) {
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timeNow + ".txt"; //path for new file

        File customerReceiptFile = new File(fileName);

        //TODO: complete receipt format :)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerReceiptFile))) {
            //details written to receipt
            writer.write("Receipt for your order:\n");
            writer.write("====================================\n");

            //EXPLAIN: Adding order to new file

            for (String item : orderItems) {
                writer.write(item + "\n");
            }
            writer.write("====================================\n");
            writer.write("Thank you for visiting Dani's Deli");
            writer.write("Order placed: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");

            System.out.println("Receipt saved to: " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred creating customer receipt file.");
        }
    }

}
