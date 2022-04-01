package com.mango.prjmango.ui.forgotpassword.securityquestions;

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
 * The user interface design of the Answer Security Questions Page for the Forgot Password section.
 */
public class AnswerSecurityQuestionsView extends JLabel {

    private JLabel pawLogoLabel;
    private JLabel iepManagerLabel;
    private JLabel securityQuestionsLabel;

    @Getter private JLabel question1Label;
    @Getter private JLabel question2Label;
    @Getter private JLabel invalidLabel;
    @Getter private JLabel backLabel;
    @Getter private JLabel nextLabel;

    @Getter private JTextField answer1TextField;
    @Getter private JTextField answer2TextField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public AnswerSecurityQuestionsView() {
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
        question1Label = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        question2Label = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.CENTER);
        invalidLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        answer1TextField = Components.JTextField();
        answer2TextField = Components.JTextField();
    }

    private void createLayout() {
        GroupLayout securityQuestionsLayout = new GroupLayout(this);
        setLayout(securityQuestionsLayout);
        securityQuestionsLayout.setHorizontalGroup(
                securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(securityQuestionsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsLayout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addGroup(securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, securityQuestionsLayout.createSequentialGroup()
                                                .addComponent(backLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(securityQuestionsLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(pawLogoLabel))
                                        .addComponent(answer1TextField)
                                        .addComponent(answer2TextField)
                                        .addComponent(invalidLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                        .addGroup(securityQuestionsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(question1Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(question2Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(iepManagerLabel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        securityQuestionsLayout.setVerticalGroup(
                securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(pawLogoLabel)
                                .addGap(83, 83, 83)
                                .addComponent(securityQuestionsLabel)
                                .addGap(18, 18, 18)
                                .addComponent(question1Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answer1TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(question2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answer2TextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invalidLabel)
                                .addGap(48, 48, 48)
                                .addGroup(securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel)
                                        .addComponent(nextLabel))
                                .addContainerGap(63, Short.MAX_VALUE))
                        .addGroup(securityQuestionsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(securityQuestionsLayout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(iepManagerLabel)
                                        .addContainerGap(415, Short.MAX_VALUE)))
        );
    }
}
