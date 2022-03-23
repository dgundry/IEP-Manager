package com.mango.prjmango.ui.activities;

import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class FinishAssignmentView extends JPanel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

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

    @Getter private JLabel submitLabel;
    @Getter private JTextArea commentsTextArea;
    private JScrollPane jScrollPane1;

    @Getter private CreateAssignment assignment;
    public FinishAssignmentView(CreateAssignment assignment){
        this.assignment = assignment;

        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents(){
        finishAssignmentHeaderLabel = createLabel("Finish Assignment", 24);
        studentLabel = createLabel("Student:", 18);
        changeStudentLabel = createLabel(assignment.getStudent().toString(),18);
        assignmentLabel = createLabel("Assignment:", 18);
        changeAssignmentLabel = createLabel(assignment.getAssignmentName(),18);
        dateLabel = createLabel("Date:", 18);
        changeDateLabel = createLabel(java.time.LocalDate.now()+"",18);
        scoreLabel = createLabel("Score:", 18);
        changeScoreLabel = createLabel(assignment.getCorrectAnswers()+"/"+assignment.getTotalQuestions(),18);
        percentageLabel = createLabel("Percentage:", 18);
        String percentage = String.format("%.2f", ((double)assignment.getCorrectAnswers() / (double)assignment.getTotalQuestions())*100);
        changePercentageLabel = createLabel(percentage + "%",18);
        commentsLabel = createLabel("Comments:", 18);
//        submitLabel = createLabel("Submit", 18);
        submitLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        commentsTextArea = createTextArea();
        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(commentsTextArea);



    }

    private void createLayout(){
        GroupLayout sightWordAssignmentPanelLayout = new GroupLayout(this);
        setLayout(sightWordAssignmentPanelLayout);
        sightWordAssignmentPanelLayout.setHorizontalGroup(
                sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                .addComponent(submitLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(percentageLabel)
                                                        .addComponent(commentsLabel)
                                                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                                        .addComponent(studentLabel)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(changeStudentLabel))
                                                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                                        .addComponent(assignmentLabel)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(changeAssignmentLabel))
                                                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                                                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dateLabel)
                                                                                .addComponent(scoreLabel))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(changeScoreLabel)
                                                                                .addComponent(changeDateLabel)
                                                                                .addComponent(changePercentageLabel)))))
                                                .addGap(366, 366, 366))
                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 47, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(finishAssignmentHeaderLabel)
                                        .addContainerGap(421, Short.MAX_VALUE)))
        );
        sightWordAssignmentPanelLayout.setVerticalGroup(
                sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentLabel)
                                        .addComponent(changeStudentLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(assignmentLabel)
                                        .addComponent(changeAssignmentLabel))
                                .addGap(18, 18, 18)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeDateLabel)
                                        .addComponent(dateLabel))
                                .addGap(18, 18, 18)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(scoreLabel)
                                        .addComponent(changeScoreLabel))
                                .addGap(18, 18, 18)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(changePercentageLabel)
                                        .addComponent(percentageLabel))
                                .addGap(18, 18, 18)
                                .addComponent(commentsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(submitLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(1745, Short.MAX_VALUE))
                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(finishAssignmentHeaderLabel)
                                        .addContainerGap(1510, Short.MAX_VALUE)))
        );
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setMargin(new Insets(0, 5, 0, 5));
        textArea.setBackground(DARK_GREY);
        textArea.setForeground(LIGHT_GREY);
        textArea.setCaretColor(LIGHT_GREY);
        textArea.setFont(Fonts.SEGOE_UI_16.getFont());
        return textArea;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }

}
