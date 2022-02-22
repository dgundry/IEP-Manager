package com.mango.prjmango.windows.login;

import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Font;
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

public class LoginView extends JLabel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    @Getter private JLabel signInLabel;
    @Getter private JLabel loginLabel;
    @Getter private JLabel createAccountLabel;
    @Getter private JLabel forgotPasswordLabel;

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;

    @Getter private JTextField emailField;
    @Getter private JPasswordField passwordField;

    public LoginView() {
        setIcon(Images.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel = new JLabel(Images.PAW_LOGO.getImageIcon());
        loginLabel = new JLabel(Images.LOGIN_NO_HOVER.getImageIcon());

        iepManagerLabel = createLabel("IEP Manager", 26, SwingConstants.CENTER);
        signInLabel = createLabel("Sign in", 22, SwingConstants.CENTER);
        createAccountLabel = createLabel("Create Account", 16, SwingConstants.LEFT);
        forgotPasswordLabel = createLabel("Forgot Password?", 16, SwingConstants.LEFT);

        emailField = new JTextField();
        emailField.setBackground(DARK_GREY);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        emailField.setForeground(LIGHT_GREY);
        emailField.setMargin(new Insets(0, 5, 0, 5));
        emailField.setBorder(BorderFactory.createTitledBorder(
                null,
                "Email",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14),
                LIGHT_GREY));
        emailField.setCaretColor(LIGHT_GREY);

        passwordField = new JPasswordField();
        passwordField.setBackground(DARK_GREY);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setForeground(LIGHT_GREY);
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        passwordField.setBorder(BorderFactory.createTitledBorder(
                null,
                "Password",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14),
                LIGHT_GREY));
        passwordField.setCaretColor(LIGHT_GREY);
    }

    private void createLayout() {
        GroupLayout loginPanelLayout = new GroupLayout(this);
        setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signInLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addComponent(createAccountLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(forgotPasswordLabel))
                                        .addComponent(emailField))
                                .addGap(0, 97, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(pawLogoLabel)
                                                .addGap(185, 185, 185))
                                        .addGroup(GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(180, 180, 180))))
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
                                .addGap(18, 18, 18)
                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(createAccountLabel)
                                        .addComponent(forgotPasswordLabel))
                                .addContainerGap(139, Short.MAX_VALUE))
                        .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(loginPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }

    private JLabel createLabel(String text, int fontSize, int alignment) {
        JLabel label = new JLabel(text);
        label.setForeground(LIGHT_GREY);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setHorizontalAlignment(alignment);
        return label;
    }
}
