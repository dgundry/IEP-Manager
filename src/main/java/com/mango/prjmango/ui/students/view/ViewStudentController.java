package com.mango.prjmango.ui.students.view;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewStudentController {
    public ViewStudentController(ViewStudentView view){
        populateTable(view);


    }
    private void populateTable(ViewStudentView view){
        String query = "SELECT student_id, first_name, last_name, grade, bio FROM student WHERE teacher_id = ?;";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)){
            statement.setInt(1, LoggedInUser.getTeacherId());
            ResultSet set = statement.executeQuery();
            do{
                try {
                    Student s = new Student(set.getInt(1), set.getString(2),
                            set.getString(3), set.getString(4), set.getString(5));
                    view.getModel().addRow(new Object[]{s.getStudentID(), s.getFirstName(), s.getLastName(), s.getGrade(), s.getBio()});
                } catch (Exception e){
                    System.out.println("No Students");
                }
                }while(set.next());
            if(view.getModel().getRowCount() > 1){
                view.getModel().removeRow(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
