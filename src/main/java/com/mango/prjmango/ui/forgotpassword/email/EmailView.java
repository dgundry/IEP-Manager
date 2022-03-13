package com.mango.prjmango.ui.forgotpassword.email;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Email page for the Forgot Password section.
 */
public class EmailView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel resetPasswordLabel;

    @Getter private JLabel invalidLabel;
    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;

    @Getter private JTextField emailTextField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public EmailView() {
        setIcon(ImageIcons.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());
        backLabel    = new JLabel(ImageIcons.BACK_NO_HOVER.getImageIcon());
        nextLabel    = new JLabel(ImageIcons.NEXT_NO_HOVER.getImageIcon());

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        resetPasswordLabel = Components.JLabel(
                "Reset Password",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        invalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        emailTextField = Components.JTextField("Email", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
    }

    private void createLayout() {
        GroupLayout emailPanelLayout = new GroupLayout(this);
        setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
                emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                resetPasswordLabel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, emailPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                emailPanelLayout.createSequentialGroup()
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
                                                        nextLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        116,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(emailPanelLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addComponent(
                                                invalidLabel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                        .addGroup(emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        emailPanelLayout.setVerticalGroup(
                emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(emailPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(resetPasswordLabel)
                                .addGap(29, 29, 29)
                                .addComponent(
                                        emailTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidLabel)
                                .addGap(173, 173, 173)
                                .addGroup(emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addContainerGap(58, Short.MAX_VALUE))
                        .addGroup(emailPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(emailPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
