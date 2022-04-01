package com.mango.prjmango.ui.forgotpassword.password;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Reset Password Page for the Forgot Password section.
 */
public class PasswordView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel passwordTitleLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    @Getter private JLabel invalidLabel;
    @Getter private JLabel backLabel;
    @Getter private JLabel resetPasswordLabel;

    @Getter private JPasswordField createPasswordField;
    @Getter private JPasswordField confirmPasswordField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public PasswordView() {
        setIcon(ImageIcons.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel       = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());
        backLabel          = new JLabel(ImageIcons.BACK_NO_HOVER.getImageIcon());
        resetPasswordLabel = new JLabel(ImageIcons.RESET_PASSWORD_NO_HOVER.getImageIcon());

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        passwordTitleLabel = Components.JLabel(
                "Reset Password",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        passwordLabel = Components.JLabel(
                "Password",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        confirmPasswordLabel = Components.JLabel(
                "Confirm Password",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        invalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        createPasswordField  = Components.JPasswordField();
        confirmPasswordField = Components.JPasswordField();
    }

    private void createLayout() {
        GroupLayout resetPasswordPanelLayout = new GroupLayout(this);
        setLayout(resetPasswordPanelLayout);
        resetPasswordPanelLayout.setHorizontalGroup(
                resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(passwordTitleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                                                .addComponent(pawLogoLabel)
                                                .addGap(185, 185, 185))
                                        .addGroup(GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(56, 56, 56)
                                                                                .addComponent(resetPasswordLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(createPasswordField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                                                .addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                                                .addComponent(confirmPasswordLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(invalidLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                .addGap(97, 97, 97))))
                        .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        resetPasswordPanelLayout.setVerticalGroup(
                resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(passwordTitleLabel)
                                .addGap(29, 29, 29)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createPasswordField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(confirmPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(invalidLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel, GroupLayout.Alignment.TRAILING)
                                        .addComponent(resetPasswordLabel, GroupLayout.Alignment.TRAILING))
                                .addGap(58, 58, 58))
                        .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
