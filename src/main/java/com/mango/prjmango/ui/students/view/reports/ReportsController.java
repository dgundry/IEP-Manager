package com.mango.prjmango.ui.students.view.reports;

import com.mango.prjmango.Main;
import com.mango.prjmango.assignment.Assignment;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ReportsController {

    private static int student_id;

    public ReportsController(ReportsView view, int student_id){
        this.student_id = student_id;
        populateTable(view, Main.getAssignments().getAssignments());
        System.out.println("Student id: "+student_id);

    }

    private static void populateTable(ReportsView view, List<Assignment> assignments){
        for(Assignment assignment : assignments) {
            if (assignment.getStudentID() == student_id) {
                view.getModel().addRow(new Object[]{
                        assignment.getAssignmentID(),
                        assignment.getTitle(),
                        assignment.getEarnedPoints(),
                        assignment.getTotalPoints(),
                        assignment.getDate(),
                        assignment.getComment()});
            }
        }
        view.getAssignmentsTable().getColumn("Delete").setCellRenderer(new DeleteButtonRenderer());
        view.getAssignmentsTable().getColumn("Delete").setCellEditor(new DeleteButtonEditor(view, new JCheckBox(), student_id));
    }
    private static class DeleteButtonRenderer extends DefaultTableCellRenderer {
        JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            label = new JLabel(ImageIcons.DELETE_TRASH.getImageIcon());
            return label;
        }
    }

    private static class DeleteButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private final ReportsView view;
        private final int students_id;

        public DeleteButtonEditor(ReportsView view, JCheckBox checkBox, int student_id) {
            super(checkBox);
            this.students_id = student_id;
            this.view = view;
            button = new JButton();
            button.setOpaque(false);
            button.setBackground(null);
            button.setBorder(null);
            button.setContentAreaFilled(false);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if(isSelected){
//                System.out.println("Selected");

            }else{
//                System.out.println("Not Selected");
            }
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                System.out.println(view.getModel().getValueAt(view.getAssignmentsTable().getSelectedRow(),0) +" was Clicked");
                int assignment_id = (int) view.getModel().getValueAt(view.getAssignmentsTable().getSelectedRow(),0);
                String assignment_title = (String) view.getModel().getValueAt(view.getAssignmentsTable().getSelectedRow(),1);
                ConfirmationView confirmationView =
                        new ConfirmationView("Are you sure you'd like to delete \n" + assignment_title, Dialogs.DELETE_ASSIGNMENT);
                new ConfirmationController(confirmationView,students_id,assignment_id);
                confirmationView.requestFocusInWindow();
//                ReportsView reportsView = new ReportsView();
//                new ReportsController();
//                StudentsView.setActiveDisplay(reportsView);
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
}
