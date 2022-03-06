package com.mango.prjmango.windows.activities.fry;

import com.mango.prjmango.windows.activities.ActivitiesView;
import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentController;
import com.mango.prjmango.windows.activities.fry.assignment.FryAssignmentView;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class FryController {

    public FryController(FryView view) {
        //view.startFryButton().addActionListener(new StartFryActionListener());
        JLabel beginLabel = view.getBeginLabel();

        beginLabel.addMouseListener(new BeginLabelMouseListener(view, beginLabel));
    }

    private static class BeginLabelMouseListener implements MouseListener {

        private final FryView view;
        private final JLabel label;

        public BeginLabelMouseListener(FryView view, JLabel label) {
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
            int selectedIndex = view.getFrySightWordComboBox().getSelectedIndex();
            FryAssignmentView view = new FryAssignmentView(SightWords.values()[selectedIndex].toString());
            new FryAssignmentController(view);
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
//    private static class StartFryActionListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            SightWords questions = new SightWords();
//            CreateAssignment assignment = new CreateAssignment(view.getStudentNameField(),view.getAssignmentNameField(),questions.getFryQuestions(view.getQuestionsComboBox()));
//            AssignmentView assignmentView = new AssignmentView(assignment);
//            MainFrame.setTeacherView(assignmentView);
//        }
//    }
}
