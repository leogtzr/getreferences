package com.references.book.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

import com.references.book.domain.Confidence;
import com.references.book.domain.Reference;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReferenceUtilTest {

    @Test
    public void should_identify_reference() {
        final String line = "Aquel Mio, ok, bye. Final.";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        assertThat(references, is(not(empty())));
        assertEquals(2, references.size());
        assertThat(references, is(List.of(new Reference("Aquel Mio", Confidence.BEGIN), new Reference("Final", Confidence.BEGIN_SEVERAL_WORDS))));
    }

    @Test
    public void should_identify_reference2() {
        final String line = "Cervantes, Sterne, Melville, Proust, Musil y Pynchon»";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        final int expectedNumberOfReferencesInLine = 6;
        assertEquals(expectedNumberOfReferencesInLine, references.size());
    }

    @Test
    public void should_identify_reference3() {
        final String line = "Cervantes, Sterne, Melville, Proust, Musil y Pynchon Tamal Bye, ok. Si";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        assertFalse(references.isEmpty());
        final int expectedNumberOfReferencesInLine = 7;
        assertEquals(expectedNumberOfReferencesInLine, references.size());

        final Reference firstExpectedReference = new Reference("Cervantes", Confidence.BEGIN);
        assertThat(firstExpectedReference, is(references.get(0)));
    }

    @Test
    public void should_identify_reference4() {
        final String line = "Cervantes, Sterne.";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        assertFalse(references.isEmpty());
        final int expectedNumberOfReferencesInLine = 2;
        assertEquals(expectedNumberOfReferencesInLine, references.size());
    }

    @Test
    public void should_identify_reference5() {
        final String line = "Cervantes, ok? Bolaño";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        assertFalse(references.isEmpty());
        final int expectedNumberOfReferencesInLine = 2;
        assertEquals(expectedNumberOfReferencesInLine, references.size());
    }

    @Test
    public void should_identify_reference6() {
        final String line = "Bolaño En Sus Laureles, OK.";
        final List<Reference> references = ReferenceUtil.extractReferences(line);
        System.out.println(references);
        assertFalse(references.isEmpty());
        final int expectedNumberOfReferencesInLine = 2;
        assertEquals(expectedNumberOfReferencesInLine, references.size());
    }
}