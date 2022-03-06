package com.mango.prjmango.windows.createaccount.basicinfo;

import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import lombok.Getter;

/**
 * The user interface design of the Basic Info page.
 */
public class BasicInfoView extends JLabel {

    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel basicInfoLabel;

    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;

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

        iepManagerLabel = createLabel("IEP Manager", 26, SwingConstants.CENTER);
        basicInfoLabel  = createLabel("Basic Info", 22, SwingConstants.CENTER);

        firstNameTextField = createTextField("First Name");
        lastNameTextField  = createTextField("Last Name");
        emailTextField     = createTextField("Email");
    }

    private void createLayout() {
        GroupLayout basicInfoPanelLayout = new GroupLayout(this);
        setLayout(basicInfoPanelLayout);
        basicInfoPanelLayout.setHorizontalGroup(
                basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(basicInfoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, basicInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, basicInfoPanelLayout.createSequentialGroup()
                                                        .addComponent(pawLogoLabel)
                                                        .addGap(185, 185, 185))
                                                .addGroup(GroupLayout.Alignment.TRAILING, basicInfoPanelLayout.createSequentialGroup()
                                                        .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(basicInfoPanelLayout.createSequentialGroup()
                                                                        .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(97, 97, 97)))))
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
                                .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addGap(86, 86, 86))
                        .addGroup(basicInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(basicInfoPanelLayout.createSequentialGroup()
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

    private JTextField createTextField(String text) {
        JTextField textField = new JTextField();
        textField.setOpaque(false);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        textField.setForeground(LIGHT_GREY);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBorder(BorderFactory.createTitledBorder(
                null,
                text,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14),
                LIGHT_GREY));
        textField.setCaretColor(LIGHT_GREY);
        return textField;
    }
}
