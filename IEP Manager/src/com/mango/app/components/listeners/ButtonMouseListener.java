package com.mango.app.components.listeners;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

public class ButtonMouseListener implements MouseListener {

    private final JButton button;

    public ButtonMouseListener(JButton button) {
        this.button = button;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) { /* Not needed */ }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mousePressed(MouseEvent e) { /* Not needed */ }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e) { /* Not needed */ }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(button.getFont().deriveFont(Font.BOLD));

        Font font = button.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, 0);
        button.setFont(font.deriveFont(attributes));
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        button.setFont(button.getFont().deriveFont(Font.PLAIN));

        Font font = button.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, -1);
        button.setFont(font.deriveFont(attributes));
    }
}
