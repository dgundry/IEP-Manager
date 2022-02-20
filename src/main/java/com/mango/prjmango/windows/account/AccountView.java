package com.mango.prjmango.windows.account;

import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class AccountView extends JPanel {

    @Getter private JLabel editProfileLabel;
    @Getter private JLabel passwordSecurityLabel;
    @Getter private JLabel accountHeaderLabel;

    private JSeparator horizSeparator;
    private JSeparator vertSeparator;

    private final Color LIGHT_GREY = new Color(216, 216, 216);

    public AccountView() {
        setBackground(new Color(19, 18, 18));

        createComponents();
        createLayout();
    }

    private void createComponents() {
        editProfileLabel      = new JLabel(Images.EDIT_PROFILE_NO_HOVER.getImageIcon());
        passwordSecurityLabel = new JLabel(Images.PASSWORD_SECURITY_NO_HOVER.getImageIcon());

        accountHeaderLabel    = createLabel("Account", 24);

        horizSeparator = new JSeparator();
        horizSeparator.setForeground(LIGHT_GREY);

        vertSeparator = new JSeparator();
        vertSeparator.setForeground(LIGHT_GREY);
        vertSeparator.setOrientation(SwingConstants.VERTICAL);
    }

    private void createLayout() {
        GroupLayout accountPanelLayout = new GroupLayout(this);
        setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
                accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(horizSeparator)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(passwordSecurityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(editProfileLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vertSeparator, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(accountHeaderLabel))
                                .addContainerGap(849, Short.MAX_VALUE))
        );
        accountPanelLayout.setVerticalGroup(
                accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addComponent(accountHeaderLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(horizSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(vertSeparator)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editProfileLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(passwordSecurityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", 0, fontSize));
        label.setForeground(LIGHT_GREY);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
}
