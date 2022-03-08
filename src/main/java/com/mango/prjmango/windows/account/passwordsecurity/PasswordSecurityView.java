package com.mango.prjmango.windows.account.passwordsecurity;

import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Password & Security page.
 */
public class PasswordSecurityView extends JPanel {

    @Getter private JLabel saveLabel;
    @Getter private JLabel informationLabel;

    private JLabel passwordSecurityHeaderLabel;
    private JLabel confirmNewPassLabel;
    private JLabel currentPasswordLabel;
    private JLabel newPasswordLabel;

    @Getter private JPasswordField currentPasswordTextBox;
    @Getter private JPasswordField newPasswordTextBox;
    @Getter private JPasswordField confirmNewPassTextBox;

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public PasswordSecurityView() {
        setOpaque(false);
        createComponents();
        createLayout();
    }

    private void createComponents() {
        saveLabel = new JLabel(ImageIcons.PASSWORD_SECURITY_SAVE_NO_HOVER.getImageIcon());

        passwordSecurityHeaderLabel = createLabel("Password & Security",  Fonts.SEGOE_UI_24.getFont());
        confirmNewPassLabel         = createLabel("Confirm New Password", Fonts.SEGOE_UI_18.getFont());
        currentPasswordLabel        = createLabel("Current Password",     Fonts.SEGOE_UI_18.getFont());
        newPasswordLabel            = createLabel("New Password",         Fonts.SEGOE_UI_18.getFont());
        informationLabel            = createLabel("",                     Fonts.SEGOE_UI_14.getFont());

        currentPasswordTextBox = createPasswordField("");
        confirmNewPassTextBox  = createPasswordField("");
        newPasswordTextBox     = createPasswordField("");
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
                                        .addComponent(currentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newPasswordLabel)
                                        .addComponent(newPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmNewPassLabel)
                                        .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(informationLabel))
                                                .addComponent(confirmNewPassTextBox, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        passwordSecurityPanelLayout.setVerticalGroup(
                passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                .addComponent(passwordSecurityHeaderLabel)
                                .addGap(70, 70, 70)
                                .addComponent(currentPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(newPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(confirmNewPassLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmNewPassTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addGap(0, 617, Short.MAX_VALUE))
        );
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(LIGHT_GREY);
        return label;
    }

    private JPasswordField createPasswordField(String text) {
        JPasswordField passwordField = new JPasswordField(text);
        passwordField.setBackground(DARK_GREY);
        passwordField.setForeground(LIGHT_GREY);
        passwordField.setCaretColor(LIGHT_GREY);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        return passwordField;
    }
}
