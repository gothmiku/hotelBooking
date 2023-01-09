package org.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;


public class adminPanel extends JFrame {
    public String getDataModel() {
        return dataModel;
    }
    public void setDataModel(String dataModel) {
        this.dataModel = dataModel;
    }
    private String dataModel;
    private JPanel adminmenu;
    private JTable table1;
    private JButton CustomerButton;
    private JButton HotelButton;
    private JButton OrderButton;
    private JButton RoomsButton;
    private JButton Modify;
    private JButton searchButton;
    private JTextField searchTextField;
    private JButton deleteButton;
    private JPanel panelHolder;
    private JScrollPane scrollPane;

    DefaultTableModel hotelDataModel(String query){
        Object[][] data = {};
        String[] columnNames0 = {"ID","Full-Name","Gender","Address"}; //Customers
        String[] columnNames1 = {"HotelName","RoomNumber","HotelID"}; //Hotels
        String[] columnNames2 = {"OrderID", "RoomNumber", "CustomerID","Order Date"};
        String[] columnNames3 = {"HotelID", "RoomID", "Single Bed","Double Bed"};

        DefaultTableModel customerModel = new DefaultTableModel(data,columnNames0);
        switch(query){
            case "Customer":
                customerModel.setColumnIdentifiers(columnNames0);
                break;
            case "Hotel":
                customerModel.setColumnIdentifiers(columnNames1);
                break;
            case "Orders":
                customerModel.setColumnIdentifiers(columnNames2);
                break;
            case "Rooms":
                customerModel.setColumnIdentifiers(columnNames3);
                break;
            default:
                System.out.println("put a better query name e.g Customer, Hotel...");
        }
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart", "root", "");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + query + ";");
            switch(query){
                case "Customer":
                    while (result.next()) {
                        int id = result.getInt("CustomerID");
                        String name = result.getString("FullName");
                        int gender = result.getInt("Gender");
                        String address = result.getString("Address");
                        Object[] rowData = {id,name,gender,address};
                        customerModel.addRow(rowData);
                    }
                    break;
                case "Hotel":
                    while (result.next()) {
                        String hotelname = result.getString("HotelName");
                        int roomNumber = result.getInt("RoomNumber");
                        int hotelid = result.getInt("HotelID");
                        Object[] rowData = {hotelname,roomNumber,hotelid};
                        customerModel.addRow(rowData);
                    }
                    break;
                case "Orders":
                    while (result.next()) {
                        int OrderID = result.getInt("OrderID");
                        int orderRoomNumber = result.getInt("RoomNumber");
                        int customerID = result.getInt("CustomerID");
                        String date = result.getString("OrderDate");
                        Object[] rowData = {OrderID,orderRoomNumber,customerID,date};
                        customerModel.addRow(rowData);
                    }
                    break;
                case "Rooms":
                    while (result.next()) {
                        int hotelid = result.getInt("HotelID");
                        int roomID = result.getInt("RoomID");
                        int singlebed = result.getInt("SingleBedNo");
                        int doublebed = result.getInt("DoubleBedNo");
                        Object[] rowData = {hotelid,roomID,singlebed,doublebed};
                        customerModel.addRow(rowData);
                    }
                    break;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerModel;
    }

    TableRowSorter getTableSorter(DefaultTableModel modelInput){
        TableRowSorter result = new TableRowSorter(modelInput);
        return result;
    }

    public adminPanel(String windowName) {

        TableRowSorter tableSorter1 = new TableRowSorter(table1.getModel());
        //List<HotelChart.Customer> data = new ArrayList<>();
        add(adminmenu);
        setTitle(windowName);
        Color greyColor = new Color(51,51,51);
        scrollPane.setBackground(greyColor);
        scrollPane.getViewport().setBackground(greyColor);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.repaint();


        CustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDataModel("Customer");
                table1.setModel(hotelDataModel("Customer"));
                tableSorter1.setModel(table1.getModel());
                table1.setRowSorter(tableSorter1);

            }
        });

        HotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDataModel("Hotel");
                table1.setModel(hotelDataModel("Hotel"));
                tableSorter1.setModel(table1.getModel());
                table1.setRowSorter(tableSorter1);

            }
        });
        OrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDataModel("Orders");
                table1.setModel(hotelDataModel("Orders"));
                tableSorter1.setModel(table1.getModel());
                table1.setRowSorter(tableSorter1);

            }
        });
        RoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDataModel("Rooms");
                table1.setModel(hotelDataModel("Rooms"));
                tableSorter1.setModel(table1.getModel());
                table1.setRowSorter(tableSorter1);

            }
        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row;
                String eve;
                String query="";
                switch(dataModel){
                    case "Customer":
                        row = table1.getSelectedRow();
                        eve = table1.getModel().getValueAt(row,0).toString();
                        query="DELETE FROM Customer WHERE CustomerID="+eve;
                        break;
                    case "Hotel":
                        row = table1.getSelectedRow();
                        eve = table1.getModel().getValueAt(row,2).toString();
                        query="DELETE FROM Hotel WHERE HotelID="+eve;
                        break;
                    case "Orders":
                        row = table1.getSelectedRow();
                        eve = table1.getModel().getValueAt(row,0).toString();
                        query="DELETE FROM Orders WHERE OrderID="+eve;
                        break;
                    case "Rooms":
                        row = table1.getSelectedRow();
                        eve = table1.getModel().getValueAt(row,1).toString();
                        query="DELETE FROM Rooms WHERE RoomID="+eve;
                        break;
                }
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart","root","");
                    PreparedStatement stmt = con.prepareStatement(query);
                    stmt.execute();
                    table1.setModel(hotelDataModel(dataModel));
                    tableSorter1.setModel(table1.getModel());
                    table1.setRowSorter(tableSorter1);
                    con.close();
                }catch(SQLException b){
                    b.printStackTrace();
                }


            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        String searchInput=searchTextField.getText();
                        if (searchInput.trim().length() == 0) {
                            tableSorter1.setRowFilter(null);
                        } else {
                            //tableSorter1.setRowFilter(new rowFilterClass(searchInput));
                            tableSorter1.setRowFilter(RowFilter.regexFilter("(?i)" + searchInput));
                        }
                        return false;
                    }
                });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchInput=searchTextField.getText();
                if (searchInput.trim().length() == 0) {
                    tableSorter1.setRowFilter(null);
                } else {
                    //tableSorter1.setRowFilter(new rowFilterClass(searchInput));
                    tableSorter1.setRowFilter(RowFilter.regexFilter("(?i)" + searchInput));
                }

            }
        });
        Modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyMenu modifymenu = new ModifyMenu();
                modifymenu.setVisible(true);
                modifymenu.setSize(500,400);
                modifymenu.setResizable(false);
                modifymenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }

}
