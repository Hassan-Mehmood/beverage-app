package com.company;

import javax.swing.*;

public class Tea extends Beverage{

    private boolean sugar;
    private double price;

    Tea(String size, int glasses)  {
        super(size, glasses);

        int choice = JOptionPane.showConfirmDialog(null, "Do you want some sugar? ",
                "Do you want some sugar", JOptionPane.YES_NO_OPTION);

        if(choice == 0) sugar = true; else sugar = false;

        if(size == "Small") price = 20 * glasses;
        if(size == "Medium") price = 35 * glasses;
        if(size == "Large") price = 60 * glasses;

        setPrice(price);
    }

    @Override
    public String toString() {
        if (sugar)
            return super.toString() + "Tea with sugar";
        else
            return super.toString() + "Tea without sugar";
    }
}
