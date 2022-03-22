package com.mango.prjmango.utilities;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Taskbar {

    /**
     * Retrieves the height of the users operating systems taskbar.
     *
     * @return an {@code int} with the taskbar height value
     */
    public static int getTaskbarHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle windowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        return screenSize.height - windowSize.height;
    }
}
