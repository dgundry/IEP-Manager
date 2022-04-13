package com.mango.prjmango.ui.students;

import com.mango.prjmango.Main;
import com.mango.prjmango.assignment.Assignment;
import com.mango.prjmango.ui.students.view.ViewStudentController;

import javax.swing.table.JTableHeader;
import java.util.List;

public class ReportsController {

    private static int student_id;

    public ReportsController(ReportsView view, int student_id){
        this.student_id = student_id;
        populateTable(view, Main.getAssignments().getAssignments());
        System.out.println("Student id: "+student_id);

        //JTableHeader header = view.getAssignmentTable().getTableHeader();
    }

    private static void populateTable(ReportsView view, List<Assignment> assignments){
        for(Assignment assignment : assignments) {
            if (assignment.getStudentID() == student_id) {
                System.out.println("Got HERE");
                view.getModel().addRow(new Object[]{
                        assignment.getAssignmentID(),
                        assignment.getTitle(),
                        assignment.getEarnedPoints(),
                        assignment.getTotalPoints(),
                        assignment.getDate(),
                        assignment.getComment()});
            }
        }
        //view.getAssignmentTable().getColumn("View").setCellRenderer(new ViewStudentController.ButtonRenderer());

    }
}
