package gui.employee;

import database.operations.EmployeeOperations;
import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import model.Employee;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.lang.String;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class EmployeeMain implements ActionListener, MouseListener {

    private JPanel empMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewSalesButton, backButton;
    private JTextField searchField;
    private JComboBox empTypes;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable tblEmployee;
    private JScrollPane tblScroll;

    private String textFieldTip = "type your search query...";

    private AdminMain am;  // declare for usage with JDialogs as parent
    private EmployeeOperations eo;
    private Employee e;

    String[] eempTypes = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB

    public JPanel getEmployeeMain(){

    // setup the frame

        empMain = new JPanel(new BorderLayout());
        //empMain.getContentPane().setBackground(new Color(98, 169, 221));

// NORTH PANEL

        northPanel = new JPanel(new GridBagLayout());
        //northPanel.setBackground(new Color(98, 169, 100));

    // manage employees panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Employees")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 28));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 28));
        editButton.setIcon(new ImageIcon(UIElements.edit16));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 28));
        deleteButton.setIcon(new ImageIcon(UIElements.delete16));
        managePanel.add(deleteButton);

        northPanel.add(managePanel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

    // search employees panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Employees")); // set anonymous titled, etched border

        searchField = new JTextField(19);
        searchField.setText(textFieldTip); // set initial text field search
        searchField.setForeground(Color.GRAY); // set initial colour to gray
        searchField.addMouseListener(this);
        searchPanel.add(searchField);

        empTypes = new JComboBox(new DefaultComboBoxModel<String>(eempTypes));
        empTypes.setPreferredSize(new Dimension(105,26)); // combo box resized to make all the components fit just perfectly!

        searchPanel.add(empTypes);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 28));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

        // add northPanel to main
        empMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - table panel

        centerPanel = new JPanel(new FlowLayout());

        tblEmployee = new JTable();
       // DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}});
     //   String titles[] = {"Title 1", "Title 2", "Title 3", "Title 4"};
     //   tblEmployee.setModel(tblModel,titles[]);
//        tblScroll.setViewportView(tblEmployee);
                centerPanel.add(tblEmployee);

        empMain.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(UIElements.getColour());

    // bottom buttons

        viewSalesButton = new JButton("View Sales History");
        viewSalesButton.setPreferredSize(new Dimension(200, 28));
        viewSalesButton.setIcon(new ImageIcon(UIElements.open16));
        viewSalesButton.addActionListener(this);
        southPanel.add(viewSalesButton);

        empMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return empMain;
    }

// BUTTON ACTIONS

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(searchField)){
            if (searchField.getText().equals(textFieldTip)) {
                searchField.setText("");
                searchField.setForeground(null); // reset colour to black
            }
            searchField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {}
                @Override
                public void focusLost(FocusEvent e) { // set the textFieldTip to be visible in text field on focus loss
                    if (searchField.getText().equals("")){
                        searchField.setText(textFieldTip);
                        searchField.setForeground(Color.GRAY);
                    }
                }
            });
        }
    }

    public void actionPerformed(ActionEvent e) {
        // add button
        if (e.getSource().equals(addButton)) {
            EmployeeAddEdit eae = new EmployeeAddEdit(am,0);
        } // edit button
        else if (e.getSource().equals(editButton)){
            EmployeeAddEdit eae = new EmployeeAddEdit(am,1);
        }
        else if (e.getSource().equals(viewSalesButton)){
            SalesHistory sv = new SalesHistory();
        }
    }
}