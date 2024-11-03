package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptFileManager {

    public void customerReceipt() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String formattedDate = formatter.format(new Date());

        // file with date + time
        //TODO: do i need to make it a txt file?
        String fileName = formattedDate + ".txt";

        File customerReceiptFile = new File(fileName);

        //TODO: complete receipt format :)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerReceiptFile))) {
            //details written to receipt
            writer.write("Your Order:");

        } catch (IOException e) {
            System.out.println("An error occurred creating customer receipt file.");
        }
    }

}
