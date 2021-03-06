package gui.terminal;

import gui.UIElements;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

public class ProductResults extends JPanel {

    private JPanel productResultsPanel;
    private JTable productTable;
    private ProductTableModel tableModel;
    protected static final int tableHeight = 200;

    public JPanel getResults(String category, String keyword) throws SQLException{
        productResultsPanel = new JPanel();
        tableModel = new ProductTableModel();

        productTable = new JTable(tableModel);
        productTable.setRowHeight(30);


        // Set the table width, depending upon the width of
        // the columns
        int tableWidth = 0;
        int columnCount = tableModel.columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++)
            tableWidth += tableModel.columnModel.getColumn(i).getWidth();

        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setPreferredSize(new Dimension(tableWidth, tableHeight));
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Get the data!
        if (keyword.equals(""))
            tableModel.queryTableData(category);
        else
            tableModel.queryTableData(category, keyword);

        productResultsPanel.setLayout(new BorderLayout());
        productResultsPanel.add(scrollPane, BorderLayout.CENTER);
        productResultsPanel.setBackground(UIElements.getColour());


        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTable row = (JTable)e.getSource();
                int i = row.getSelectedRow();
                int productId = (Integer)productTable.getValueAt(i, 0);
                TerminalMode.mf.setToProductView(productId);
            }
        });

        return productResultsPanel;
    }
}
