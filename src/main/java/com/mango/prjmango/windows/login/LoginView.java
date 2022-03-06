package com.mango.prjmango.windows.login;

import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import com.mango.prjmango.windows.common.Images;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import lombok.Getter;

/**
 * The user interface design of the Login page.
 */
public class LoginView extends JLabel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

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

        iepManagerLabel = createLabel("IEP Manager", SwingConstants.CENTER);
        iepManagerLabel.setFont(Fonts.SEGOE_UI_26.getFont());

        signInLabel = createLabel("Sign In", SwingConstants.CENTER);
        signInLabel.setFont(Fonts.SEGOE_UI_22.getFont());

        createAccountLabel = createLabel("Create Account", SwingConstants.LEFT);
        createAccountLabel.setFont(Fonts.SEGOE_UI_16.getFont());

        forgotPasswordLabel = createLabel("Forgot Password?", SwingConstants.LEFT);
        forgotPasswordLabel.setFont(Fonts.SEGOE_UI_16.getFont());

        invalidLabel = new JLabel(" ");
        invalidLabel.setFont(Fonts.SEGOE_UI_12.getFont());
        invalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
        invalidLabel.setForeground(new Color(252, 42, 42));

        emailField = new JTextField();
        emailField.setOpaque(false);
        emailField.setFont(Fonts.SEGOE_UI_16.getFont());
        emailField.setForeground(LIGHT_GREY);
        emailField.setMargin(new Insets(10, 10, 10, 10));
        emailField.setBorder(BorderFactory.createTitledBorder(
                null,
                "Email",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                LIGHT_GREY));
        emailField.setCaretColor(LIGHT_GREY);

        passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setForeground(LIGHT_GREY);
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        passwordField.setBorder(BorderFactory.createTitledBorder(
                null,
                "Password",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                LIGHT_GREY));
        passwordField.setCaretColor(LIGHT_GREY);
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
                                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(pawLogoLabel)
                                                .addGap(185, 185, 185))
                                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(182, 182, 182))))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(createAccountLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(forgotPasswordLabel))
                                        .addComponent(emailField)
                                        .addComponent(invalidLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

    private JLabel createLabel(String text, int alignment) {
        JLabel label = new JLabel(text);
        label.setForeground(LIGHT_GREY);
        label.setHorizontalAlignment(alignment);
        return label;
    }
}
