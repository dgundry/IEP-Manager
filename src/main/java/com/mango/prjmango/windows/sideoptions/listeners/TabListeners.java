package com.mango.prjmango.windows.sideoptions.listeners;

import com.mango.prjmango.utilities.Tab;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TabListeners implements MouseListener {

    private final JLabel label;

    private final ImageIcon hoveredImage;
    private final ImageIcon noHoveredImage;

    private final boolean changeCursor;

    private Tab tab = null;

    public TabListeners(JLabel label, ImageIcon noHoveredImage, ImageIcon hoveredImage, boolean changeCursor, Tab tab) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.changeCursor = changeCursor;
        this.tab = tab;
    }

    public TabListeners(JLabel label, ImageIcon noHoveredImage, ImageIcon hoveredImage, boolean changeCursor) {
        this.label = label;
        this.noHoveredImage = noHoveredImage;
        this.hoveredImage = hoveredImage;
        this.changeCursor = changeCursor;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (tab != null) {
            tab.setActiveStatus(true);
            Tab.configureActiveTab(tab);
            label.setIcon(Tab.getCorrespondingImageIcon(tab));
        }
        //switch tabs
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (changeCursor) {
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        label.setIcon(hoveredImage);
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseExited(MouseEvent e) {
        if (changeCursor) {
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        label.setIcon(noHoveredImage);
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mousePressed(MouseEvent e) { /* Not needed */ }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the {@link MouseEvent}
     */
    @Override
    public void mouseReleased(MouseEvent e) { /* Not needed */ }
}
