package com.mango.prjmango.windows.activities.fry;

public enum FryWords {

    FIRST_100("1st 100"), SECOND_100("2nd 100"), THIRD_100("3rd 100"), FOURTH_100("4th 100"), FIFTH_100("5th 100"),
    SIXTH_100("6th 100"), SEVENTH_100("7th 100"), EIGHTH_100("8th 100"), NINTH_100("9th 100"), TENTH_100("10th 100");

    private String value;

    FryWords(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
