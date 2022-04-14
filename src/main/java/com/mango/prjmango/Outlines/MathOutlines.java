package com.mango.prjmango.Outlines;

import com.mango.prjmango.utilities.DatabaseConnection;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MathOutlines {
    @Getter
    ArrayList<MathOutline> outlines = new ArrayList<>();
    private int teacher_id;
    public MathOutlines(int teacher_id){
        this.teacher_id = teacher_id;
        gatherTeachersMathOutlines();
    }
    public MathOutlines() {
    }
    private void gatherTeachersMathOutlines(){
        String sql = "SELECT DISTINCT math_outline_id, assignment_name, addition, subtraction, multiplication, division, numerator_min, numerator_max, denominator_min, denominator_max, wholeNumbers FROM math_outlines WHERE teacher_id = ?;";
        outlines.clear();
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, this.teacher_id);
            ResultSet resultSet = statement.executeQuery();
            do{
                try{
                    outlines.add(new MathOutline(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(11)));
                }catch(Exception e){
                    System.out.println("No Math Outlines");
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
