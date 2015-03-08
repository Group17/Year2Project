package gui;/*2ndYearProject
  gui
  Created by David
  14:56   06/03/2015
  Software Development 3
*/

import database.operations.ProductOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;


public class MainFrame extends JFrame implements ActionListener {

  private Connection conn;
  private ProductOperations po;

  private MainFrame mf;

  private JLabel logoLabel;
  private JPanel northPanel, centerPanel, southPanel, main;
  private JButton browse, search, help, home, back;
  private GridBagLayout bl;
  private boolean displayArea = false;


  public void setMf(MainFrame mf){
    this.mf = mf;
  }


  public MainFrame(Connection conn){
    this.conn = conn;
    po = new ProductOperations(conn);

    this.setTitle("DGA Computers");
    //this.setLayout();
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(98, 169, 221));


    help = new JButton("HELP", new ImageIcon("src/res/images/UI Elements/help64.png"));
    help.addActionListener(this);

    home = new JButton("HOME", new ImageIcon("src/res/images/UI Elements/home64.png"));
    home.addActionListener(this);

    back = new JButton("BACK", new ImageIcon("src/res/images/UI Elements/backarrow64.png"));
    help.addActionListener(this);

    bl = new GridBagLayout();

    main = new JPanel(new BorderLayout());
    main.setMaximumSize(new Dimension(800,600));

    logoLabel = new JLabel(new ImageIcon("src/res/images/UI Elements/banner.png"));

    northPanel = new JPanel(new GridLayout(1,1));
    northPanel.setBackground(new Color(98, 169, 221));
    northPanel.add(logoLabel);

    main.add(northPanel, BorderLayout.NORTH);
    main.add(getCenterPanel(), BorderLayout.CENTER);
    main.add(getMinSouthPanel(), BorderLayout.SOUTH);

    this.add(main);
    this.setVisible(true);
  }



  public JPanel getCenterPanel(){
    centerPanel = new JPanel(bl);

    browse = new JButton(new ImageIcon("src/res/images/UI Elements/product150.png"));
    browse.addActionListener(this);

    search = new JButton(new ImageIcon("src/res/images/UI Elements/search150.png"));
    search.addActionListener(this);

    centerPanel.setBackground(new Color(98, 169, 221));
    centerPanel.add(browse, getConstraints(0,0,1,1, GridBagConstraints.WEST, 0,75,0,75));
    centerPanel.add(search, getConstraints(1,0,1,1, GridBagConstraints.EAST, 0,75,0,75));

    displayArea = true;

    return centerPanel;
  }


  // South Panel with help button
  public JPanel getMinSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(help, getConstraints(0,0,1,1,GridBagConstraints.CENTER, 0,0,20,0));

    return southPanel;
  }


  //South Panel With back, home and help buttons
  public JPanel getFullSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(back, getConstraints(0,0,1,1,GridBagConstraints.WEST, 0,0,20,0));
    southPanel.add(home, getConstraints(1,0,1,1,GridBagConstraints.WEST, 0,150,20,150));
    southPanel.add(help, getConstraints(2,0,1,1,GridBagConstraints.EAST, 0,0,20,0));

    return southPanel;
  }

  //For setting the gridbagLayout constraints
  private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                            int nIns, int wIns, int sIns, int eIns)
  {
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(nIns, wIns, sIns, eIns);
    c.ipadx = 10;
    c.ipady = 10;
    c.gridx = gridx;
    c.gridy = gridy;
    c.gridwidth = gridwidth;
    c.gridheight = gridheight;
    c.anchor = anchor;
    return c;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(search)){
      setCenterToSearch();
    }
    else if(e.getSource().equals(browse)){
      setCenterToBrowse();
    }
    else if(e.getSource().equals(home)){
      setCenterTOMain();
    }
    else if(e.getSource().equals(help)){
    }
    else if(e.getSource().equals(back)){

    }
    displayArea = true;
    this.setVisible(true);
  }

  //To change the center pane to the search
  public void setCenterToSearch(){
    System.out.println("search");
    ProductSearch c = new ProductSearch(mf, conn, po);
    if(displayArea){
      main.remove(centerPanel);
      main.remove(southPanel);
    }
    centerPanel = c.getSearch();
    southPanel = getFullSouthPanel();
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);
  }


  //To change the center pane to the browse
  public void setCenterToBrowse(){
    System.out.println("Browse");
    ProductCategories c = new ProductCategories();
    if(displayArea){
      main.remove(centerPanel);
      main.remove(southPanel);
    }
    centerPanel = c.getCategories();
    southPanel = getFullSouthPanel();
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);
  }


  //To change the center pane to the home
  public void setCenterTOMain(){
    if(displayArea){
      main.remove(centerPanel);
      main.remove(southPanel);
    }
    centerPanel = getCenterPanel();
    southPanel = getMinSouthPanel();
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);
  }

  //To change the center pane to the results of a search or the product category picked
  public void setCenterToProductResults(String category, ResultSet rset){
    ProductResults pr = new ProductResults(po);
    if(displayArea){
      main.remove(centerPanel);
      main.remove(southPanel);
    }
    centerPanel = pr.getResults(category, rset);
    southPanel = getFullSouthPanel();
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);
    displayArea = true;
    this.setVisible(true);
  }


}