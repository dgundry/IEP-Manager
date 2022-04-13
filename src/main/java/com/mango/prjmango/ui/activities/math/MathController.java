package com.mango.prjmango.ui.activities.math;

import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.math.container.MathEquationContainer;
import com.mango.prjmango.ui.activities.math.container.MathEquationContainerController;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class MathController {

    public MathController(MathView view) {
        JLabel beginPracticeLabel = view.getBeginPracticeLabel();

        beginPracticeLabel.addMouseListener(new BeginPracticeMouseListener(view, beginPracticeLabel));
    }

    private static class BeginPracticeMouseListener implements MouseListener {

        private final MathView view;
        private final JLabel label;

        public BeginPracticeMouseListener(MathView view, JLabel label) {
            this.view  = view;
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            String enterNumericRange = "Please enter a numeric range.";
            view.getEnterAssignmentNameInfoLabel().setText(" ");
            view.getSelectStudentInfoLabel().setText(" ");
            view.getNumeratorRangeInfoLabel().setText(" ");
            view.getDenominatorRangeInfoLabel().setText(" ");

            String assignmentName = view.getNameOfAssignmentTextField().getText().trim();
            if (assignmentName.length() == 0) {
                view.getEnterAssignmentNameInfoLabel().setText("Please enter an assignment name.");
                return;
            }

            Student student;
            if (view.getStudentsComboBox().getItemCount() == 0) {
                view.getSelectStudentInfoLabel().setText("Please select a student.");
                return;
            } else {
                student = (Student) view.getStudentsComboBox().getSelectedItem();
            }

            int additionTotal = 0;
            String additionCurrText = view.getAdditionTextField().getText().trim();
            if (additionCurrText.length() != 0) {
                additionTotal = Integer.parseInt(additionCurrText);
            }

            int subtractionTotal = 0;
            String subtractionCurrText = view.getSubtractionTextField().getText().trim();
            if (subtractionCurrText.length() != 0) {
                subtractionTotal = Integer.parseInt(subtractionCurrText);
            }

            int multiplicationTotal = 0;
            String multiplicationCurrText = view.getMultiplicationTextField().getText().trim();
            if (multiplicationCurrText.length() != 0) {
                multiplicationTotal = Integer.parseInt(multiplicationCurrText);
            }

            int divisionTotal = 0;
            String divisionCurrText = view.getDivisionTextField().getText().trim();
            if (divisionCurrText.length() != 0) {
                divisionTotal = Integer.parseInt(divisionCurrText);
            }

            int numeratorMin;
            String numeratorMinCurrText = view.getNumeratorMinValueTextField().getText().trim();
            if (numeratorMinCurrText.length() == 0) {
                view.getNumeratorRangeInfoLabel().setText(enterNumericRange);
                return;
            } else {
                numeratorMin = Integer.parseInt(numeratorMinCurrText);
            }

            int numeratorMax;
            String numeratorMaxCurrText = view.getNumeratorMaxValueTextField().getText().trim();
            if (numeratorMaxCurrText.length() == 0) {
                view.getNumeratorRangeInfoLabel().setText(enterNumericRange);
                return;
            } else {
                numeratorMax = Integer.parseInt(numeratorMaxCurrText);
            }
            if(numeratorMin > numeratorMax) {
                view.getNumeratorRangeInfoLabel().setText("Min value has to be less than or equal to Max.");
                return;
            }

            int denominatorMin;
            String denominatorMinCurrText = view.getDenominatorMinValueTextField().getText().trim();
            if (denominatorMinCurrText.length() == 0) {
                view.getDenominatorRangeInfoLabel().setText(enterNumericRange);
                return;
            } else {
                denominatorMin = Integer.parseInt(denominatorMinCurrText);
            }

            int denominatorMax;
            String denominatorMaxCurrText = view.getDenominatorMaxValueTextField().getText().trim();
            if (denominatorMaxCurrText.length() == 0) {
                view.getDenominatorRangeInfoLabel().setText(enterNumericRange);
                return;
            } else {
                denominatorMax = Integer.parseInt(denominatorMaxCurrText);
            }
            if(denominatorMin > denominatorMax) {
                view.getDenominatorRangeInfoLabel().setText("Min value has to be less than or equal to Max.");
                return;
            }

            if(additionTotal + subtractionTotal + multiplicationTotal + divisionTotal <= 0) {
                view.getSelectStudentInfoLabel().setText("Please enter a positive number for at least one of the fields.");
            }

            MathAssignment assignment = new MathAssignment(
                    assignmentName,
                    student,
                    additionTotal,
                    subtractionTotal,
                    multiplicationTotal,
                    divisionTotal,
                    numeratorMin,
                    numeratorMax,
                    denominatorMin,
                    denominatorMax,false);

            int numberOfQuestions = assignment.getNumberOfQuestions();

            MathEquationContainer view = new MathEquationContainer(assignmentName, numberOfQuestions, assignment.isWholeNumbers());
            new MathEquationContainerController(view, assignment);
            ActivitiesView.setActiveDisplay(view);
            view.getAnswerTextField().requestFocus();
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.BEGIN_PRACTICE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.BEGIN_PRACTICE_NO_HOVER.getImageIcon());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }
}
