package com.references.book;

import com.references.book.util.FileLines;
import com.references.book.util.WordsUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(final String[] args) throws IOException  {

		if (args.length <= 0) {
			throw new RuntimeException("getreferences.jar <file text path>");
		}

		final String fileName = args[0];
		System.out.println("Going to work with: " + fileName);

		SpringApplication.run(App.class, args);

        final List<String> bookLines = FileLines.linesFromFile(fileName);
        final List<String> words = WordsUtil.getWords(bookLines.get(0));
		System.out.println(words);

    }

}
