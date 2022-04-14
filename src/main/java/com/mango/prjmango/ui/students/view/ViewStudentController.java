package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.student.StudentSortTypes;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.common.ImageIcons;
import com.mango.prjmango.ui.students.StudentsController;
import com.mango.prjmango.ui.students.view.reports.ReportsController;
import com.mango.prjmango.ui.students.view.reports.ReportsView;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.utilities.dbcommands.StudentCommands;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewStudentController {

    public ViewStudentController(ViewStudentView view) {
        populateTable(view, Main.getStudents().getStudents());

        JTextField searchTextField = view.getSearchTextBox();
        searchTextField.addKeyListener(new SearchTextBoxKeyListener(view, view.getModel(), searchTextField));

        JTableHeader header = view.getStudentTable().getTableHeader();
        header.addMouseListener(new StudentsTableMouseListener(view, view.getStudentTable(), view.getModel(), header));
    }

    private static void populateTable(ViewStudentView view, List<Student> students) {
        for (Student student : students) {
            view.getModel().addRow(new Object[]{
                    student.getStudentID(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getGrade(),
                    student.getBio()});
        }
        view.getStudentTable().getColumn("View").setCellRenderer(new ViewButtonRenderer());
        view.getStudentTable().getColumn("View").setCellEditor(new ViewButtonEditor(view, new JCheckBox()));

        view.getStudentTable().getColumn("Delete").setCellRenderer(new DeleteButtonRenderer());
        view.getStudentTable().getColumn("Delete").setCellEditor(new DeleteButtonEditor(view, new JCheckBox()));
    }

    private static class ViewButtonRenderer extends DefaultTableCellRenderer {
        JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            label = new JLabel(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
            return label;
        }
    }

    private static class ViewButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private final ViewStudentView view;

        public ViewButtonEditor(ViewStudentView view, JCheckBox checkBox) {
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
                System.out.println(view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0) +" was Clicked");
                String fullName = view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),2) +", "+ view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),1);
                ReportsView reportsView = new ReportsView(fullName);
                new ReportsController(reportsView, (Integer) view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0));
                StudentsView.setActiveDisplay(reportsView);
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
        private final ViewStudentView view;

        public DeleteButtonEditor(ViewStudentView view, JCheckBox checkBox) {
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
                System.out.println(view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0) +" was Clicked");
                int studentID = (Integer) view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0);
                StudentCommands.deleteStudentAndAssignments(studentID);
                Main.setStudents(new Students(Main.getActiveUser().getTeacherId()));
                ViewStudentView viewStudent = new ViewStudentView();
                new ViewStudentController(viewStudent);
                StudentsView.setActiveDisplay(viewStudent);
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

    private static class SearchTextBoxKeyListener implements KeyListener {

        private final ViewStudentView view;
        private final DefaultTableModel model;
        private final JTextField searchTextField;

        public SearchTextBoxKeyListener(ViewStudentView view, DefaultTableModel model, JTextField searchTextField) {
            this.view  = view;
            this.model = model;
            this.searchTextField = searchTextField;
        }

        /**
         * Invoked when a key has been typed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key typed event.
         *
         * @param e the {@link KeyEvent}
         */
        @Override
        public void keyTyped(KeyEvent e) {
            //TODO will implement search functionality in future commit
        }

        /**
         * Invoked when a key has been pressed.
         * See the class description for {@link KeyEvent} for a definition of
         * a key pressed event.
         *
         * @param e the {@link KeyEvent}
         */
        @Override
        public void keyPressed(KeyEvent e) { /* Not needed */ }

        /**
         * Invoked when a key has been released.
         * See the class description for {@link KeyEvent} for a definition of
         * a key released event.
         *
         * @param e the {@link KeyEvent}
         */
        @Override
        public void keyReleased(KeyEvent e) { /* Not needed */ }
    }

    private static void clearTable(DefaultTableModel model) {
        model.setRowCount(0);
    }

    private static class StudentsTableMouseListener implements MouseListener {

        private final ViewStudentView view;
        private final JTable table;
        private final DefaultTableModel model;
        private final JTableHeader header;

        /**
         * Constructor. Initializes instance variables that will be used throughout the {@link MouseListener}
         * methods.
         *
         * @param view   the {@link ViewStudentView} instance
         * @param table  the {@link JTable}
         * @param model  the {@link DefaultTableModel} of the specific {@link JTable}
         * @param header the {@link JTableHeader} of the specific {@link JTable}
         */
        public StudentsTableMouseListener(
                ViewStudentView view,
                JTable table,
                DefaultTableModel model,
                JTableHeader header) {
            this.view   = view;
            this.table  = table;
            this.model  = model;
            this.header = header;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            int col = header.columnAtPoint(e.getPoint());
            String name = table.getColumnName(col);

            List<Student> students;
            switch (name) {
                case "First Name":
                    students = Main.getStudents().getStudents();
                    students.sort(StudentSortTypes.FIRST_NAME.getComparator());
                    clearTable(model);
                    populateTable(view, students);
                    break;
                case "Last Name":
                    students = Main.getStudents().getStudents();
                    students.sort(StudentSortTypes.LAST_NAME.getComparator());
                    clearTable(model);
                    populateTable(view, students);
                    break;
                case "Grade":
                    students = Main.getStudents().getStudents();
                    students.sort(StudentSortTypes.GRADE.getComparator());
                    clearTable(model);
                    populateTable(view, students);
                    break;
                case "Bio":
                    students = Main.getStudents().getStudents();
                    students.sort(StudentSortTypes.BIO.getComparator());
                    clearTable(model);
                    populateTable(view, students);
                    break;
                default:
                    break;
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
