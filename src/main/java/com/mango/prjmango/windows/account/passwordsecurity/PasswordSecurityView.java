package com.mango.prjmango.windows.account.passwordsecurity;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 * The user interface design of the Password & Security page.
 */
public class PasswordSecurityView extends JPanel {

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public PasswordSecurityView() {
        createLayout();
    }

    private void createLayout() {
        GroupLayout editProfilePanelLayout = new GroupLayout(this);
        setLayout(editProfilePanelLayout);
        editProfilePanelLayout.setHorizontalGroup(
                editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 843, Short.MAX_VALUE)
        );
        editProfilePanelLayout.setVerticalGroup(
                editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 923, Short.MAX_VALUE)
        );
    }
}
