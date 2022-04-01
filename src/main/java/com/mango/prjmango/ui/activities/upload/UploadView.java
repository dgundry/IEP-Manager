package com.mango.prjmango.ui.activities.upload;

import com.mango.prjmango.Main;
import com.mango.prjmango.Outlines.Outline;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.DateChooser;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedComboBox;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Upload Assignment page.
 */
public class UploadView extends JPanel {

    private JLabel addAssignmentHeaderLabel;
    private JLabel pointsEarnedLabel;
    private JLabel studentNameLabel;
    private JLabel assignmentNameLabel1;
    private JLabel commentsLabel;
    private JLabel dateLabel;
    private JLabel maximumPointsLabel;

    @Getter private JLabel informationLabel;

    @Getter private JLabel saveLabel;

    @Getter private JTextField assignmentNameTextField;
    @Getter private JTextField pointsEarnedTextField;
    @Getter private JTextField maximumPointsTextField;

    @Getter private DateChooser dateTextField;
    @Getter private JTextField commentsTextField;

    @Getter private JComboBox<Student> studentNameDropdown;
    @Getter private JComboBox<Outline> assignmentNameDropdown;


    /**
     * Constructor. Calls methods that create the GUI.
     */
    public UploadView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents(){
        addAssignmentHeaderLabel = Components.JLabel("Upload an Assignment", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        studentNameLabel         = Components.JLabel("Student's Name",       Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        assignmentNameLabel1     = Components.JLabel("Assignment Name",      Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        dateLabel                = Components.JLabel("Date",   Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        pointsEarnedLabel        = Components.JLabel("Points Earned",        Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        maximumPointsLabel       = Components.JLabel("Maximum Points",       Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        commentsLabel            = Components.JLabel("Comments",             Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel       = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);


        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        assignmentNameTextField = Components.JTextField("");
        pointsEarnedTextField   = Components.JTextField("");
        maximumPointsTextField  = Components.JTextField("");
        dateTextField           = new DateChooser(1,1,1);
        commentsTextField       = Components.JTextField("");

        studentNameDropdown = new RoundedComboBox<>(Main.getStudents().getStudents());
        studentNameDropdown.setFont(Fonts.SEGOE_UI_16.getFont());
        studentNameDropdown.setBackground(Colors.DARK_GREY);
        studentNameDropdown.setForeground(Colors.LIGHT_GREY);

        assignmentNameDropdown = new RoundedComboBox<>(Main.getOutlines().getOutlines());
        assignmentNameDropdown.insertItemAt(new Outline(0,"Select an Assignment",0), 0);
        assignmentNameDropdown.setSelectedIndex(0);
        assignmentNameDropdown.setFont(Fonts.SEGOE_UI_16.getFont());
        assignmentNameDropdown.setBackground(Colors.DARK_GREY);
        assignmentNameDropdown.setForeground(Colors.LIGHT_GREY);
    }

    public void createLayout() {
        GroupLayout addAssignmentPanelLayout = new GroupLayout(this);
        setLayout(addAssignmentPanelLayout);
        addAssignmentPanelLayout.setHorizontalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addAssignmentHeaderLabel)
                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(informationLabel))
                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(pointsEarnedLabel)
                                                                                .addComponent(assignmentNameTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                                .addComponent(studentNameLabel)
                                                                                .addComponent(pointsEarnedTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                                .addComponent(assignmentNameLabel1)
                                                                                .addComponent(commentsLabel)
                                                                                .addComponent(dateLabel)
                                                                                .addComponent(dateTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(maximumPointsTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(assignmentNameDropdown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                        .addComponent(maximumPointsLabel)))
                                                                .addComponent(commentsTextField, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                                                                .addComponent(studentNameDropdown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(78, 78, 78))
        );
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addAssignmentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addComponent(studentNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentNameDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(assignmentNameLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(assignmentNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(assignmentNameDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pointsEarnedLabel)
                                        .addComponent(maximumPointsLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(pointsEarnedTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maximumPointsTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(commentsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentsTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(883, Short.MAX_VALUE))
        );
    }
}
