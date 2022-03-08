package com.mango.prjmango.windows.account.password;

import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Password & Security page.
 */
public class PasswordView extends JPanel {

    private JLabel passwordSecurityHeaderLabel;
    private JLabel confirmNewPassLabel;
    private JLabel currentPasswordLabel;
    private JLabel newPasswordLabel;

    @Getter private JLabel saveLabel;
    @Getter private JLabel informationLabel;
    @Getter private JLabel showCurrentPasswordLabel;
    @Getter private JLabel showNewPasswordLabel;
    @Getter private JLabel showConfirmPasswordLabel;

    @Getter private JPasswordField currentPasswordTextBox;
    @Getter private JPasswordField newPasswordTextBox;
    @Getter private JPasswordField confirmNewPassTextBox;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public PasswordView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        saveLabel                = new JLabel(ImageIcons.PASSWORD_SECURITY_SAVE_NO_HOVER.getImageIcon());
        showCurrentPasswordLabel = new JLabel(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
        showNewPasswordLabel     = new JLabel(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
        showConfirmPasswordLabel = new JLabel(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());

        passwordSecurityHeaderLabel = Components.JLabel(
                "Password",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        confirmNewPassLabel = Components.JLabel(
                "Confirm New Password",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        currentPasswordLabel = Components.JLabel(
                "Current Password",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        newPasswordLabel = Components.JLabel(
                "New Password",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        informationLabel = Components.JLabel(
                "",
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);

        currentPasswordTextBox = Components.JPasswordField();
        confirmNewPassTextBox  = Components.JPasswordField();
        newPasswordTextBox     = Components.JPasswordField();
    }

    private void createLayout() {
        GroupLayout passwordSecurityPanelLayout = new GroupLayout(this);
        setLayout(passwordSecurityPanelLayout);
        passwordSecurityPanelLayout.setHorizontalGroup(
                passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordSecurityHeaderLabel)
                                        .addComponent(currentPasswordLabel)
                                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                                .addComponent(
                                                        currentPasswordTextBox,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        472,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showCurrentPasswordLabel))
                                        .addComponent(newPasswordLabel)
                                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                                .addComponent(
                                                        newPasswordTextBox,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        472,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showNewPasswordLabel))
                                        .addComponent(confirmNewPassLabel)
                                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                                                .addComponent(
                                                                        saveLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(informationLabel))
                                                        .addComponent(
                                                                confirmNewPassTextBox,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                472,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showConfirmPasswordLabel)))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        passwordSecurityPanelLayout.setVerticalGroup(
                passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                .addComponent(passwordSecurityHeaderLabel)
                                .addGap(70, 70, 70)
                                .addComponent(currentPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(
                                                currentPasswordTextBox,
                                                GroupLayout.PREFERRED_SIZE,
                                                32,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showCurrentPasswordLabel))
                                .addGap(9, 9, 9)
                                .addComponent(newPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                newPasswordTextBox,
                                                GroupLayout.PREFERRED_SIZE,
                                                32,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showNewPasswordLabel))
                                .addGap(9, 9, 9)
                                .addComponent(confirmNewPassLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                confirmNewPassTextBox,
                                                GroupLayout.PREFERRED_SIZE,
                                                32,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showConfirmPasswordLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                saveLabel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addGap(0, 617, Short.MAX_VALUE))
        );
    }
}
