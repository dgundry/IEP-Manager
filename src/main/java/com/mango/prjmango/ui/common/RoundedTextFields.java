package com.mango.prjmango.ui.common;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextFields extends JTextField {

    //this doesn't work - emily
    public static class RoundedJTextField extends JTextField {
        private Shape shape;
        public RoundedJTextField(int size) {
            super(size);
            setOpaque(false);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }

        public void paintComponent(Graphics g) {
            g.setColor(Colors.DARK_GREY);
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            super.paintComponent(g);
        }
    }
    //this does work, currently what is implemented on all of the textareas/fields
    //needs the textarea/field to also be rounded though
    static class RoundBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
            Color oldColor = g.getColor();
            g.setColor(Color.LIGHT_GRAY);
            g.drawRoundRect(x, y, width-1, height-1, 20, 20);
            g.setColor(oldColor);
        }
        public Insets getBorderInsets(Component c, Insets insets){
            insets.left = insets.top = insets.right = insets.bottom = 4;
            return insets;
        }
    }
}
