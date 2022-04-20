package com.mango.prjmango.ui.students.view.reports;

import com.mango.prjmango.Main;
import com.mango.prjmango.assignment.Assignment;
import com.mango.prjmango.assignment.Assignments;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationController;
import com.mango.prjmango.ui.dialogs.confirmation.ConfirmationView;
import com.mango.prjmango.ui.dialogs.confirmation.Dialogs;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.utilities.dbcommands.StudentCommands;
import lombok.SneakyThrows;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ReportsController {

    private static int student_id;

    public ReportsController(ReportsView view, int student_id) throws ParseException {
        this.student_id = student_id;
        populateTable(view, Main.getAssignments().getAssignments());
        createListeners(view);
    }
    public ReportsController(ReportsView view, int student_id, String fromDate, String toDate, int fromDateDayIndex, int fromDateMonthIndex, int fromDateYearIndex, int toDateDayIndex,int toDateMonthIndex, int toDateYearIndex) throws ParseException {
        this.student_id = student_id;
        view.getDateTextField1().setDates(fromDateDayIndex, fromDateMonthIndex, fromDateYearIndex);
        view.getDateTextField2().setDates(toDateDayIndex, toDateMonthIndex, toDateYearIndex);
        filterTable(view, Main.getAssignments().getAssignments(), fromDate, toDate);
        createListeners(view);
    }
    private void createListeners(ReportsView view) throws ParseException {
        view.getAssignmentsTable().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = view.getAssignmentsTable().rowAtPoint(evt.getPoint());
                int col = view.getAssignmentsTable().columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0 && col != 5) {
                    copyToClipBoard(view.getAssignmentsTable().getValueAt(row, col).toString());
                }
            }
        });
        view.getAssignmentsTable().getColumn("Delete").setCellRenderer(new DeleteButtonRenderer());
        view.getAssignmentsTable().getColumn("Delete").setCellEditor(new DeleteButtonEditor(view, new JCheckBox(), student_id));
        view.getDateTextField1().getDayComboBox().addItemListener(new FromDateListener(view));
        view.getDateTextField1().getMonthComboBox().addItemListener(new FromDateListener(view));
        view.getDateTextField1().getYearComboBox().addItemListener(new FromDateListener(view));
        view.getDateTextField2().getMonthComboBox().addItemListener(new ToDateListener(view));
        view.getDateTextField2().getDayComboBox().addItemListener(new ToDateListener(view));
        view.getDateTextField2().getYearComboBox().addItemListener(new ToDateListener(view));
        System.out.println("Student id: "+student_id);
    }
    private void copyToClipBoard(String copyText){
        if(copyText != null && !copyText.isEmpty()) {
            StringSelection stringSelection = new StringSelection(copyText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
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
    }
    private static void filterTable(ReportsView view, List<Assignment> assignments, String fromDate, String toDate){
        for(Assignment assignment : assignments) {
            if (assignment.getStudentID() == student_id && assignment.isBetween(fromDate, toDate)) {
                    view.getModel().addRow(new Object[]{
                            assignment.getAssignmentID(),
                            assignment.getTitle(),
                            assignment.getEarnedPoints(),
                            assignment.getTotalPoints(),
                            assignment.getDate(),
                            assignment.getComment()});
            }
        }
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

            }else{
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

    private class FromDateListener implements ItemListener {
        ReportsView view;
        String fromDate;
        String toDate;

        public FromDateListener(ReportsView view) throws ParseException {
            this.view = view;
            fromDate = view.getDateTextField1().getText();
            toDate = view.getDateTextField2().getText();
        }

        @SneakyThrows
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int fromDateDayIndex = view.getDateTextField1().getDayComboBox().getSelectedIndex();
                int fromDateMonthIndex = view.getDateTextField1().getMonthComboBox().getSelectedIndex();
                int fromDateYearIndex = view.getDateTextField1().getYearComboBox().getSelectedIndex();
                int toDateDayIndex = view.getDateTextField2().getDayComboBox().getSelectedIndex();
                int toDateMonthIndex = view.getDateTextField2().getMonthComboBox().getSelectedIndex();
                int toDateYearIndex = view.getDateTextField2().getYearComboBox().getSelectedIndex();
                ReportsView reportsView = new ReportsView(StudentCommands.getStudentFullName(student_id));
                new ReportsController(reportsView, student_id,view.getDateTextField1().getText(), view.getDateTextField2().getText(),fromDateDayIndex,fromDateMonthIndex,fromDateYearIndex,toDateDayIndex,toDateMonthIndex,toDateYearIndex);
                StudentsView.setActiveDisplay(reportsView);
            }
        }
    }

    private class ToDateListener implements ItemListener {
        ReportsView view;
        String fromDate;
        String toDate;

        public ToDateListener(ReportsView view) throws ParseException {
            this.view = view;
            fromDate = view.getDateTextField1().getText();
            toDate = view.getDateTextField2().getText();
        }

        @SneakyThrows
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int fromDateDayIndex = view.getDateTextField1().getDayComboBox().getSelectedIndex();
                int fromDateMonthIndex = view.getDateTextField1().getMonthComboBox().getSelectedIndex();
                int fromDateYearIndex = view.getDateTextField1().getYearComboBox().getSelectedIndex();
                int toDateDayIndex = view.getDateTextField2().getDayComboBox().getSelectedIndex();
                int toDateMonthIndex = view.getDateTextField2().getMonthComboBox().getSelectedIndex();
                int toDateYearIndex = view.getDateTextField2().getYearComboBox().getSelectedIndex();
                ReportsView reportsView = new ReportsView(StudentCommands.getStudentFullName(student_id));
                new ReportsController(reportsView, student_id,view.getDateTextField1().getText(), view.getDateTextField2().getText(),fromDateDayIndex,fromDateMonthIndex,fromDateYearIndex,toDateDayIndex,toDateMonthIndex,toDateYearIndex);
                StudentsView.setActiveDisplay(reportsView);


            }
        }
    }
}
