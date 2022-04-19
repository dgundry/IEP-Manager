package com.mango.prjmango.assignment;

import com.mango.prjmango.utilities.DatabaseConnection;
import lombok.Getter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Retrieves all {@link Assignment}'s.
 */
public class Assignments {

    private static final Logger logger = Logger.getLogger(Assignments.class.getName());

    @Getter private ArrayList<Assignment> assignments = new ArrayList<>();

    private final int teacherId;

    /**
     * Constructs a new {@link ArrayList} of {@link Assignments}.
     *
     * @param teacherId the specific teacher Id
     */
    public Assignments(int teacherId){
        this.teacherId = teacherId;
        gatherStudentsAssignments();
    }

    private void gatherStudentsAssignments() {
        String sql = "SELECT DISTINCT assignment_id, student_id, title, earned_points, total_points, date, comment FROM assignment WHERE teacher_id = ? GROUP BY assignment_id;";
        assignments.clear();
        try(PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, this.teacherId);
            ResultSet resultSet = statement.executeQuery();
            do{
                try {
                    assignments.add(new Assignment(
                                    resultSet.getInt(1),
                                    resultSet.getInt(2),
                                    resultSet.getString(3),
                                    resultSet.getInt(4),
                                    resultSet.getInt(5),
                                    resultSet.getString(6),
                                    resultSet.getString(7)));
                } catch(Exception e) {
                    logger.log(Level.INFO, "No Assignments");
                }
            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        if(assignments.size() > 1){
            assignments.remove(0);
        }
    }
}
