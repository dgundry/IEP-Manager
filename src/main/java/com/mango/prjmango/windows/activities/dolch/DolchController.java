package com.mango.prjmango.windows.activities.dolch;

import com.mango.prjmango.Main;
import com.mango.prjmango.windows.activities.ActivitiesView;
import com.mango.prjmango.windows.activities.CreateAssignment;
import com.mango.prjmango.windows.activities.dolch.assignment.DolchAssignmentController;
import com.mango.prjmango.windows.activities.dolch.assignment.DolchAssignmentView;
import com.mango.prjmango.windows.activities.fry.FryController;
import com.mango.prjmango.windows.activities.fry.FryView;
import com.mango.prjmango.windows.activities.fry.FryWords;
import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentController;
import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentView;
import com.mango.prjmango.windows.common.ImageIcons;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DolchController {

    public DolchController(DolchView view) {
        JLabel beginLabel = view.getBeginLabel();

        beginLabel.addMouseListener(new DolchController.BeginLabelMouseListener(view, beginLabel));

    }
    private static class BeginLabelMouseListener implements MouseListener {

        private final DolchView view;
        private final JLabel label;

        public BeginLabelMouseListener(DolchView view, JLabel label) {
            this.label = label;
            this.view  = view;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedIndex = view.getDolchSightWordComboBox().getSelectedIndex();
            CreateAssignment assignment = new CreateAssignment(view.getStudentsNameComboBox().getSelectedItem().toString(),
                    view.getDolchSightWordComboBox().getSelectedItem().toString(),
                    Main.SIGTHT_WORDS.getDolchQuestions(selectedIndex));
            DolchAssignmentView view = new DolchAssignmentView(DolchWords.values()[selectedIndex].toString(), assignment);
            new DolchAssignmentController(view);
            ActivitiesView.setActiveDisplay(view);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_BEGIN_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(ImageIcons.FRY_BEGIN_NO_HOVER.getImageIcon());
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
