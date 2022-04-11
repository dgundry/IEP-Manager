package com.mango.prjmango.ui.activities.math.container;

import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.common.limitedtextfield.FilterType;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import lombok.Getter;

/**
 * The user interface design of the Math equation page.
 */
public class MathEquationContainer extends JPanel {

    @Getter private JLabel mathAssignmentNameLabel;
    @Getter private JLabel nextLabel;
    @Getter private JLabel currentNumberLabel;

    @Getter private JTextField answerTextField;

    private final String assignmentName;
    private final int numberOfQuestions;

    /**
     * Constructor. Calls methods that create the GUI.
     *
     * @param assignmentName    the name of the assignment
     * @param numberOfQuestions the number of questions
     */
    public MathEquationContainer(String assignmentName, int numberOfQuestions) {
        this.assignmentName = assignmentName;
        this.numberOfQuestions = numberOfQuestions;

        setOpaque(false);

        createComponents();
        setMathEquation(new JPanel());
    }

    private void createComponents() {
        nextLabel = new JLabel(ImageIcons.NEXT_NO_HOVER.getImageIcon());

        mathAssignmentNameLabel = Components.JLabel(
                assignmentName,
                Fonts.SEGOE_UI_24.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);
        currentNumberLabel = Components.JLabel(
                "1/" + numberOfQuestions,
                Fonts.SEGOE_UI_18.getFont(),
                Colors.LIGHT_GREY,
                SwingConstants.LEADING);

        try {
            answerTextField = Components.LimitedJTextField(FilterType.NUMBERS_ONLY, "", 5);
            answerTextField.setFont(Fonts.SEGOE_UI_50.getFont());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMathEquation(JPanel mathEquationPanel) {
        removeAll();
        GroupLayout mathAssignmentPanelLayout = new GroupLayout(this);
        setLayout(mathAssignmentPanelLayout);
        mathAssignmentPanelLayout.setHorizontalGroup(
                mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mathAssignmentNameLabel)
                                        .addComponent(currentNumberLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, mathAssignmentPanelLayout.createSequentialGroup()
                                .addGap(0, 265, Short.MAX_VALUE)
                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mathEquationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(answerTextField))
                                .addGap(28, 28, 28)
                                .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
        );
        mathAssignmentPanelLayout.setVerticalGroup(
                mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mathAssignmentNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentNumberLabel)
                                .addGap(57, 57, 57)
                                .addComponent(mathEquationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(mathAssignmentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(answerTextField, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                .addGap(1885, 1885, 1885))
                                        .addGroup(mathAssignmentPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(nextLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        updateUI();
    }
}
