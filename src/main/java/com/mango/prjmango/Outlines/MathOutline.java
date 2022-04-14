package com.mango.prjmango.Outlines;

import lombok.Getter;

public class MathOutline {

    @Getter private int assignmentID;
    @Getter private String assignmentName;
    @Getter private int additionTotal;
    @Getter private int subtractionTotal;
    @Getter private int multiplicationTotal;
    @Getter private int divisionTotal;
    @Getter private int numeratorMin;
    @Getter private int numeratorMax;
    @Getter private int denominatorMin;
    @Getter private int denominatorMax;
    @Getter private boolean wholeNumbers;
    public MathOutline(int assignmentID, String assignmentName, int additionTotal, int subtractionTotal, int multiplicationTotal, int divisionTotal, int numeratorMin, int numeratorMax, int denominatorMin, int denominatorMax, int wholeNumbers) {
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
        if(wholeNumbers == 1){
            this.wholeNumbers = true;
        }else{
            this.wholeNumbers = false;
        }
    }
    public String toString(){
        return assignmentName;
    }
}
