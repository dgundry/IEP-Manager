package com.mango.prjmango.assignment;

import lombok.Getter;
import lombok.Setter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A POJO representation of an assignment.
 */
public class Assignment {

    private static final Logger logger = Logger.getLogger(Assignment.class.getName());

    @Getter @Setter private Integer assignmentID;
    @Getter @Setter private Integer studentID;
    @Getter @Setter private String title;
    @Getter @Setter private Integer earnedPoints;
    @Getter @Setter private Integer totalPoints;
    @Getter @Setter private String date;
    @Getter @Setter private String comment;

    private final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructor.
     */
    public Assignment() {
    }

    /**
     * Constructs a new assignment.
     *
     * @param assignmentID the assignment ID
     * @param studentID    the student ID
     * @param title        the title of the assignment
     * @param earnedPoints the number of points earned
     * @param totalPoints  the number of total points
     * @param date         the date of the assignment
     * @param comment      the comments for the assignment
     */
    public Assignment(
            Integer assignmentID,
            Integer studentID,
            String title,
            Integer earnedPoints,
            Integer totalPoints,
            String date,
            String comment){
        this.assignmentID  = assignmentID;
        this.studentID     = studentID;
        this.title         = title;
        this.earnedPoints  = earnedPoints;
        this.totalPoints   = totalPoints;
        this.date          = date;
        this.comment       = comment;
    }

    public boolean isBetween(String startDate, String endDate) {
        try {
            Date start = formatter.parse(startDate);
            Date end = formatter.parse(endDate);
            Date date = formatter.parse(this.date);
            return (date.after(start) && date.before(end)) || date.equals(start) || date.equals(end);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return false;
    }
}
