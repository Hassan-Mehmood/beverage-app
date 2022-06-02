package com.company;

import javax.swing.*;

public class Coffee extends Beverage {
    private boolean milk = false;
    private double price;
    Coffee (String size, int glasses) {
        super(size, glasses);

        int choice = JOptionPane.showConfirmDialog(null,"Do you want milk?",
                "Do you want milk", JOptionPane.YES_NO_OPTION);

        if(choice == 0) milk = true;

        if(size.equals("Small")) price = 50 * glasses;
        if(size.equals("Medium")) price = 80 * glasses;
        if(size.equals("Large")) price = 120 * glasses;

        setPrice(price);
    }

    @Override
    public String toString() {
        if(milk)
            return super.toString() + "Coffee with milk";
        else
            return super.toString() + "Coffee without milk";

    }


}
