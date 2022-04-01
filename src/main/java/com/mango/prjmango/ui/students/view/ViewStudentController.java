package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.common.ImageIcons;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewStudentController {
    public ViewStudentController(ViewStudentView view){
        populateTable(view);


    }
    private void populateTable(ViewStudentView view){
        Students temp = Main.getStudents();
        for(int i = 0; i < temp.getStudents().size(); i++){
                    view.getModel().addRow(new Object[]{temp.getStudents().get(i).getStudentID(), temp.getStudents().get(i).getFirstName(), temp.getStudents().get(i).getLastName(), temp.getStudents().get(i).getGrade(), temp.getStudents().get(i).getBio()});
        }
        view.getStudentTable().getColumn("View").setCellRenderer(new ButtonRenderer());
        view.getStudentTable().getColumn("View").setCellEditor(new ButtonEditor(view, new JCheckBox()));
    }

    private class ButtonRenderer extends DefaultTableCellRenderer {
        JLabel label = new JLabel();
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            label = new JLabel(ImageIcons.PASSWORD_OPEN_EYE_NO_HOVER.getImageIcon());
            return label;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private ViewStudentView view;

        public ButtonEditor(ViewStudentView view, JCheckBox checkBox) {
            super(checkBox);
            this.view = view;
            button = new JButton();
            button.setOpaque(false);
            button.setBackground(null);
            button.setBorder(null);
            button.setContentAreaFilled(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if(isSelected){
                System.out.println("Selected");
            }else{
                System.out.println("Not Selected");
            }
            isPushed = true;
            return button;
        }
        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                System.out.println(view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0) +" was Clicked");
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
