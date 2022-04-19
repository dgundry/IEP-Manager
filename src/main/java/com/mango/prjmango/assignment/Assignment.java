package com.mango.prjmango.assignment;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {

    @Getter @Setter private Integer assignmentID;
    @Getter @Setter private Integer studentID;
    @Getter @Setter private String title;
    @Getter @Setter private Integer earnedPoints;
    @Getter @Setter private Integer totalPoints;
    @Getter @Setter private String date;
    @Getter @Setter private String comment;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Assignment(){

    }

    public Assignment(Integer assignmentID, Integer studentID, String title, Integer earnedPoints, Integer totalPoints, String date, String comment){
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
            e.printStackTrace();
        }
        return false;
    }
}
