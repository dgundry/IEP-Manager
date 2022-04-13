package com.mango.prjmango.assignment;

import lombok.Getter;
import lombok.Setter;

public class Assignment {

    @Getter @Setter private Integer assignmentID;
    @Getter @Setter private Integer studentID;
    @Getter @Setter private String title;
    @Getter @Setter private Integer earnedPoints;
    @Getter @Setter private Integer totalPoints;
    @Getter @Setter private String date;
    @Getter @Setter private String comment;

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
}
