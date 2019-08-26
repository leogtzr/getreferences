package com.references.book.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileLines {

    private FileLines() {}

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<String> linesFromFile(final String filePath) throws IOException {
        final Path path = Paths.get(filePath);
        return Files.lines(path, Charset.defaultCharset()).collect(Collectors.toList());
    }

}
