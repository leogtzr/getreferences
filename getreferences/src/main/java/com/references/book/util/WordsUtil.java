package com.references.book.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WordsUtil {

    public static List<String> getWords(final String line) {
        final List<String> words = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreElements()) {
            words.add(st.nextToken());
        }
        return words;
    }

    public static boolean isTitle(final String word) {
        if (word.isEmpty()) {
            return false;
        }
        final char firstChar = word.charAt(0);
        final boolean result = Character.isUpperCase(firstChar);

        // System.out.printf("Result [%s][%b]\n", word, result);

        return result;
    }

    public static String sanitizeWord(final String word) {
        return word.trim().replaceAll("[,\\)\\.]", "");
    }

    private WordsUtil() {}

}
