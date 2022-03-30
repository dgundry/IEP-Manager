package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Students;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class ViewStudentController {
    public ViewStudentController(ViewStudentView view){
        populateTable(view);


    }
    private void populateTable(ViewStudentView view){
//        String query = "SELECT student_id, first_name, last_name, grade, bio FROM student WHERE teacher_id = ?;";
//        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)){
//            statement.setInt(1, LoggedInUser.getTeacherId());
//            ResultSet set = statement.executeQuery();
//            do{
//                try {
//                    Student s = new Student(set.getInt(1), set.getString(2),
//                            set.getString(3), set.getString(4), set.getString(5));
//                    view.getModel().addRow(new Object[]{s.getStudentID(), s.getFirstName(), s.getLastName(), s.getGrade(), s.getBio()});
//                } catch (Exception e){
//                    System.out.println("No Students");
//                }
//                }while(set.next());
//            if(view.getModel().getRowCount() > 1){
//                view.getModel().removeRow(0);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        Students temp = Main.getStudents();
        for(int i = 0; i < temp.getStudents().size(); i++){
                    view.getModel().addRow(new Object[]{temp.getStudents().get(i).getStudentID(), temp.getStudents().get(i).getFirstName(), temp.getStudents().get(i).getLastName(), temp.getStudents().get(i).getGrade(), temp.getStudents().get(i).getBio()});
        }
        view.getStudentTable().getColumn("View").setCellRenderer(new ButtonRenderer());
        view.getStudentTable().getColumn("View").setCellEditor(new ButtonEditor(new JTextField(), view));

    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(){
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value==null) ? "VIEW":value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private Boolean clicked;

        public ButtonEditor(JTextField textField, ViewStudentView view) {
            super(textField);

            button=new JButton();
            button.setOpaque(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("View pressed for student: " + view.getModel().getValueAt(view.getStudentTable().getSelectedRow(),0)); //view.getStudentTable().getSelectedRow());
                }
            });
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
                                                     boolean selected, int row, int col) {

            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
            label=(obj==null) ? "VIEW":obj.toString();
            button.setText(label);
            clicked=true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {

            clicked=false;
            return new String(label);
        }

        @Override
        public boolean stopCellEditing() {
            clicked=false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            // TODO Auto-generated method stub
            super.fireEditingStopped();
        }
    }
}
