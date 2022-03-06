package com.mango.prjmango.windows.createaccount.password;

import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

public class PasswordView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel passwordLabel;

    @Getter private JLabel backLabel;
    @Getter private JLabel createAccountLabel;
    @Getter private JLabel invalidLabel;

    @Getter private JPasswordField createPasswordField;
    @Getter private JPasswordField confirmPasswordField;

    public PasswordView() {
        setIcon(ImageIcons.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel       = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());
        backLabel          = new JLabel(ImageIcons.BACK_NO_HOVER.getImageIcon());
        createAccountLabel = new JLabel(ImageIcons.NEXT_NO_HOVER.getImageIcon());

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        passwordLabel  = Components.JLabel(
                "Password",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        invalidLabel = Components.JLabel(" ", Fonts.SEGOE_UI_12.getFont(), Colors.RED, SwingConstants.CENTER);

        createPasswordField  = Components.JPasswordField("Create Password");
        confirmPasswordField = Components.JPasswordField("Confirm Password");
    }

    private void createLayout() {
        GroupLayout createPasswordPanelLayout = new GroupLayout(this);
        setLayout(createPasswordPanelLayout);
        createPasswordPanelLayout.setHorizontalGroup(
                createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                passwordLabel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, createPasswordPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                createPasswordField,
                                                GroupLayout.PREFERRED_SIZE,
                                                288,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(createPasswordPanelLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addGroup(createPasswordPanelLayout.createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(createPasswordPanelLayout.createSequentialGroup()
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
                                                                createAccountLabel,
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
                                                        Short.MAX_VALUE)))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(createAccountLabel))
                                .addGap(149, 149, 149))
                        .addGroup(createPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(createPasswordPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
