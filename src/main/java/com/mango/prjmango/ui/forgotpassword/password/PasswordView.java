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
    private JLabel passwordLabel;

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
        passwordLabel = Components.JLabel(
                "Reset Password",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        invalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        createPasswordField  = Components.JPasswordField("Create Password");
        confirmPasswordField = Components.JPasswordField("Confirm Password");
    }

    private void createLayout() {
        GroupLayout resetPasswordPanelLayout = new GroupLayout(this);
        setLayout(resetPasswordPanelLayout);
        resetPasswordPanelLayout.setHorizontalGroup(
                resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                passwordLabel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, resetPasswordPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                resetPasswordPanelLayout.createSequentialGroup()
                                                .addComponent(pawLogoLabel)
                                                .addGap(185, 185, 185))
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                resetPasswordPanelLayout.createSequentialGroup()
                                                .addComponent(
                                                        createPasswordField,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        288,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97))
                                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                                .addGroup(resetPasswordPanelLayout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                                                .addComponent(
                                                                        backLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        116,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        resetPasswordLabel,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        116,
                                                                        GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(
                                                                invalidLabel,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                confirmPasswordField,
                                                                GroupLayout.Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                288,
                                                                Short.MAX_VALUE))
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
                                .addComponent(passwordLabel)
                                .addGap(29, 29, 29)
                                .addComponent(
                                        createPasswordField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        confirmPasswordField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidLabel)
                                .addGap(102, 102, 102)
                                .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(resetPasswordLabel))
                                .addContainerGap(58, Short.MAX_VALUE))
                        .addGroup(resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
