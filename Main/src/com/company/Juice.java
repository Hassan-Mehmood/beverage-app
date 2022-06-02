package com.company;

import javax.swing.*;

public class Juice extends Beverage {

    private String fruit;
    String[] fruits = { "Apple", "Orange", "Pineapple" };

    Juice(String size, int glasses) {
        super(size, glasses);
        fruit = (String) JOptionPane.showInputDialog(null, "Select Juice", "Select Juice",
                JOptionPane.QUESTION_MESSAGE, null, fruits, fruits[0]);

        double price = 0;

        if(size.equals("Small")) {
            price = 40 * glasses;
        } else if (size.equals("Medium")) {
            price = 70 * glasses;
        } else if (size.equals("Large")) {
            price = 100 * glasses;
        }
        setPrice(price);
    }

    public String toString() {
        return super.toString() + fruit + " Juice";
    }














}
