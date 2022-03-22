package com.mango.prjmango.ui.createaccount.basicinfo;

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
 * The user interface design of the Basic Info page.
 */
public class BasicInfoView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel basicInfoLabel;

    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;
    @Getter private JLabel firstNameInvalidLabel;
    @Getter private JLabel lastNameInvalidLabel;
    @Getter private JLabel emailInvalidLabel;

    @Getter private JTextField firstNameTextField;
    @Getter private JTextField lastNameTextField;
    @Getter private JTextField emailTextField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public BasicInfoView() {
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
        basicInfoLabel = Components.JLabel(
                "Basic Info",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        firstNameInvalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        lastNameInvalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        emailInvalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        firstNameTextField = Components.JTextField("First Name", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
        lastNameTextField  = Components.JTextField("Last Name", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
        emailTextField     = Components.JTextField("Email", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
    }

    private void createLayout() {
        GroupLayout basicInfoPanelLayout = new GroupLayout(this);
        setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
                basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basicInfoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, basicInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                basicInfoPanelLayout.createSequentialGroup()
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
                                        .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addComponent(lastNameTextField)
                                        .addComponent(
                                                firstNameInvalidLabel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                firstNameTextField,
                                                GroupLayout.DEFAULT_SIZE,
                                                288,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                lastNameInvalidLabel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                emailInvalidLabel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                        .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        basicInfoPanelLayout.setVerticalGroup(
                basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(basicInfoLabel)
                                .addGap(29, 29, 29)
                                .addComponent(
                                        firstNameTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstNameInvalidLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        lastNameTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameInvalidLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        emailTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailInvalidLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addContainerGap(58, Short.MAX_VALUE))
                        .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
