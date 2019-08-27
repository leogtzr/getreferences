package com.references.book.domain;

public enum Confidence {
    BEGIN(10),
    MIDDLE_OF_LINE(20),
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
        return "Confidence{" +
                "confidence=" + confidence +
                '}';
    }
}
