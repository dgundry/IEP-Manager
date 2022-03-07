package com.mango.prjmango.windows.activities.dolch;

public enum DolchWords {
    PRE_K("Pre-K"), KINDER("Kindergarten"), FIRST("First Grade"), SECOND("Second Grade"), THIRD("Third Grade"),
    NOUN("Nouns");

    private String value;

    DolchWords(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
