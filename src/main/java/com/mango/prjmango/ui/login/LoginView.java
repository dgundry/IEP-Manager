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
    private JLabel emailLabel;
    private JLabel passwordLabel;

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

        emailField.requestFocus();
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
        emailLabel = Components.JLabel(
                "Email",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        passwordLabel = Components.JLabel(
                "Password",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
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

        emailField = Components.JTextField();
        passwordField = Components.JPasswordField();
    }

    private void createLayout() {
        GroupLayout loginPanelLayout = new GroupLayout(this);
        setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signInLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addContainerGap(185, Short.MAX_VALUE)
                                .addComponent(pawLogoLabel)
                                .addGap(185, 185, 185))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(createAccountLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(forgotPasswordLabel))
                                        .addComponent(emailField)
                                        .addComponent(invalidLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(emailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidLabel)
                                .addGap(18, 18, 18)
                                .addComponent(loginLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(createAccountLabel)
                                        .addComponent(forgotPasswordLabel))
                                .addContainerGap(118, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(loginPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
