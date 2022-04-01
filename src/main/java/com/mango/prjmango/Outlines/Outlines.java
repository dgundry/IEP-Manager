package com.mango.prjmango.Outlines;

import com.mango.prjmango.student.Student;
import com.mango.prjmango.utilities.DatabaseConnection;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Outlines {
    @Getter ArrayList<Outline> outlines = new ArrayList<>();
    private int teacher_id;
    public Outlines(int teacher_id){
        this.teacher_id = teacher_id;
        gatherTeachersOutlines();
    }
    public Outlines() {
    }
    private void gatherTeachersOutlines(){
        String sql = "SELECT DISTINCT outline_id, assignment_name, total_points FROM outlines WHERE teacher_id = ?;";
        outlines.clear();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, this.teacher_id);
            ResultSet resultSet = statement.executeQuery();
            do{
                try{
                    outlines.add(new Outline(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3)));
                }catch(Exception e){
                    System.out.println("No Outlines");
                }
            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(outlines.size() > 1){
            outlines.remove(0);
        }
    }
}
