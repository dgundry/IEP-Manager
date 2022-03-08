package com.mango.prjmango.windows.activities.fry;

public enum FryWords {

    FIRST_100("1st 100 Fry"), SECOND_100("2nd 100 Fry"), THIRD_100("3rd 100 Fry"), FOURTH_100("4th 100 Fry"), FIFTH_100("5th 100 Fry"),
    SIXTH_100("6th 100 Fry"), SEVENTH_100("7th 100 Fry"), EIGHTH_100("8th 100 Fry"), NINTH_100("9th 100 Fry"), TENTH_100("10th 100 Fry");

    private String value;

    FryWords(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
