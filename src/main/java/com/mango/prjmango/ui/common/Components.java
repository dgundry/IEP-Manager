package com.mango.prjmango.ui.common;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Components {

    public static JLabel JLabel(String text, Font font, Color foregroundColor, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        label.setHorizontalAlignment(alignment);
        return label;
    }

    public static JTextField JTextField(String text, Font font, Color foregroundColor) {
        JTextField textField = new JTextField();
        textField.setOpaque(false);
        textField.setFont(font);
        textField.setForeground(foregroundColor);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBorder(BorderFactory.createTitledBorder(
                null,
                text,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        textField.setCaretColor(Colors.LIGHT_GREY);
        return textField;
    }

    public static JPasswordField JPasswordField(String headerText) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setForeground(Colors.LIGHT_GREY);
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        passwordField.setBorder(BorderFactory.createTitledBorder(
                null,
                headerText,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        passwordField.setCaretColor(Colors.LIGHT_GREY);
        return passwordField;
    }

    public static JPasswordField JPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Colors.DARK_GREY);
        passwordField.setForeground(Colors.LIGHT_GREY);
        passwordField.setCaretColor(Colors.LIGHT_GREY);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        return passwordField;
    }

    public static JSeparator JSeparator(int orientation) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(orientation);
        separator.setForeground(Colors.LIGHT_GREY);
        return separator;
    }

    public static JComboBox<String> JComboBox(String headerText, List<String> list) {
        JComboBox<String> comboBox = new JComboBox<>(new Vector<>(list));
        comboBox.setOpaque(false);
        comboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        comboBox.setBackground(Colors.DARK_GREY);
        comboBox.setForeground(Colors.LIGHT_GREY);
        comboBox.setBorder(BorderFactory.createTitledBorder(
                null,
                headerText,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        comboBox.setPreferredSize(new Dimension(56, 20));
        return comboBox;
    }
}
