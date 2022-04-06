package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.common.limitedtextfield.FilterType;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedComboBox;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Math page.
 */
public class MathView extends JPanel {

    private JPanel numericRangePanel;

    private JLabel mathEquationsHeaderLabel;
    private JLabel studentNameLabel;
    private JLabel numOfOperationsLabel;
    private JLabel additionLabel;
    private JLabel subtractionLabel;
    private JLabel multiplicationLabel;
    private JLabel divisionLabel;
    private JLabel nameOfAssignmentLabel;
    private JLabel selectCustomNumericRangeLabel;
    private JLabel numeratorLabel;
    private JLabel denominatorLabel;
    private JLabel numeratorSeparatorLabel;
    private JLabel denominatorSeparatorLabel;

    @Getter private JLabel selectStudentInfoLabel;
    @Getter private JLabel enterAssignmentNameInfoLabel;
    @Getter private JLabel numeratorRangeInfoLabel;
    @Getter private JLabel denominatorRangeInfoLabel;
    @Getter private JLabel beginPracticeLabel;

    @Getter private JTextField additionTextField;
    @Getter private JTextField subtractionTextField;
    @Getter private JTextField multiplicationTextField;
    @Getter private JTextField divisionTextField;
    @Getter private JTextField nameOfAssignmentTextField;
    @Getter private JTextField numeratorMinValueTextField;
    @Getter private JTextField numeratorMaxValueTextField;
    @Getter private JTextField denominatorMinValueTextField;
    @Getter private JTextField denominatorMaxValueTextField;

    @Getter private JComboBox<Student> studentsComboBox;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public MathView() {
        setOpaque(false);

        createComponents();
        createNumericRangePanelLayout();
        createLayout();
    }

    private void createComponents() {
        numericRangePanel = new JPanel();
        numericRangePanel.setOpaque(false);

        mathEquationsHeaderLabel = Components.JLabel(
                "Mathematics Equations",
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        studentNameLabel = Components.JLabel(
                "Student Name",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        numOfOperationsLabel = Components.JLabel(
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
        nameOfAssignmentLabel = Components.JLabel(
                "Name of Assignment",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        selectCustomNumericRangeLabel = Components.JLabel(
                "Select Custom Numeric Range",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        nameOfAssignmentLabel = Components.JLabel(
                "Name of Assignment",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        numeratorLabel = Components.JLabel(
                "Numerator",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        denominatorLabel = Components.JLabel(
                "Denominator",
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        selectStudentInfoLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        enterAssignmentNameInfoLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        numeratorRangeInfoLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);
        denominatorRangeInfoLabel = Components.JLabel(
                " ",
                Fonts.SEGOE_UI_12.getFont(),
                Colors.RED,
                SwingConstants.CENTER);

        beginPracticeLabel        = new JLabel(ImageIcons.BEGIN_PRACTICE_NO_HOVER.getImageIcon());
        numeratorSeparatorLabel   = new JLabel(ImageIcons.SEPARATOR.getImageIcon());
        denominatorSeparatorLabel = new JLabel(ImageIcons.SEPARATOR.getImageIcon());

        try {
            additionTextField            = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            subtractionTextField         = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            multiplicationTextField      = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            divisionTextField            = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            numeratorMinValueTextField   = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            numeratorMaxValueTextField   = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            denominatorMinValueTextField = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
            denominatorMaxValueTextField = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        nameOfAssignmentTextField = Components.JTextField();

        studentsComboBox = new RoundedComboBox<>(Main.getStudents().getStudents());
    }

    private void createNumericRangePanelLayout() {
        GroupLayout numericRangePanelLayout = new GroupLayout(numericRangePanel);
        numericRangePanel.setLayout(numericRangePanelLayout);
        numericRangePanelLayout.setHorizontalGroup(
                numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(numericRangePanelLayout.createSequentialGroup()
                                .addComponent(numeratorMinValueTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numeratorSeparatorLabel)
                                .addGap(41, 41, 41)
                                .addComponent(numeratorMaxValueTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGroup(numericRangePanelLayout.createSequentialGroup()
                                .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(numeratorLabel)
                                        .addComponent(denominatorLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(numericRangePanelLayout.createSequentialGroup()
                                .addComponent(denominatorMinValueTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(denominatorSeparatorLabel)
                                .addGap(41, 41, 41)
                                .addComponent(denominatorMaxValueTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, numericRangePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(numeratorRangeInfoLabel, GroupLayout.Alignment.TRAILING)
                                        .addComponent(denominatorRangeInfoLabel, GroupLayout.Alignment.TRAILING)))
        );
        numericRangePanelLayout.setVerticalGroup(
                numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(numericRangePanelLayout.createSequentialGroup()
                                .addComponent(numeratorLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(numeratorMinValueTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(numeratorMaxValueTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(numeratorSeparatorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeratorRangeInfoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(denominatorLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(numericRangePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(denominatorMinValueTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(denominatorMaxValueTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(denominatorSeparatorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(denominatorRangeInfoLabel)
                                .addContainerGap())
        );
    }

    private void createLayout() {
        GroupLayout mathPanelLayout = new GroupLayout(this);
        setLayout(mathPanelLayout);
        mathPanelLayout.setHorizontalGroup(
                mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(selectStudentInfoLabel)
                                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(mathEquationsHeaderLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(studentNameLabel, GroupLayout.Alignment.LEADING)
                                                                        .addComponent(studentsComboBox, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(numOfOperationsLabel)
                                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                                .addComponent(additionTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(additionLabel))
                                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                                .addComponent(subtractionTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(subtractionLabel))
                                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                                .addComponent(multiplicationTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(multiplicationLabel))
                                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                                .addComponent(divisionTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(divisionLabel)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nameOfAssignmentTextField, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                        .addComponent(nameOfAssignmentLabel)
                                                        .addComponent(enterAssignmentNameInfoLabel, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(selectCustomNumericRangeLabel)
                                                        .addComponent(numericRangePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                .addComponent(beginPracticeLabel)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        mathPanelLayout.setVerticalGroup(
                mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mathEquationsHeaderLabel)
                                .addGap(67, 67, 67)
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentNameLabel)
                                        .addComponent(nameOfAssignmentLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentsComboBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameOfAssignmentTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectStudentInfoLabel)
                                        .addComponent(enterAssignmentNameInfoLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numOfOperationsLabel)
                                        .addComponent(selectCustomNumericRangeLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mathPanelLayout.createSequentialGroup()
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(additionTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(additionLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(subtractionTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(subtractionLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(multiplicationTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(multiplicationLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mathPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(divisionTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(divisionLabel)))
                                        .addComponent(numericRangePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(beginPracticeLabel)
                                .addContainerGap(466, Short.MAX_VALUE))
        );
    }
}
