package com.mango.prjmango.ui.students;

import com.mango.prjmango.Main;
import com.mango.prjmango.assignment.Assignment;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.view.ViewStudentController;
import com.mango.prjmango.ui.students.view.ViewStudentView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

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
                System.out.println("Got HERE");
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
        view.getAssignmentsTable().getColumn("Delete").setCellEditor(new DeleteButtonEditor(view, new JCheckBox()));
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

        public DeleteButtonEditor(ReportsView view, JCheckBox checkBox) {
            super(checkBox);
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
