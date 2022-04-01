package com.mango.prjmango.ui.createaccount.password;

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
 * The user interface design of the Create Account page.
 */
public class PasswordView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel passwordTitleLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;

    @Getter private JLabel backLabel;
    @Getter private JLabel createAccountLabel;
    @Getter private JLabel invalidLabel;

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
        createAccountLabel = new JLabel(ImageIcons.CREATE_ACCOUNT_NO_HOVER.getImageIcon());

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        passwordTitleLabel = Components.JLabel(
                "Password",
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
        invalidLabel = Components.JLabel(" ", Fonts.SEGOE_UI_12.getFont(), Colors.RED, SwingConstants.CENTER);

        createPasswordField  = Components.JPasswordField();
        confirmPasswordField = Components.JPasswordField();
    }

    private void createLayout() {
        GroupLayout createPasswordPanelLayout = new GroupLayout(this);
        setLayout(createPasswordPanelLayout);
        createPasswordPanelLayout.setHorizontalGroup(
                createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(passwordTitleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, createPasswordPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(createPasswordField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                        .addGroup(createPasswordPanelLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addGroup(GroupLayout.Alignment.TRAILING, createPasswordPanelLayout.createSequentialGroup()
                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createAccountLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(invalidLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                        .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(confirmPasswordLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                        .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        createPasswordPanelLayout.setVerticalGroup(
                createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createPasswordPanelLayout.createSequentialGroup()
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
                                .addGap(18, 18, 18)
                                .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(createAccountLabel))
                                .addContainerGap(138, Short.MAX_VALUE))
                        .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(createPasswordPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
