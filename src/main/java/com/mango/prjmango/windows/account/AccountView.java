package com.mango.prjmango.windows.account;

import com.mango.prjmango.utilities.Fonts;
import com.mango.prjmango.utilities.ImageIcons;
import com.mango.prjmango.utilities.Images;
import com.mango.prjmango.windows.account.editprofile.EditProfileController;
import com.mango.prjmango.windows.account.editprofile.EditProfileView;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class AccountView extends JLabel {

    @Getter private JLabel editProfileLabel;
    @Getter private JLabel passwordSecurityLabel;
    @Getter private JLabel accountHeaderLabel;

    private JSeparator horizSeparator;
    private JSeparator vertSeparator;

    private final Color LIGHT_GREY = new Color(216, 216, 216);

    /**
     * Constructor. Calls methods to create the {@link JPanel} for the Account tab.
     * On the initial load, the {@link EditProfileView} will be visible.
     */
    public AccountView() {
        setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        createComponents();

        EditProfileView editProfileView = new EditProfileView(); //Home page instead?
        new EditProfileController(editProfileView);

        setMainPageLayout(editProfileView);
    }

    private void createComponents() {
        editProfileLabel      = new JLabel(Images.EDIT_PROFILE_SELECTED.getImageIcon());
        passwordSecurityLabel = new JLabel(Images.PASSWORD_SECURITY_NO_HOVER.getImageIcon());

        accountHeaderLabel = new JLabel("Account");
        accountHeaderLabel.setFont(Fonts.SEGOE_UI_24.getFont());
        accountHeaderLabel.setForeground(LIGHT_GREY);
        accountHeaderLabel.setHorizontalAlignment(SwingConstants.LEFT);

        horizSeparator = new JSeparator();
        horizSeparator.setForeground(LIGHT_GREY);

        vertSeparator = new JSeparator();
        vertSeparator.setForeground(LIGHT_GREY);
        vertSeparator.setOrientation(SwingConstants.VERTICAL);
    }

    public void setMainPageLayout(JPanel displayPanel) {
        removeAll();

        GroupLayout accountPanelLayout = new GroupLayout(this);
        setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
                accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(horizSeparator)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addComponent(accountHeaderLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordSecurityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editProfileLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vertSeparator, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
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
                                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addComponent(editProfileLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(passwordSecurityLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                        .addGroup(GroupLayout.Alignment.TRAILING, accountPanelLayout.createSequentialGroup()
                                                                .addGap(0, 1, Short.MAX_VALUE)
                                                                .addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
        );

        updateUI();
    }
}
