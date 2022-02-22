package com.mango.prjmango.windows;

import com.mango.prjmango.components.BackgroundPanel;
import com.mango.prjmango.utilities.Images;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class LoginViewLayout extends BackgroundPanel {

    public LoginViewLayout() {
        setBackground(Images.CITY_OF_LAWRENCEBURG.getBufferedImage());
    }

    public void setLayout(JLabel label) {
        removeAll();

        GroupLayout loginBackgroundPanelLayout = new GroupLayout(this);
        setLayout(loginBackgroundPanelLayout);
        loginBackgroundPanelLayout.setHorizontalGroup(
                loginBackgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(479, Short.MAX_VALUE)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(479, Short.MAX_VALUE))
        );
        loginBackgroundPanelLayout.setVerticalGroup(
                loginBackgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBackgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(189, Short.MAX_VALUE)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(189, Short.MAX_VALUE))
        );

        updateUI();
    }
}
