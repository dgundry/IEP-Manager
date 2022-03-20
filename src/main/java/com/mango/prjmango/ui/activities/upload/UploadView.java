package com.mango.prjmango.ui.activities.upload;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.common.ImageIcons;
import lombok.Getter;
import com.mango.prjmango.ui.common.Fonts;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class UploadView extends JPanel {

    private final Color DARK_GREY = new Color(19,18,18);
    private final Color LIGHT_GREY = new Color(216,216,216);

    private JLabel addAssignmentHeaderLabel;

    @Getter private JLabel saveLabel;
    private JLabel pointsEarnedLabel;
    private JLabel studentNameLabel;
    private JLabel assignmentNameLabel1;
    private JLabel commentsLabel;
    private JLabel dateLabel;
    private JLabel maximumPointsLabel;

    @Getter private JTextField assignmentNameTextField;
    @Getter private JTextField pointsEarnedTextField;
    @Getter private JTextField maximumPointsTextField;
    @Getter private JTextField dateTextField;
    @Getter private JTextField commentsTextField;

    @Getter private JComboBox<Student> studentNameDropdown;


    public UploadView() {
        setOpaque(false);

        createComponents();
        createLayout();

    }

    private void createComponents(){

        addAssignmentHeaderLabel = createLabel("Upload an Assignment", 24);
        studentNameLabel = createLabel("Student's Name", 18);
        assignmentNameLabel1 = createLabel("Assignment Name", 18);
        dateLabel = createLabel("Date (YYYY-MM-DD) ",18);
        pointsEarnedLabel = createLabel("Points Earned", 18);
        maximumPointsLabel = createLabel("Maximum Points", 18);
        commentsLabel = createLabel("Comments", 18);

        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        assignmentNameTextField = createTextField();
        pointsEarnedTextField = createTextField();
        maximumPointsTextField = createTextField();
        dateTextField = createTextField();
        commentsTextField = createTextField();

        studentNameDropdown = new JComboBox<>(new Vector<>(Main.getStudents().getStudents()));
        studentNameDropdown.setBackground(Color.WHITE);
    }

    public void createLayout(){

        GroupLayout addAssignmentPanelLayout = new GroupLayout(this);
        setLayout(addAssignmentPanelLayout);
        addAssignmentPanelLayout.setHorizontalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addAssignmentHeaderLabel)
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(pointsEarnedLabel)
                                                                                .addComponent(assignmentNameTextField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                                                                .addComponent(studentNameLabel)
                                                                                .addComponent(pointsEarnedTextField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                                                                .addComponent(assignmentNameLabel1)
                                                                                .addComponent(commentsLabel))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(maximumPointsTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(dateTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(dateLabel)
                                                                                .addComponent(maximumPointsLabel)))
                                                                .addComponent(commentsTextField, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                                                                .addComponent(studentNameDropdown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(78, 78, 78))
        );
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addAssignmentHeaderLabel)
                                .addGap(106, 106, 106)
                                .addComponent(studentNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentNameDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(assignmentNameLabel1)
                                        .addComponent(dateLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(assignmentNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pointsEarnedLabel)
                                        .addComponent(maximumPointsLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pointsEarnedTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maximumPointsTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addComponent(commentsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentsTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(883, Short.MAX_VALUE))
        );
    }
    private JTextField createTextField() {
        JTextField textField = new JTextField();
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

    private JComboBox<String> createComboBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBackground(DARK_GREY);
        comboBox.setFont(Fonts.SEGOE_UI_18.getFont());
        comboBox.setForeground(LIGHT_GREY);
        return comboBox;
    }
}
