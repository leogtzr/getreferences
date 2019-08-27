package com.references.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reference {
    private String content;
    private Confidence confidence;

    @Override
    public String toString() {
        return String.format("[%s]~[%s]", content, confidence);
    }
}
