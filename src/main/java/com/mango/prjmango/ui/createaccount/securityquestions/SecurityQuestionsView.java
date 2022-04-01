package com.mango.prjmango.ui.createaccount.securityquestions;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Security Questions page.
 */
public class SecurityQuestionsView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel securityQuestionsLabel;
    private JLabel securityQuestion1Label;
    private JLabel securityQuestion2Label;

    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;
    @Getter private JLabel invalidAnswer1Label;
    @Getter private JLabel invalidAnswer2Label;

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

        iepManagerLabel = Components.JLabel(
                "IEP Manager",
                Fonts.SEGOE_UI_26.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        securityQuestionsLabel = Components.JLabel(
                "Security Questions",
                Fonts.SEGOE_UI_22.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        securityQuestion1Label = Components.JLabel(
                "Security Question #1",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        securityQuestion2Label = Components.JLabel(
                "Security Question #2",
                Fonts.SEGOE_UI_16.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEFT);
        invalidAnswer1Label = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        invalidAnswer1Label = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        invalidAnswer2Label = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        securityQuestion1ComboBox = Components.JComboBox(DatabaseCommands.getDropDownQuestions());
        securityQuestion2ComboBox = Components.JComboBox(DatabaseCommands.getDropDownQuestions());
        securityQuestion1ComboBox.setPreferredSize(new Dimension(56, 20));
        securityQuestion2ComboBox.setPreferredSize(new Dimension(56, 20));

        answer1TextField = Components.JTextField();
        answer2TextField = Components.JTextField();
    }

    private void createLayout() {
        GroupLayout securityQuestionsPanelLayout = new GroupLayout(this);
        setLayout(securityQuestionsPanelLayout);
        securityQuestionsPanelLayout.setHorizontalGroup(
                securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(securityQuestionsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsPanelLayout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(pawLogoLabel)
                                .addGap(185, 185, 185))
                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(invalidAnswer2Label, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(securityQuestion2ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(invalidAnswer1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(securityQuestion1ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(answer1TextField)
                                                        .addComponent(answer2TextField, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(securityQuestion1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(securityQuestion2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74)
                                                .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
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
                                .addComponent(securityQuestion1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(securityQuestion1ComboBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answer1TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidAnswer1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(securityQuestion2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(securityQuestion2ComboBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answer2TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidAnswer2Label)
                                .addGap(18, 27, Short.MAX_VALUE)
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel, GroupLayout.Alignment.TRAILING)
                                        .addComponent(nextLabel, GroupLayout.Alignment.TRAILING))
                                .addGap(34, 34, 34))
                        .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
