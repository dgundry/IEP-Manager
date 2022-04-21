package com.mango.prjmango.outlines;

import lombok.Getter;

/**
 * A POJO representation of a Math Outline.
 */
public class MathOutline {

    @Getter private final int assignmentID;
    @Getter private final String assignmentName;
    @Getter private final int additionTotal;
    @Getter private final int subtractionTotal;
    @Getter private final int multiplicationTotal;
    @Getter private final int divisionTotal;
    @Getter private final int numeratorMin;
    @Getter private final int numeratorMax;
    @Getter private final int denominatorMin;
    @Getter private final int denominatorMax;
    @Getter private final int wholeNumbers;

    /**
     * Constructs a new Math Outline.
     *
     * @param assignmentID        the assignment ID
     * @param assignmentName      the assignment name
     * @param additionTotal       the number of addition problems
     * @param subtractionTotal    the number of subtraction problems
     * @param multiplicationTotal the number of multiplication problems
     * @param divisionTotal       the number of division problems
     * @param numeratorMin        the minimum value for the numerator
     * @param numeratorMax        the maximum value for the numerator
     * @param denominatorMin      the minimum value for the denominator
     * @param denominatorMax      the maximum value for the denominator
     * @param wholeNumbers        true if the math precision will be to whole numbers or false for the nearest
     *                            hundredth
     */
    public MathOutline(
            int assignmentID,
            String assignmentName,
            int additionTotal,
            int subtractionTotal,
            int multiplicationTotal,
            int divisionTotal,
            int numeratorMin,
            int numeratorMax,
            int denominatorMin,
            int denominatorMax,
            int wholeNumbers) {
        this.assignmentID = assignmentID;
        this.assignmentName = assignmentName;
        this.additionTotal = additionTotal;
        this.subtractionTotal = subtractionTotal;
        this.multiplicationTotal = multiplicationTotal;
        this.divisionTotal = divisionTotal;
        this.numeratorMin = numeratorMin;
        this.numeratorMax = numeratorMax;
        this.denominatorMin = denominatorMin;
        this.denominatorMax = denominatorMax;
        this.wholeNumbers = wholeNumbers;
    }
    public MathOutline(
            String assignmentName,
            int additionTotal,
            int subtractionTotal,
            int multiplicationTotal,
            int divisionTotal,
            int numeratorMin,
            int numeratorMax,
            int denominatorMin,
            int denominatorMax,
            int wholeNumbers) {
        assignmentID = -1;
        this.assignmentName = assignmentName;
        this.additionTotal = additionTotal;
        this.subtractionTotal = subtractionTotal;
        this.multiplicationTotal = multiplicationTotal;
        this.divisionTotal = divisionTotal;
        this.numeratorMin = numeratorMin;
        this.numeratorMax = numeratorMax;
        this.denominatorMin = denominatorMin;
        this.denominatorMax = denominatorMax;
        this.wholeNumbers = wholeNumbers;
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
