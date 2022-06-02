package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class Window extends JFrame implements ActionListener {

    private JLabel sizeLabel, bevrgeLabel, fieldLabel, orderLabel;
    private JComboBox sizeMenu;
    private JRadioButton juiceBtn, waterBtn, teaBtn, coffeeBtn;
    private ButtonGroup btnGroup;
    private JTextField field;
    private JButton buttonAdd, buttonOrder;
    private ArrayList<Beverage> beveragesAll = new ArrayList<>();

    Window()
    {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        createWindow();
        buttonAdd.addActionListener(this);
        buttonOrder.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createWindow()
    {
        selectSize();
        beverageType();
        setField();
        buttons();
    }

    private void selectSize()
    {
        sizeLabel = new JLabel("Select Size");
        sizeLabel.setBounds(100,10,250,50);
        add(sizeLabel);

        String[] sizeOpitons = {"Small", "Medium", "Large"};

        sizeMenu = new JComboBox(sizeOpitons);
        sizeMenu.setBounds(100, 50, 100,20);
        add(sizeMenu);
    }

    private void beverageType()
    {
        bevrgeLabel = new JLabel("Select which type of beverage do you to order:");
        bevrgeLabel.setBounds(100,80,300,50);
        add(bevrgeLabel);

        btnGroup = new ButtonGroup();

        juiceBtn = new JRadioButton("Juice");
        waterBtn = new JRadioButton("Water");
        teaBtn = new JRadioButton("Tea");
        coffeeBtn = new JRadioButton("Coffee");

        juiceBtn.setBounds(100, 120, 70,20);
        waterBtn.setBounds(170, 120, 70,20);
        teaBtn.setBounds(240, 120, 70,20);
        coffeeBtn.setBounds(310, 120, 70,20);

        btnGroup.add(juiceBtn);
        btnGroup.add(waterBtn);
        btnGroup.add(teaBtn);
        btnGroup.add(coffeeBtn);

        add(juiceBtn);
        add(waterBtn);
        add(teaBtn);
        add(coffeeBtn);
    }

    private void setField()
    {
        fieldLabel = new JLabel("Type how many glasses you want to order:");
        fieldLabel.setBounds(100,160,280,30);

        field = new JTextField();
        field.setBounds(100,190,280,30);

        add(fieldLabel);
        add(field);
    }

    private void buttons()
    {
        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(110,250,100,30);

        buttonOrder = new JButton("Order");
        buttonOrder.setBounds(260,250,100,30);
        buttonOrder.setEnabled(false);

        // This is for the label when order is placed
        orderLabel = new JLabel();
        orderLabel.setBounds(110,300,300,30);

        add(orderLabel);
        add(buttonAdd);
        add(buttonOrder);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int glasses;
        String glassSize = sizeMenu.getSelectedItem().toString();
        if(e.getSource().equals(buttonAdd)) {

            if(juiceBtn.isSelected() || teaBtn.isSelected() || waterBtn.isSelected() || coffeeBtn.isSelected() &&
                    !field.getText().isEmpty()) {
                try {
                    Beverage beverage;
                    glasses = Integer.parseInt(field.getText().trim());

                    if(juiceBtn.isSelected()) {
                        beverage = new Juice(glassSize, glasses);
                    } else if(teaBtn.isSelected()) {
                        beverage = new Tea(glassSize, glasses);
                    } else if(waterBtn.isSelected()) {
                        beverage = new Water(glassSize, glasses);
                    } else {
                        beverage = new Coffee(glassSize,  glasses);
                    }

                    field.setText("");
                    orderLabel.setText(beverage.toString() + " added");
                    beveragesAll.add(beverage);
                    buttonOrder.setEnabled(true);

                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Enter an integer as amount");
                    field.setText("");
                }

            } else if(field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter how many glasses do you want");
            }
        }
        if (e.getSource() == buttonOrder) {
            String report = "";
            double pay = 0.0;

            for(int i = 0; i < beveragesAll.size(); i++) {

				Beverage bvg = beveragesAll.get(i);

                report += bvg.toString();

				double totalprice_of_bvg = bvg.getPrice();

                pay += totalprice_of_bvg;

                report = report + " - " + totalprice_of_bvg + " PKR \n";
            }
            JOptionPane.showMessageDialog(this, report);
            JOptionPane.showMessageDialog(this, "You should pay " + pay + " PKR");
            orderLabel.setText(null);
            buttonOrder.setEnabled(false);
            beveragesAll.clear();

        }
    }
}