package com.mango.prjmango.ui.login;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.common.Images;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Login page.
 */
public class LoginView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;

    @Getter private JLabel signInLabel;
    @Getter private JLabel loginLabel;
    @Getter private JLabel createAccountLabel;
    @Getter private JLabel forgotPasswordLabel;
    @Getter private JLabel invalidLabel;

    @Getter private JTextField emailField;
    @Getter private JPasswordField passwordField;

    /**
     * The user interface design of the Login page.
     */
    public LoginView() {
        setIcon(ImageIcons.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());
        loginLabel   = new JLabel(Images.LOGIN_NO_HOVER.getImageIcon());

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        signInLabel = Components.JLabel(
                "Sign In",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        createAccountLabel = Components.JLabel(
                "Create Account",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        forgotPasswordLabel = Components.JLabel(
                "Forgot Password?",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        invalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        emailField = Components.JTextField("Email", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);

        passwordField = Components.JPasswordField("Password");
    }

    private void createLayout() {
        GroupLayout loginPanelLayout = new GroupLayout(this);
        setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signInLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                loginPanelLayout.createSequentialGroup()
                                                .addComponent(pawLogoLabel)
                                                .addGap(185, 185, 185))
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                loginPanelLayout.createSequentialGroup()
                                                .addComponent(
                                                        loginLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        116,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(182, 182, 182))))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(createAccountLabel)
                                                .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                        59,
                                                        Short.MAX_VALUE)
                                                .addComponent(forgotPasswordLabel))
                                        .addComponent(emailField)
                                        .addComponent(
                                                invalidLabel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(0, 97, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(signInLabel)
                                .addGap(29, 29, 29)
                                .addComponent(
                                        emailField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(
                                        passwordField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidLabel)
                                .addGap(18, 18, 18)
                                .addComponent(loginLabel)
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(createAccountLabel)
                                        .addComponent(forgotPasswordLabel))
                                .addContainerGap(110, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(loginPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
