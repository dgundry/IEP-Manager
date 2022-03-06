package com.mango.prjmango.windows.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

public class Components {

    public static JLabel JLabel(String text, Font font, Color foregroundColor, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        label.setHorizontalAlignment(alignment);
        return label;
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

    public static JSeparator JSeparator(int orientation) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(orientation);
        separator.setForeground(Colors.LIGHT_GREY);
        return separator;
    }
}
