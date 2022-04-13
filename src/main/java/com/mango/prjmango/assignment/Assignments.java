package com.mango.prjmango.assignment;

import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.DatabaseConnection;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Assignments {
    @Getter ArrayList<Assignment> assignments = new ArrayList<>();

    private int teacher_id;
    public Assignments(int teacher_id){
        this.teacher_id = teacher_id;
        gatherStudentsAssignments();
    }

    public Assignments(){

    }

    private void gatherStudentsAssignments(){
        String sql = "SELECT DISTINCT assignment_id, student_id, title, earned_points, total_points, date, comment FROM assignment WHERE teacher_id = ? GROUP BY assignment_id;";
        assignments.clear();
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, this.teacher_id);
            ResultSet resultSet = statement.executeQuery();
            do{
                try{
                    assignments.add(new Assignment(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7)));
                }catch(Exception e){
                    System.out.println("No Assignments");
                }
            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(assignments.size() > 1){
            assignments.remove(0);
        }
    }
}
