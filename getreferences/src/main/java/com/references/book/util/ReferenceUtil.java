package com.references.book.util;

import com.references.book.domain.Confidence;
import com.references.book.domain.Reference;

import java.util.ArrayList;
import java.util.List;

public class ReferenceUtil {

    private static int getNextReferenceIndex(int index, final List<String> words) {
        while (index < words.size() && WordsUtil.isTitle(words.get(index))) {
            index++;
        }
        return index;
    }

    private static String getContentTextFromRange(final int from, final int to, final List<String> words) {
        final StringBuilder sb = new StringBuilder();
        for (int i = from; i < to; i++) {
            sb.append(words.get(i)).append(" ");
        }
        return sb.toString();
    }

    private static void addReferenceWithConfidence(
            final String content
            , final int index
            , final List<Reference> references) {
        if (index == 0) {
            references.add(new Reference(content, Confidence.BEGIN));
        } else {
            references.add(new Reference(content, Confidence.BEGIN_SEVERAL_WORDS));
        }
    }

    public static List<Reference> extractReferences(final String line) {

        final List<String> words = WordsUtil.getWords(line.trim());
        if (words.isEmpty()) {
            return new ArrayList<>();
        }
        final List<Reference> references = new ArrayList<>();

        int index = 0;
        while (index < (words.size() - 1)) {
            final String word = words.get(index);
            final String nextWord = words.get(index + 1);

            if (WordsUtil.isTitle(word) && word.contains(",")) {
                addReferenceWithConfidence(WordsUtil.sanitizeWord(word), index, references);
            } else if (WordsUtil.isTitle(word) && WordsUtil.isTitle(nextWord)) {
                final int to = getNextReferenceIndex(index, words);
                String content = getContentTextFromRange(index, to, words);
                content = WordsUtil.sanitizeWord(content);
                addReferenceWithConfidence(content, index, references);
                index = to;
            } else if (WordsUtil.isTitle(word)) {
                addReferenceWithConfidence(WordsUtil.sanitizeWord(word), index, references);
            }
            index++;
        }

        final int lastIndex = words.size() - 1;
        final String lastWord = words.get(lastIndex);
        if (WordsUtil.isTitle(lastWord)) {
            final String content = WordsUtil.sanitizeWord(lastWord);
            addReferenceWithConfidence(content, index, references);
        }

        return references;
    }

    private ReferenceUtil() {}

}
