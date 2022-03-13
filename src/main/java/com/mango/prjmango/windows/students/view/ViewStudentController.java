package com.mango.prjmango.windows.students.view;

import com.mango.prjmango.Main;
import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
public class ViewStudentController {
    public ViewStudentController(ViewStudentView view){
        populateTable(view);


    }
    private void populateTable(ViewStudentView view){
        String query = "SELECT student_id, first_name, last_name, grade, bio FROM student;";
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(query)){
            ResultSet set = statement.executeQuery();
            do{
                Student s = new Student(set.getInt(1), set.getString(2),
                        set.getString(3), set.getString(4), set.getString(5));
                view.getModel().addRow(new Object[] {s.getFirstName(), s.getLastName(), s.getGrade(), s.getBio()});
            }while(set.next());
            view.getModel().removeRow(0);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
