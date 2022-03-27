package com.mango.prjmango.ui.common.roundedcomponents;

import com.mango.prjmango.ui.common.Colors;
import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * Creates a rounded {@link JTextArea}
 */
public class RoundedTextArea extends JTextArea {

    private transient Shape shape;

    /**
     * Constructor. Calls the {@link JTextArea#JTextArea(String)} and sets {@link JTextArea#setOpaque(boolean)}
     * to {@code false}
     *
     * @param text the displayed text inside the {@link JTextArea}
     */
    public RoundedTextArea(String text) {
        super(text);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.DARK_GREY);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Colors.LIGHT_GREY);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(
                    0,
                    0,
                    (float) getWidth() - 1,
                    (float) getHeight() - 1,
                    10,
                    10);
        }
        return shape.contains(x, y);
    }
}
