package com.references.book.util;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsUtilTest {

    @Test
    void should_identify_words_from_line() {
        final String line = "que ubica al autor de 2666 en el mismo equipo de";
        final List<String> words = WordsUtil.getWords(line);
        Assert.assertThat(words, hasItems("que", "ubica", "al", "autor", "de", "2666", "en", "el", "mismo"));
    }

    @Test
    void should_identify_title_words() {
        assertFalse(WordsUtil.isTitle("éxito"));
        assertTrue(WordsUtil.isTitle("Éxito"));
    }
}