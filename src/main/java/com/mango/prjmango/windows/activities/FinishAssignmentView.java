package com.mango.prjmango.windows.activities;

import com.mango.prjmango.windows.common.Fonts;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

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

    @Getter private JLabel editDataLabel;
    private JLabel submitLabel;
    @Getter private JLabel saveLabel;

    private JTextArea commentsTextArea;

    private JScrollPane jScrollPane1;


    public FinishAssignmentView(){
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents(){
        finishAssignmentHeaderLabel = createLabel("Finish Assignment", 24);
        studentLabel = createLabel("Student:", 18);
        changeStudentLabel = createLabel("change this label",18);
        assignmentLabel = createLabel("Assignment:", 18);
        changeAssignmentLabel = createLabel("change this label",18);
        dateLabel = createLabel("Date:", 18);
        changeDateLabel = createLabel("change this label",18);
        scoreLabel = createLabel("Score:", 18);
        changeScoreLabel = createLabel("##/##",18);
        percentageLabel = createLabel("Percentage:", 18);
        changePercentageLabel = createLabel("##%",18);
        commentsLabel = createLabel("Comments:", 18);

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane1.setViewportView(commentsTextArea);

        editDataLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editDataLabel.setForeground(new java.awt.Color(216, 216, 216));
        editDataLabel.setMaximumSize(new java.awt.Dimension(117, 43));
        editDataLabel.setMinimumSize(new java.awt.Dimension(117, 43));
        editDataLabel.setPreferredSize(new java.awt.Dimension(117, 43));


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
                                                .addComponent(editDataLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addGap(389, 389, 389)
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
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286))
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
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(editDataLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(1745, Short.MAX_VALUE))
                        .addGroup(sightWordAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sightWordAssignmentPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(finishAssignmentHeaderLabel)
                                        .addContainerGap(1510, Short.MAX_VALUE)))
        );
    }

    private JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBackground(DARK_GREY);
        textField.setForeground(LIGHT_GREY);
        textField.setCaretColor(LIGHT_GREY);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        return textField;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }

}
