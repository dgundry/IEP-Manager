package com.mango.prjmango.ui;

import com.mango.prjmango.ui.common.BackgroundPanel;
import com.mango.prjmango.ui.common.Images;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

/**
 * Creates the layout of the initial load of the application.
 */
public class LoginViewLayout extends BackgroundPanel {

    private final int taskbarHeight = getTaskbarHeight();

    /**
     * Constructor. Sets the background image to the {@link BackgroundPanel}.
     */
    public LoginViewLayout() {
        setBackground(Images.CLASSROOM_BACKGROUND.getBufferedImage());
    }

    /**
     * Switches the active {@link JLabel} that acts as a container.
     *
     * @param label the {@link JLabel} that acts as a container
     */
    public void setLayout(JLabel label) {
        removeAll();

        GroupLayout loginBackgroundPanelLayout = new GroupLayout(this);
        setLayout(loginBackgroundPanelLayout);
        loginBackgroundPanelLayout.setHorizontalGroup(
                loginBackgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(479, Short.MAX_VALUE)
                                .addComponent(
                                        label,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(479, Short.MAX_VALUE))
        );
        loginBackgroundPanelLayout.setVerticalGroup(
                loginBackgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(177, Short.MAX_VALUE)
                                .addComponent(
                                        label,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE))
        );

        updateUI();
    }

    private int getTaskbarHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle windowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        return screenSize.height - windowSize.height;
    }
}
