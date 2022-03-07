package com.mango.prjmango.student;

import com.mango.prjmango.utilities.DatabaseConnection;
import lombok.Getter;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Students {
    @Getter ArrayList<Student> students = new ArrayList<Student>();
    @Getter Student[] testStudents = new Student[]{new Student(1,"first","last","bio")};
    private int teacher_id;
    public Students(int teacher_id){
        this.teacher_id = teacher_id;
        gatherTeachersStudents();
    }
    public Students(){

    }
    /**
     * Gets Students Last, First names with corresponding ID #
     * @param student_id
     * @return String of students appended name
     */
    public String getNameOfID(int student_id){
        Student temp = new Student();
        for(int i = 0;i < students.size();i++){
            temp = students.get(i);
            if(temp.getStudentID() == student_id){
                return (temp.getLastName() + ", " + temp.getFirstName());
            }
        }
        return "Student Not Found";
    }
    private void gatherTeachersStudents(){
        String sql = "SELECT student_id, first_name, last_name, bio FROM student WHERE teacher_id = ?;";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, this.teacher_id);
            ResultSet resultSet = statement.executeQuery();
            do{
                students.add(new Student(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        students.remove(0);
    }
    public Student[] createStudentArray(){
        Student[] temp = new Student[students.size()];
        for(int i = 0;i < students.size();i++){
            temp[i] = students.get(i);
        }
        return temp;
    }
}
