package org.app;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class LoginMenu extends JFrame {
    private JTextArea Title;

    private JPasswordField passwordPasswordField;
    private JTextField usernameTextField;
    private JButton logInButton;
    private JPanel Panel1;

    public LoginMenu(String name){
        add(Panel1);
        setSize(600,250);
        setTitle(name);
        //setBackground(Color.getColor("51,51,51"));
    }

}
