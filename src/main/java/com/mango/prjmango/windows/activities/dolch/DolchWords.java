package com.mango.prjmango.windows.activities.dolch;

public enum DolchWords {
    PRE_K("Pre-K Dolch"), KINDER("Kindergarten Dolch"), FIRST("First Grade Dolch"), SECOND("Second Grade Dolch"), THIRD("Third Grade Dolch"),
    NOUN("Nouns Dolch");

    private String value;

    DolchWords(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
