package com.references.book.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class WordsUtil {

    private static Set<String> BANNED_WORDS = Set.of(
            "Los",
            "El",
            "La",
            "A",
            "Al",
            "En",
            "Las",
            "Mi",
            "Que",
            "Se",
            "Su",
            "Una",
            "Uno",
            "Lo",
            "Y",
            "Esta",
            "De",
            "Es",
            "Sus",
            "Si",
            "Un",
            "Con",
            "No",
            "Por",
            "Yo",
            "Todo",
            "Me",
            "Alli",
            "Nada",
            "Algo",
            "O",
            "Te",
            "Ya",
            "Aun",
            "Aún",
            "Muy",
            "Mis",
            "Oye",
            "Para",
            "Ese",
            "Sin",
            "Pero",
            "Sí",
            "Esto",
            "Porque",
            "Él",
            "Ella",
            "Ellas",
            "Esa",
            "Hoy",
            "Fue",
            "He",
            "Hice",
            "Está",
            "Ésta",
            "Cuando",
            "Desde",
            "Dios",
            "Era",
            "Eran",
            "Qué",
            "Sobre",
            "Solo",
            "Sólo",
            "Solos",
            "Soy",
            "Todos",
            "Hace",
            "Debo",
            "Debe",
            "Como",
            "Eso",
            "Nos",
            "Tan",
            "Sé",
            "Hasta",
            "Hay",
            "Otro",
            "Nunca",
            "Nosotros",
            "Puede",
            "Puedo",
            "Le",
            "Toda",
            "Así",
            "Aquí",
            "Ahí",
            "Ahora",
            "Tu",
            "Tú",
            "Tus",
            "Del",
            "Más",
            "Unas",
            "Unos"
    );

    public static boolean shouldIgnoreWord(final String word) {
        return BANNED_WORDS.contains(word);
    }

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
        return word.trim().replaceAll("[,\\)\\.:\"]", "");
    }

    private WordsUtil() {}

}
