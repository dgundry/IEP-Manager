package com.mango.prjmango.ui.activities.create;

import com.mango.prjmango.Main;
import com.mango.prjmango.ui.common.*;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedComboBox;
import lombok.Getter;

import javax.swing.*;

public class CreateView extends JPanel {
    @Getter private JLabel addAssignmentHeaderLabel;
    @Getter private JLabel assignmentNameLabel1;
    @Getter private JLabel maximumPointsLabel;
    @Getter private JLabel saveLabel;

    @Getter private JLabel informationLabel;

    @Getter private JTextField assignmentNameTextField;
    @Getter private JTextField maximumPointsTextField;


    public CreateView(){
        setOpaque(false);

        createComponents();
        createLayout();
    }
    private void createComponents(){
        addAssignmentHeaderLabel = Components.JLabel("Create an Assignment", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        maximumPointsLabel       = Components.JLabel("Maximum Points",       Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        assignmentNameLabel1     = Components.JLabel("Assignment Name",      Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel       = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);

        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        assignmentNameTextField = Components.JTextField("");
        maximumPointsTextField  = Components.JTextField("");
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
                                                                                .addComponent(maximumPointsLabel)
                                                                                .addComponent(assignmentNameTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                                .addComponent(maximumPointsTextField, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                                .addComponent(assignmentNameLabel1))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(maximumPointsTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(maximumPointsLabel)))))))
                                .addGap(78, 78, 78))
        );
        addAssignmentPanelLayout.setVerticalGroup(
                addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addAssignmentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addComponent(assignmentNameLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assignmentNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maximumPointsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maximumPointsTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(addAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(883, Short.MAX_VALUE))
        );
    }

}
