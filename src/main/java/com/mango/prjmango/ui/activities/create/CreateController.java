package com.mango.prjmango.ui.activities.create;

import com.mango.prjmango.Main;
import com.mango.prjmango.Outlines.Outlines;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.upload.UploadController;
import com.mango.prjmango.ui.activities.upload.UploadView;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.create.CreateStudentView;
import com.mango.prjmango.utilities.DatabaseCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

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
        JTextField nameField = view.getAssignmentNameTextField();

        nameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent event) {
                String value = nameField.getText();
                int length = value.length();
                if(length <= 20) {
                    nameField.setEditable(true);
                }else if(event.getKeyChar() == 8) {
                    nameField.setEditable(true);
                    nameField.setText(nameField.getText().toString().substring(0, length - 1));
                }else{
                    nameField.setEditable(false);
                }
            }
        });
        nameField.addMouseListener(new nameFieldMouseListener(view));
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
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.EDIT_PROFILE_SAVE_HOVERED.getImageIcon());
        }


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

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            view.getMaximumPointsTextField().setEditable(true);
            view.getMaximumPointsTextField().requestFocusInWindow();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    private class nameFieldMouseListener implements MouseListener {
        CreateView view;
        public nameFieldMouseListener(CreateView view) {
            this.view = view;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            view.getAssignmentNameTextField().setEditable(true);
            view.getAssignmentNameTextField().requestFocusInWindow();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
