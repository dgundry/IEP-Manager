package com.mango.prjmango.windows.common;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Components {

    public static JLabel JLabel(String text, Font font, Color foregroundColor, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        label.setHorizontalAlignment(alignment);
        return label;
    }

    public static JSeparator JSeparator(int orientation) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(orientation);
        separator.setForeground(Colors.LIGHT_GREY);
        return separator;
    }
}
