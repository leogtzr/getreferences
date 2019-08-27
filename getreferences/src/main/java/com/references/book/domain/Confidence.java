package com.references.book.domain;

public enum Confidence {
    BEGIN(10),
    BEGIN_SEVERAL_WORDS(15),
    END(20)
    ;
    private final int confidence;

    Confidence(final int confidence) {
        this.confidence = confidence;
    }

    public int get() {
        return confidence;
    }

    @Override
    public String toString() {
        return "{" +
                "confidence=" + confidence +
                '}';
    }
}
