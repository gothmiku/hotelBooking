package org.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginMenu extends JFrame {
    private JTextArea Title;

    private JPasswordField passwordPasswordField;
    private JTextField usernameTextField;
    private JButton logInButton;
    private JPanel Panel1;

    boolean checkDataStatus(String usernameInput,String passwordInput){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/HotelChart","root","152503xy");
            String sql = "SELECT * FROM accountinfo WHERE email = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usernameInput);
            stmt.setString(2, passwordInput);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                if(result.getBoolean("isAdmin")){
                    return true;
                }
                else{
                    String message = "User is not admin.";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            else{
                String message = "Username or password is incorrect.";
                JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public LoginMenu(String name){
        passwordPasswordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        usernameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        logInButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        add(Panel1);
        //setSize(600,250);
        setTitle(name);
        //setBackground(Color.getColor("51,51,51"));
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkDataStatus(usernameTextField.getText(),passwordPasswordField.getText())==true){
                    adminPanel admin = new adminPanel("Hotel Management System");
                    admin.setVisible(true);
                    admin.setSize(1000,500);
                    admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        });
    }

}
