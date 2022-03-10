package com.mango.prjmango.windows.createaccount.securityquestions;

import com.mango.prjmango.components.Components;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import lombok.Getter;

/**
 * The user interface design of the Security Questions page.
 */
public class SecurityQuestionsView extends JLabel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel securityQuestionsLabel;

    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;

    @Getter private JComboBox<String> securityQuestion1ComboBox;
    @Getter private JComboBox<String> securityQuestion2ComboBox;

    @Getter private JTextField answer1TextField;
    @Getter private JTextField answer2TextField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public SecurityQuestionsView() {
        setIcon(ImageIcons.LOGIN_PANEL_BACKGROUND.getImageIcon());

        createComponents();
        createLayout();
    }

    private void createComponents() {
        pawLogoLabel = new JLabel(ImageIcons.PAW_LOGO.getImageIcon());
        backLabel    = new JLabel(ImageIcons.BACK_NO_HOVER.getImageIcon());
        nextLabel    = new JLabel(ImageIcons.NEXT_NO_HOVER.getImageIcon());

        iepManagerLabel = createLabel("IEP Manager", SwingConstants.CENTER);
        iepManagerLabel.setFont(Fonts.SEGOE_UI_26.getFont());

        securityQuestionsLabel = createLabel("Security Questions", SwingConstants.CENTER);
        securityQuestionsLabel.setFont(Fonts.SEGOE_UI_22.getFont());

        securityQuestion1ComboBox = new JComboBox<>();
        securityQuestion1ComboBox.setOpaque(false);
        securityQuestion1ComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        securityQuestion1ComboBox.setForeground(LIGHT_GREY);
        securityQuestion1ComboBox.setModel(new DefaultComboBoxModel<>(DatabaseCommands.getDropDownQuestions().toArray(new String[0])));
        securityQuestion1ComboBox.setBorder(BorderFactory.createTitledBorder(null, "Security Question #1", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 14), LIGHT_GREY));

        securityQuestion2ComboBox = new JComboBox<>();
        securityQuestion2ComboBox.setOpaque(false);
        securityQuestion2ComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        securityQuestion2ComboBox.setForeground(LIGHT_GREY);
        securityQuestion2ComboBox.setModel(new DefaultComboBoxModel<>(DatabaseCommands.getDropDownQuestions().toArray(new String[0])));
        securityQuestion2ComboBox.setBorder(BorderFactory.createTitledBorder(null, "Security Question #2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 14), LIGHT_GREY));

        answer1TextField = createTextField("Answer #1");
        answer2TextField = createTextField("Answer #2");
    }

    private void createLayout() {
        GroupLayout securityQuestionsPanelLayout = new GroupLayout(this);
        setLayout(securityQuestionsPanelLayout);
        securityQuestionsPanelLayout.setHorizontalGroup(
                securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(securityQuestionsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsPanelLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsPanelLayout.createSequentialGroup()
                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(answer2TextField, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addComponent(securityQuestion1ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answer1TextField)
                                        .addComponent(securityQuestion2ComboBox, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                        .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        securityQuestionsPanelLayout.setVerticalGroup(
                securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(securityQuestionsLabel)
                                .addGap(29, 29, 29)
                                .addComponent(securityQuestion1ComboBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(answer1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(securityQuestion2ComboBox, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(answer2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addContainerGap(10, Short.MAX_VALUE))
                        .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
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
                Fonts.SEGOE_UI_14.getFont(),
                LIGHT_GREY));
        textField.setCaretColor(LIGHT_GREY);
        return textField;
    }
}
