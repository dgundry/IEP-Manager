package com.mango.prjmango.outlines;

import lombok.Getter;

/**
 * A POJO representation of an Outline.
 */
public class Outline {

    @Getter private final int assignmentID;
    @Getter private final String assignmentName;
    @Getter private final int maximumPoints;

    /**
     *
     * @param assignmentID   the assignment's ID
     * @param assignmentName the assignment's name
     * @param maximumPoints  the maximum points for the assignment
     */
    public Outline(int assignmentID, String assignmentName, int maximumPoints){
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.maximumPoints = maximumPoints;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return assignmentName;
    }
}
