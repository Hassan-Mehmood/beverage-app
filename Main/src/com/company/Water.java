package com.company;

import javax.swing.*;

public class Water extends Beverage {

    private boolean ice;
    private double price;

    Water(String size, int glasses) {
        super(size, glasses);
        int choice = JOptionPane.showConfirmDialog(null, "Do you want some ice? ",
                "Do you want some ice", JOptionPane.YES_NO_OPTION);

        if(choice == 0) ice = true; else ice = false;

        if(size == "Small") price = 30 * glasses;
        if(size == "Medium") price = 60 * glasses;
        if(size == "Large") price = 90 * glasses;

        setPrice(price);
    }

    @Override
    public String toString() {

        if(ice)
            return super.toString() + "water with ice";
        else
            return super.toString() + "water";
    }
}

