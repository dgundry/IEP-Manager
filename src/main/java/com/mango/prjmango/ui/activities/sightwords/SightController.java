package com.mango.prjmango.ui.activities.sightwords;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.ui.activities.ActivitiesView;
import com.mango.prjmango.ui.activities.CreateAssignment;
import com.mango.prjmango.ui.activities.dolch.DolchWords;
import com.mango.prjmango.ui.activities.fry.FryWords;
import com.mango.prjmango.ui.activities.sightwords.assignment.SightAssignmentController;
import com.mango.prjmango.ui.activities.sightwords.assignment.SightAssignmentView;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class SightController {
    public SightController(SightView view){
        JLabel beginLabel = view.getBeginLabel();
        beginLabel.addMouseListener(new SightController.BeginLabelMouseListener(view, beginLabel));
    }
    private static class BeginLabelMouseListener implements MouseListener {

        private final SightView view;
        private final JLabel label;

        public BeginLabelMouseListener(SightView view, JLabel label) {
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
            int selectedIndex = view.getSightWordComboBox().getSelectedIndex();
            CreateAssignment assignment = new CreateAssignment((Student) view.getStudentsNameComboBox().getSelectedItem(),
                    view.getSightWordComboBox().getSelectedItem().toString(),
                    LoggedInUser.getActivitiesSubTabIndex() == 1 ? Main.SIGHT_WORDS.getFryQuestions(selectedIndex) : Main.SIGHT_WORDS.getDolchQuestions(selectedIndex));
            SightAssignmentView view = new SightAssignmentView(LoggedInUser.getActivitiesSubTabIndex() == 1 ? FryWords.values()[selectedIndex].toString() : DolchWords.values()[selectedIndex].toString(), assignment);
            new SightAssignmentController(view);
            ActivitiesView.setActiveDisplay(view);
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
