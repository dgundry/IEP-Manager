package com.mango.prjmango.ui.activities.create;

import com.mango.prjmango.Main;
import com.mango.prjmango.outlines.MathOutline;
import com.mango.prjmango.outlines.MathOutlines;
import com.mango.prjmango.outlines.Outlines;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateController {
    public CreateController(CreateView view) {
        JLabel saveLabel = view.getSaveLabel();
        JLabel saveLabelMath = view.getSaveLabel2();
        JTextField maximumField = view.getMaximumPointsTextField();
        saveLabel.addMouseListener(new SaveAssignmentMouseListener(view, saveLabel));
        saveLabelMath.addMouseListener(new SaveAssignmentMathMouseListener(view, saveLabelMath));
    }

    private static class SaveAssignmentMouseListener implements MouseListener {

        private final CreateView view;
        private final JLabel label;

        public SaveAssignmentMouseListener(CreateView view, JLabel label) {
            this.view = view;
            this.label = label;

        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        public void mouseClicked(MouseEvent e){
            view.getInformationLabel().setText("");

            String assignmentNameTextField = view.getAssignmentNameTextField().getText().trim();
            String maximumPointsTextField = view.getMaximumPointsTextField().getText().trim();

            if (assignmentNameTextField.equals("") || maximumPointsTextField.equals("")) {
                view.getInformationLabel().setText("Please fill in all fields");
                view.getInformationLabel().setForeground(Color.RED);
            } else {
                DatabaseCommands.createOutline(assignmentNameTextField, Integer.parseInt(maximumPointsTextField));
                view.getInformationLabel().setForeground(Color.GREEN);
                view.getInformationLabel().setText("Assignment created successfully");

                view.getAssignmentNameTextField().setText("");
                view.getMaximumPointsTextField().setText("");
                view.getAssignmentNameTextField().requestFocus();

                Main.setOutlines(new Outlines(Main.getActiveUser().getTeacherId()));
                Main.setMathOutlines(new MathOutlines(Main.getActiveUser().getTeacherId()));
            }

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

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        }
        private static boolean isBlank(String str) {
            return str.equals("");
        }

    }

    private static class SaveAssignmentMathMouseListener implements MouseListener {

        private final CreateView view;
        private final JLabel label;

        public SaveAssignmentMathMouseListener(CreateView view, JLabel label) {
            this.view = view;
            this.label = label;

        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        public void mouseClicked(MouseEvent e){
           //save math outline

            if(view.getAssignmentNameTextField2().getText().trim().equals("")) {
                view.getInformationLabel2().setForeground(Color.RED);
                view.getInformationLabel2().setText("Please enter a name for the assignment");

            } else if(view.getNumeratorMinField().getText().trim().equals("") || view.getNumeratorMaxField().getText().trim().equals("") || view.getDenominatorMinField().getText().trim().equals("") || view.getDenominatorMaxField().getText().trim().equals("")) {
                view.getInformationLabel2().setForeground(Color.RED);
                view.getInformationLabel2().setText("Please enter a range for the numerator and denominator");
            }else{
                String assignmentName = view.getAssignmentNameTextField2().getText().trim();
                int additionTotal;
                int subtractionTotal;
                int multiplicationTotal;
                int divisionTotal;
                int numeratorMin = Integer.parseInt(view.getNumeratorMinField().getText());
                int numeratorMax = Integer.parseInt(view.getNumeratorMaxField().getText());
                int denominatorMin = Integer.parseInt(view.getDenominatorMinField().getText());
                int denominatorMax = Integer.parseInt(view.getDenominatorMaxField().getText());
                int wholeNumbers = view.getWholeNumberComboBox().getSelectedIndex();
                if(view.getAdditionField().getText().trim().equals("")){
                    additionTotal = 0;
                }else{
                    additionTotal = Integer.parseInt(view.getAdditionField().getText());
                }
                if(view.getSubtractionField().getText().trim().equals("")){
                    subtractionTotal = 0;
                }else{
                    subtractionTotal = Integer.parseInt(view.getSubtractionField().getText());
                }
                if(view.getMultiplicationField().getText().trim().equals("")){
                    multiplicationTotal = 0;
                }else{
                    multiplicationTotal = Integer.parseInt(view.getMultiplicationField().getText());
                }
                if(view.getDivisionField().getText().trim().equals("")){
                    divisionTotal = 0;
                }else{
                    divisionTotal = Integer.parseInt(view.getDivisionField().getText());
                }
                MathOutline outline = new MathOutline(assignmentName,additionTotal,subtractionTotal,multiplicationTotal,divisionTotal,numeratorMin,numeratorMax,denominatorMin,denominatorMax,wholeNumbers);
                DatabaseCommands.createMathOutline(outline);
                Main.setMathOutlines(new MathOutlines(Main.getActiveUser().getTeacherId()));
                view.getInformationLabel2().setForeground(Color.GREEN);
                view.getInformationLabel2().setText("Math Outline created");

                view.getAssignmentNameTextField2().setText("");
                view.getAdditionField().setText("");
                view.getSubtractionField().setText("");
                view.getMultiplicationField().setText("");
                view.getDivisionField().setText("");
                view.getNumeratorMinField().setText("");
                view.getNumeratorMaxField().setText("");
                view.getDenominatorMinField().setText("");
                view.getDenominatorMaxField().setText("");
                view.getWholeNumberComboBox().setSelectedIndex(0);
            }

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

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        }
        private static boolean isBlank(String str) {
            return str.equals("");
        }

    }

}
