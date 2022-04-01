package com.mango.prjmango.Outlines;

import lombok.Getter;

public class Outline {
    @Getter
    private int assignmentID;
    @Getter
    private String assignmentName;
    @Getter
    private int maximumPoints;

    public Outline(int assignmentID, String assignmentName, int maximumPoints){
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.maximumPoints = maximumPoints;
    }
    public String toString(){
        return assignmentName;
    }
}
