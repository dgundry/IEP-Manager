package com.mango.prjmango.components;

import javax.swing.*;
import java.awt.*;

public class Components {

    private final static Insets MARGIN = new Insets(0, 5, 0, 5);

    public static JLabel JLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    public static JTextField JTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setBackground(Color.WHITE);
        textField.setMargin(MARGIN);
        return textField;
    }

    public static JPasswordField JPasswordField(String text) {
        JPasswordField passwordField = new JPasswordField(text);
        passwordField.setBackground(Color.WHITE);
        passwordField.setEchoChar((char) 0);
        passwordField.setMargin(MARGIN);
        return passwordField;
    }

    public static JButton JButton(String text, Color fontColor) {
        JButton button = new JButton(text);
        button.setForeground(fontColor);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    public static JButton JButton(String text, Color fontColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setForeground(fontColor);
        button.setBackground(backgroundColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }
}
