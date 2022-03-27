package com.mango.prjmango.ui.common.roundedcomponents;

import com.mango.prjmango.ui.common.Colors;
import javax.swing.JComboBox;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.Vector;

/**
 * Creates a rounded {@link JComboBox}.
 *
 * @param <T> the type the {@link JComboBox} will hold
 */
public class RoundedComboBox<T> extends JComboBox<T> {

    private transient Shape shape;

    /**
     * Constructor. Calls the {@link JComboBox#JComboBox(Vector)} and sets {@link JComboBox#setOpaque(boolean)}
     * to {@code false}.
     *
     * @param list the {@link List} to populate the {@link JComboBox} with
     */
    public RoundedComboBox(List<T> list) {
        super(new Vector<>(list));
        setOpaque(false);
    }

    /**
     * Constructor. Calls the {@link JComboBox#JComboBox} and sets {@link JComboBox#setOpaque(boolean)}
     * to {@code false}.
     */
    public RoundedComboBox() {
        super();
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
