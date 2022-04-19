package com.mango.prjmango.ui.activities.create;

import com.mango.prjmango.Main;
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
        JTextField maximumField = view.getMaximumPointsTextField();
        maximumField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                String value = maximumField.getText();
                int length = value.length();
                if((event.getKeyChar() >= '0' && event.getKeyChar() <= '9') || event.getKeyChar() == 8 || event.getKeyChar() == 46) {
                    maximumField.setEditable(true);
                }
                else{
                    maximumField.setEditable(false);
                }
            }
        });
        maximumField.addMouseListener(new maximumFieldMouseListener(view));
        saveLabel.addMouseListener(new SaveStudentMouseListener(view, saveLabel));
    }

    private static class SaveStudentMouseListener implements MouseListener {

        private final CreateView view;
        private final JLabel label;

        public SaveStudentMouseListener(CreateView view, JLabel label) {
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

    private class maximumFieldMouseListener implements MouseListener {
        CreateView view;
        public maximumFieldMouseListener(CreateView view) {
            this.view = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) {
            view.getMaximumPointsTextField().setEditable(true);
            view.getMaximumPointsTextField().requestFocusInWindow();
        }

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
        public void mouseEntered(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) { /* Not needed */ }
    }
}
