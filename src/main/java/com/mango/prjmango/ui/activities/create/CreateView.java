package com.mango.prjmango.ui.activities.create;


import com.mango.prjmango.ui.activities.math.MathView;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import com.mango.prjmango.ui.common.limitedtextfield.FilterType;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedComboBox;
import lombok.Getter;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateView extends JPanel {

    private static final Logger logger = Logger.getLogger(MathView.class.getName());

    @Getter private JLabel addAssignmentHeaderLabel;
    @Getter private JTextField additionField;
    @Getter private JLabel additionLabel;
    @Getter private JLabel assignmentNameLabel;
    @Getter private JLabel assignmentNameLabel2;
    @Getter private JTextField assignmentNameTextField;
    @Getter private JTextField assignmentNameTextField2;
    @Getter private JLabel denominatorLabel;
    @Getter private JTextField denominatorMaxField;
    @Getter private JTextField denominatorMinField;
    @Getter private JTextField divisionField;
    @Getter private JLabel divisionLabel;
    @Getter private JLabel informationLabel;
    @Getter private JLabel informationLabel2;
    @Getter private JSeparator jSeparator1;
    @Getter private JLabel maximumPointsLabel;
    @Getter private JTextField maximumPointsTextField;
    @Getter private JTextField multiplicationField;
    @Getter private JLabel multiplicationLabel;
    @Getter private JLabel numeratorLabel;
    @Getter private JTextField numeratorMaxField;
    @Getter private JTextField numeratorMinField;
    @Getter private JLabel operationsLabel;
    @Getter private JLabel rangeLabel;
    @Getter private JSeparator rangeLine1;
    @Getter private JSeparator rangeLine2;
    @Getter private JLabel saveLabel;
    @Getter private JLabel saveLabel2;
    @Getter private JTextField subtractionField;
    @Getter private JLabel subtractionLabel;
    @Getter private JComboBox<String> wholeNumberComboBox;


    public CreateView(){
        setOpaque(false);

        createComponents();
        createLayout();
    }
    private void createComponents(){
        addAssignmentHeaderLabel = Components.JLabel("Create an Assignment", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        assignmentNameLabel = Components.JLabel("Assignment Name",      Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        maximumPointsLabel = Components.JLabel("Maximum Points",       Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);
        jSeparator1 = new JSeparator();
        assignmentNameLabel2 = Components.JLabel("Assignment Name",      Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);

        operationsLabel = Components.JLabel(
                "Enter Number of Operations",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        additionLabel = Components.JLabel(
                "Addition",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        subtractionLabel = Components.JLabel(
                "Subtraction",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        multiplicationLabel = Components.JLabel(
                "Multiplication",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        divisionLabel = Components.JLabel(
                "Division",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        rangeLabel = Components.JLabel(
                 "Numeric Ranges",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        wholeNumberComboBox    = new RoundedComboBox<>(Arrays.asList("Whole Numbers", "Nearest Hundredths"));
        numeratorLabel = Components.JLabel(
                "Numerator",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        rangeLine1 = new JSeparator();
        denominatorLabel = Components.JLabel(
                "Denominator",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        rangeLine2 = new JSeparator();

        try {
            additionField            = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            subtractionField         = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            multiplicationField      = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            divisionField            = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            numeratorMinField   = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            numeratorMaxField   = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            denominatorMinField = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            denominatorMaxField = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            maximumPointsTextField   = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 5);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        addAssignmentHeaderLabel = Components.JLabel("Create an Assignment", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        maximumPointsLabel       = Components.JLabel("Maximum Points",       Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        assignmentNameLabel     = Components.JLabel("Assignment Name",      Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);

        informationLabel       = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);
        informationLabel2 = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);


        saveLabel = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());
        saveLabel2 = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());


        try {
            assignmentNameTextField = Components.LimitedJTextField(FilterType.CHARACTERS_AND_NUMBERS, "", 32);
            assignmentNameTextField2 = Components.LimitedJTextField(FilterType.CHARACTERS_AND_NUMBERS, "", 32);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    public void createLayout() {
        GroupLayout mathAssignmentPanelLayout = new GroupLayout(this);
        setLayout(mathAssignmentPanelLayout);
        mathAssignmentPanelLayout.setHorizontalGroup(
                mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addAssignmentHeaderLabel)
                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(assignmentNameLabel2)
                                                        .addComponent(assignmentNameTextField2, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(operationsLabel)
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(additionField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(additionLabel))
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(subtractionField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(subtractionLabel))
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(divisionField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(divisionLabel))
                                                        .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(wholeNumberComboBox, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(GroupLayout.Alignment.LEADING, mathAssignmentPanelLayout.createSequentialGroup()
                                                                        .addComponent(multiplicationField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(multiplicationLabel)))
                                                        .addComponent(rangeLabel)
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(numeratorMinField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rangeLine1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(numeratorMaxField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(numeratorLabel)
                                                        .addComponent(denominatorLabel)
                                                        .addComponent(saveLabel2)
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(denominatorMinField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rangeLine2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(denominatorMaxField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(informationLabel2))
                                                .addGap(62, 62, 62)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(assignmentNameLabel)
                                                        .addComponent(assignmentNameTextField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(maximumPointsLabel)
                                                        .addComponent(maximumPointsTextField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(saveLabel)
                                                        .addComponent(informationLabel))))
                                .addContainerGap(268, Short.MAX_VALUE))
        );
        mathAssignmentPanelLayout.setVerticalGroup(
                mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addAssignmentHeaderLabel)
                                .addGap(67, 67, 67)
                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(numeratorMaxField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addComponent(assignmentNameLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(assignmentNameTextField2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(operationsLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(additionField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(additionLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(subtractionField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(subtractionLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(multiplicationField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(multiplicationLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(divisionField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(divisionLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(wholeNumberComboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rangeLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(numeratorLabel)
                                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(numeratorMinField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                                .addGap(19, 19, 19)
                                                                                .addComponent(rangeLine1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(denominatorLabel)
                                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(denominatorMaxField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(denominatorMinField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                                        .addGap(19, 19, 19)
                                                                        .addComponent(rangeLine2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addComponent(saveLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(informationLabel2))
                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                .addComponent(assignmentNameLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(assignmentNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(maximumPointsLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maximumPointsTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(saveLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(informationLabel))
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(1651, Short.MAX_VALUE))
        );
    }

}
