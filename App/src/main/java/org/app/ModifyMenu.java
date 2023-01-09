package org.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ModifyMenu extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JButton addButton;
    private JButton deleteButton;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton addButton1;
    private JButton button4;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JButton button5;
    private JButton button6;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JButton button7;
    private JButton button8;


    class ComboItem
    {
        private String key;
        private String number;

        public ComboItem(String key, String number)
        {
            this.key = key;
            this.number = number;
        }

        @Override
        public String toString()
        {
            return key;
        }

        public String getKey()
        {
            return key;
        }

        public String getValue()
        {
            return number;
        }
    }
    private JComboBox comboBox1;

    ModifyMenu(){
        textField1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        comboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField8.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField9.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField10.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField11.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField12.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField13.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField14.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField15.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        addButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        comboBox1.addItem(new ComboItem("Male","0"));
        comboBox1.addItem(new ComboItem("Female","1"));
        comboBox1.addItem(new ComboItem("Other","2"));
        //Object item = comboBox.getSelectedItem();
        //String value = ((ComboItem)item).getValue();
        add(panel1);
        setTitle("Modify table");
        addButton.addActionListener(new ActionListener() {
            //Customer add
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().isEmpty()){
                    String id = textField1.getText();
                    String name= textField2.getText();
                    ComboItem item = (ComboItem) comboBox1.getSelectedItem();
                    String gender = item.getValue();
                    String address = textField4.getText();
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart", "root", "");
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO Customer VALUES (" + id + ",'" + name + "'," + gender + ",'" + address + "')");
                        textField1.setText("");
                        textField2.setText("");
                        textField4.setText("");
                        con.close();
                        //ResultSet result = statement.executeQuery("INSERT INTO Customer VALUES (" + id + ",'" + name + "'," + gender + ",'" + address + "')");
                    }catch(SQLException b){
                        b.printStackTrace();
                    }
                }
                else{
                    String message = "Customer ID can't be empty.";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField7.getText().isEmpty()){
                    String hotelName = textField5.getText();
                    String roomNumber = textField6.getText();
                    String hotelID = textField7.getText();
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart", "root", "");
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO Hotel VALUES ('" + hotelName + "'," + roomNumber + "," + hotelID + ")");
                        textField5.setText("");
                        textField6.setText("");
                        textField7.setText("");
                        con.close();
                        //ResultSet result = statement.executeQuery("INSERT INTO Customer VALUES (" + id + ",'" + name + "'," + gender + ",'" + address + "')");
                    }catch(SQLException b){
                        b.printStackTrace();
                    }
                }
                else{
                    String message2 = "Hotel ID number can't be empty";
                    JOptionPane.showMessageDialog(new JFrame(), message2, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField8.getText().isEmpty()&&!textField9.getText().isEmpty()&&!textField10.getText().isEmpty()&&!textField11.getText().isEmpty()){
                    String orderID = textField8.getText();
                    String roomNumber2 = textField9.getText();
                    String customerID2 = textField10.getText();
                    String orderDate = textField11.getText();
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart", "root", "");
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO Orders VALUES (" + orderID + "," + roomNumber2 + "," + customerID2 + ",'" + orderDate + "')");
                        textField8.setText("");
                        textField9.setText("");
                        textField10.setText("");
                        textField11.setText("");
                        con.close();
                        //ResultSet result = statement.executeQuery("INSERT INTO Customer VALUES (" + id + ",'" + name + "'," + gender + ",'" + address + "')");
                    }catch(SQLException b){
                        b.printStackTrace();
                    }
                }
                else{
                    String message2 = "None of the text boxes can be empty";
                    JOptionPane.showMessageDialog(new JFrame(), message2, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField12.getText().isEmpty()&&!textField13.getText().isEmpty()&&!textField14.getText().isEmpty()&&!textField15.getText().isEmpty()){
                    String hotelID2 = textField12.getText();
                    String roomID2 = textField13.getText();
                    String singleBed = textField15.getText();
                    String doubleBed = textField14.getText();
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelChart", "root", "");
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO Rooms VALUES (" + hotelID2 + "," + roomID2 + "," + singleBed + "," + doubleBed + ")");
                        textField12.setText("");
                        textField13.setText("");
                        textField14.setText("");
                        textField15.setText("");
                        con.close();
                        //ResultSet result = statement.executeQuery("INSERT INTO Customer VALUES (" + id + ",'" + name + "'," + gender + ",'" + address + "')");
                    }catch(SQLException b){
                        b.printStackTrace();
                    }
                }
                else{
                    String message2 = "None of the text boxes can be empty";
                    JOptionPane.showMessageDialog(new JFrame(), message2, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
