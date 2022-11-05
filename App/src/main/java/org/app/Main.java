package org.app;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        LoginMenu LoginScreen = new LoginMenu("Hotel Management System");
        LoginScreen.setVisible(true);
        LoginScreen.setResizable(false);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        //LoginScreen.setLocation(size.width,size.height);
        LoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}