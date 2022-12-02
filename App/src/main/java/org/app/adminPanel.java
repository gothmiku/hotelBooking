package org.app;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.*;


public class adminPanel<HotelChart> extends JFrame {
    private JPanel adminmenu;
    private JTable table1;
    private JButton CustomerButton;
    private JButton HotelButton;
    private JButton OrderButton;
    private JButton RoomsButton;
    private JButton Modify;
    private JButton Search;
    private JTextField usernameTextField;
    static String query1 = "SELECT * FROM customer;";
    public static int initRowCount() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HotelChart", "root", "152503xy");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query1);
            while (result.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    TableModel customer = new AbstractTableModel() {



        @Override
        public int getRowCount() {
            try {
                return initRowCount();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    };

    public adminPanel(String name) {
        HotelChart.Customer customerData = new HotelChart.Customer();
        ArrayList list = customerData.getList();
        //List<HotelChart.Customer> data = new ArrayList<>();
        add(adminmenu);
        setTitle(name);
        table1.setModel(customer);
    }

}
