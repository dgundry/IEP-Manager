package com.mango.prjmango.windows.createaccount.securityquestions;

import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.windows.common.Colors;
import com.mango.prjmango.windows.common.Components;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
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

        securityQuestion1ComboBox = Components.JComboBox(
                "Security Question #1",
                DatabaseCommands.getDropDownQuestions());
        securityQuestion2ComboBox = Components.JComboBox(
                "Security Question #2",
                DatabaseCommands.getDropDownQuestions());

        answer1TextField = Components.JTextField("Answer #1", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
        answer2TextField = Components.JTextField("Answer #2", Fonts.SEGOE_UI_16.getFont(), Colors.LIGHT_GREY);
    }

    private void createLayout() {
        GroupLayout securityQuestionsPanelLayout = new GroupLayout(this);
        setLayout(securityQuestionsPanelLayout);
        securityQuestionsPanelLayout.setHorizontalGroup(
                securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                securityQuestionsLabel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pawLogoLabel)
                                .addGap(185, 185, 185))
                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING, false)
                                        .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(
                                                        backLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        116,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(
                                                        nextLabel,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        116,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(
                                                invalidAnswer2Label,
                                                GroupLayout.PREFERRED_SIZE,
                                                410,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(
                                                securityQuestion2ComboBox,
                                                0,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                invalidAnswer1Label,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                securityQuestion1ComboBox,
                                                0,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(answer1TextField)
                                        .addComponent(answer2TextField, GroupLayout.Alignment.TRAILING))
                                .addContainerGap(36, Short.MAX_VALUE))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        securityQuestion1ComboBox,
                                        GroupLayout.PREFERRED_SIZE,
                                        59,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        answer1TextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidAnswer1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        securityQuestion2ComboBox,
                                        GroupLayout.PREFERRED_SIZE,
                                        59,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        answer2TextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidAnswer2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addContainerGap(92, Short.MAX_VALUE))
                        .addGroup(securityQuestionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(securityQuestionsPanelLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
