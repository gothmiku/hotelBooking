package org.app;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        LoginMenu LoginMenu = new LoginMenu("Hotel Management System");
        LoginMenu.setVisible(true);
        LoginMenu.setResizable(false);
        LoginMenu.setSize(600,250);
        LoginMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        adminPanel admin = new adminPanel("Hotel Management System");
        admin.setVisible(true);
        admin.setSize(1000,500);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}