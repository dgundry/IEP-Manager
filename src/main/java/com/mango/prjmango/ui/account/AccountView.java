package com.mango.prjmango.ui.account;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.ui.account.password.PasswordController;
import com.mango.prjmango.ui.account.password.PasswordView;
import com.mango.prjmango.utilities.subtabs.AccountSubTabs;
import com.mango.prjmango.ui.account.editprofile.EditProfileController;
import com.mango.prjmango.ui.account.editprofile.EditProfileView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
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

    private JLabel accountHeaderLabel;

    private JSeparator horizSeparator;
    private JSeparator vertSeparator;

    public static AccountSubTabs currentlyActiveTab = AccountSubTabs.EDIT_PROFILE;
    public static AccountSubTabs previouslyActiveTab = null;

    /**
     * Constructor. Calls methods to create the {@link JLabel} for the Account tab.
     * On the initial load, the {@link EditProfileView} will be visible.
     */
    public AccountView() {
        setIcon(ImageIcons.ACTIVE_TAB_BACKGROUND.getImageIcon());

        createComponents();

        if (LoggedInUser.getAccountSubTabIndex() == 0) {
            EditProfileView editProfileView = new EditProfileView();
            new EditProfileController(editProfileView);
            setActiveDisplay(editProfileView);
        } else {
            PasswordView passwordView = new PasswordView();
            new PasswordController(passwordView);
            setActiveDisplay(passwordView);
        }
    }

    private void createComponents() {
        if (LoggedInUser.getAccountSubTabIndex() == 0) {
            editProfileLabel      = new JLabel(ImageIcons.EDIT_PROFILE_SELECTED.getImageIcon());
            passwordSecurityLabel = new JLabel(ImageIcons.PASSWORD_SECURITY_NO_HOVER.getImageIcon());
        } else {
            editProfileLabel      = new JLabel(ImageIcons.EDIT_PROFILE_NO_HOVER.getImageIcon());
            passwordSecurityLabel = new JLabel(ImageIcons.PASSWORD_SECURITY_SELECTED.getImageIcon());
        }

        accountHeaderLabel = Components.JLabel(
                "Account",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);

        horizSeparator = Components.JSeparator(SwingConstants.HORIZONTAL);
        vertSeparator  = Components.JSeparator(SwingConstants.VERTICAL);
    }

    /**
     * Removes the currently displayed {@link JPanel} and displays the new one.
     *
     * @param displayPanel the {@link JPanel} within the {@code account} package to display
     */
    public void setActiveDisplay(JPanel displayPanel) {
        removeAll();

        GroupLayout accountPanelLayout = new GroupLayout(this);
        setLayout(accountPanelLayout);
        accountPanelLayout.setHorizontalGroup(
                accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(horizSeparator)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(accountHeaderLabel)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(
                                                                passwordSecurityLabel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                editProfileLabel,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        vertSeparator,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        18,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(
                                                        displayPanel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accountPanelLayout.setVerticalGroup(
                accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(accountPanelLayout.createSequentialGroup()
                                .addComponent(
                                        accountHeaderLabel,
                                        GroupLayout.PREFERRED_SIZE,
                                        59,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        horizSeparator,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(accountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(vertSeparator)
                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(accountPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING)
                                                        .addGroup(accountPanelLayout.createSequentialGroup()
                                                                .addComponent(
                                                                        editProfileLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(
                                                                        passwordSecurityLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                        .addGroup(
                                                                GroupLayout.Alignment.TRAILING,
                                                                accountPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(
                                                                        displayPanel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE))))))
        );

        updateUI();
    }
}
