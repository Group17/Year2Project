package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.operations.ProductOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ProductCategories implements ActionListener {
    private MainFrame mf;

    ResultSet rset;
    ProductOperations po;

    JPanel categoriesPanel;
    JButton desktops, laptops, apple, allInOne;

    public ProductCategories(ProductOperations po, MainFrame mf){
        this.po = po;
        this.mf = mf;
    }

    public JPanel getCategories(){
        categoriesPanel = new JPanel(new GridBagLayout());
        categoriesPanel.setBackground(new Color(98, 169, 221));

        desktops = new JButton("Desktops", new ImageIcon("src/res/images/Product Categories/desktop100.png"));
        desktops.setVerticalTextPosition(SwingConstants.BOTTOM);
        desktops.setHorizontalTextPosition(SwingConstants.CENTER);
        desktops.addActionListener(this);

        laptops = new JButton("Laptops", new ImageIcon("src/res/images/Product Categories/Laptop100.png"));
        laptops.setVerticalTextPosition(SwingConstants.BOTTOM);
        laptops.setHorizontalTextPosition(SwingConstants.CENTER);
        laptops.addActionListener(this);

        apple = new JButton("Apple", new ImageIcon("src/res/images/Product Categories/iMac100.png"));
        apple.setVerticalTextPosition(SwingConstants.BOTTOM);
        apple.setHorizontalTextPosition(SwingConstants.CENTER);
        apple.addActionListener(this);

        allInOne = new JButton("All-In-One", new ImageIcon("src/res/images/Product Categories/AIOComputer100.png"));
        allInOne.setVerticalTextPosition(SwingConstants.BOTTOM);
        allInOne.setHorizontalTextPosition(SwingConstants.CENTER);
        allInOne.addActionListener(this);

        categoriesPanel.add(desktops, MainFrame.getConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(laptops, MainFrame.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(apple, MainFrame.getConstraints(2, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(allInOne, MainFrame.getConstraints(3, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));

        return categoriesPanel;


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String category = "";
        if(e.getSource().equals(desktops)){
            category = desktops.getText();
        }
        else if(e.getSource().equals(laptops)){
            category = laptops.getText();
        }
        else if(e.getSource().equals(apple)){
            category = apple.getText();
        }
        else if(e.getSource().equals(allInOne)){
            category = allInOne.getText();
        }
        rset = po.productCategory(category);
        mf.setToProductResults(category, rset);

    }
}
