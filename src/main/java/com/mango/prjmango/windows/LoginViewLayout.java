package com.mango.prjmango.windows;

import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.common.Images;
import com.mango.prjmango.utilities.Taskbar;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

/**
 * Creates the layout of the initial load of the application.
 */
public class LoginViewLayout extends BackgroundPanel {

    private JLabel mangoLogoLabel;

    private final int taskbarHeight = Taskbar.getTaskbarHeight();

    /**
     * Constructor. Sets the background image to the {@link BackgroundPanel}.
     */
    public LoginViewLayout() {
        setBackground(Images.CLASSROOM_BACKGROUND.getBufferedImage());
        mangoLogoLabel = new JLabel(ImageIcons.MANGO_LOGO.getImageIcon());
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
                        .addGroup(GroupLayout.Alignment.TRAILING, loginBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mangoLogoLabel)
                                .addGap(1, 1, 1))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(mangoLogoLabel)
                                .addGap(taskbarHeight - 10, taskbarHeight - 10, taskbarHeight - 10))
        );

        updateUI();
    }
}
