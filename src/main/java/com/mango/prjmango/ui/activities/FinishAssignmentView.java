package com.mango.prjmango.ui.activities;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import java.time.LocalDate;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Final Assignment overview.
 */
public class FinishAssignmentView extends JPanel {

    private JLabel finishAssignmentHeaderLabel;
    private JLabel studentLabel;
    private JLabel assignmentLabel;
    private JLabel dateLabel;
    private JLabel scoreLabel;
    private JLabel percentageLabel;
    private JLabel commentsLabel;

    @Getter private JLabel changeStudentLabel;
    @Getter private JLabel changeAssignmentLabel;
    @Getter private JLabel changeDateLabel;
    @Getter private JLabel changeScoreLabel;
    @Getter private JLabel changePercentageLabel;
    @Getter private JLabel saveLabel;

    @Getter private JTextArea commentsTextArea;

    @Getter private CreateAssignment assignment;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public FinishAssignmentView(CreateAssignment assignment) {
        this.assignment = assignment;

        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        finishAssignmentHeaderLabel = Components.JLabel(
                "Finish Assignment",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY);
        studentLabel = Components.JLabel(
                "Student:",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        changeStudentLabel = Components.JLabel(
                assignment.getStudent().toString(),
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        changeAssignmentLabel = Components.JLabel(
                assignment.getAssignmentName(),
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);
        changeScoreLabel = Components.JLabel(
                assignment.getCorrectAnswers() + "/" +assignment.getTotalQuestions(),
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY);

        String percentage = String.format(
                "%.2f", ((double) assignment.getCorrectAnswers() / (double) assignment.getTotalQuestions()) * 100);

        assignmentLabel       = Components.JLabel("Assignment:",        Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        dateLabel             = Components.JLabel("Date:",              Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        changeDateLabel       = Components.JLabel(LocalDate.now() + "", Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        scoreLabel            = Components.JLabel("Score:",             Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        percentageLabel       = Components.JLabel("Percentage:",        Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        changePercentageLabel = Components.JLabel(percentage + "%",     Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        commentsLabel         = Components.JLabel("Comments:",          Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);

        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        commentsTextArea = Components.JTextArea("");
        commentsTextArea.setLineWrap(true);
        commentsTextArea.setWrapStyleWord(true);
        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        commentsTextArea.requestFocus();
    }

    private void createLayout() {
        GroupLayout finishAssignmentPanelLayout = new GroupLayout(this);
        setLayout(finishAssignmentPanelLayout);
        finishAssignmentPanelLayout.setHorizontalGroup(
                finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, finishAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(commentsLabel)
                                        .addGroup(finishAssignmentPanelLayout.createSequentialGroup()
                                                .addComponent(percentageLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(changePercentageLabel))
                                        .addComponent(commentsTextArea, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(finishAssignmentHeaderLabel)
                                        .addComponent(saveLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(finishAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(assignmentLabel)
                                                        .addComponent(studentLabel)
                                                        .addComponent(dateLabel)
                                                        .addComponent(scoreLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(changeScoreLabel)
                                                        .addComponent(changeDateLabel)
                                                        .addComponent(changeStudentLabel)
                                                        .addComponent(changeAssignmentLabel))))
                                .addContainerGap(378, Short.MAX_VALUE))
        );
        finishAssignmentPanelLayout.setVerticalGroup(
                finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(finishAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(finishAssignmentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentLabel)
                                        .addComponent(changeStudentLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(assignmentLabel)
                                        .addComponent(changeAssignmentLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(changeDateLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(scoreLabel)
                                        .addComponent(changeScoreLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(finishAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(percentageLabel)
                                        .addComponent(changePercentageLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentsTextArea, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(993, Short.MAX_VALUE))
        );
    }
}
