package org.app;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //LoginMenu LoginScreen = new LoginMenu("Hotel Management System");
        //LoginScreen.setVisible(true);
        //LoginScreen.setResizable(false);
        //LoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminPanel admin = new adminPanel("Hotel Management System");
        admin.setVisible(true);
        admin.setSize(1000,500);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}