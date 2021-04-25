package com.epam.webdev;

import com.epam.webdev.service.CharArrayProcessor;
import com.epam.webdev.service.RegexProcessor;
import com.epam.webdev.service.StringProcessor;
import com.epam.webdev.util.TextReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String text = TextReader.readStringFromFile("text.txt");

        System.out.println("Input text: ");
        System.out.println(text);

        System.out.println("First task: ");

        System.out.println("String: ");
        System.out.println(StringProcessor.replaceLetterInEachWord(text, 'R', 5));

        System.out.println("CharArray: ");
        System.out.println(CharArrayProcessor.replaceLetterInEachWord(text, 'R', 5));

        System.out.println("Regex: ");
        System.out.println(RegexProcessor.replaceLetterInEachWord(text, 'R', 5));

        System.out.println("Second task: ");

        System.out.println("String: ");
        System.out.println(StringProcessor.replaceAWithOAfterP(text));

        System.out.println("CharArray: ");
        System.out.println(CharArrayProcessor.replaceAWithOAfterP(text));

        System.out.println("Regex: ");
        System.out.println(RegexProcessor.replaceAWithOAfterP(text));

        System.out.println("Third task: ");

        System.out.println("String: ");
        System.out.println(StringProcessor.replaceWordsWithSubstring(text, 5, "1111111"));

        System.out.println("CharArray: ");
        System.out.println(CharArrayProcessor.replaceWordsWithSubstring(text, 5, "1111111"));

        System.out.println("Regex: ");
        System.out.println(RegexProcessor.replaceWordsWithSubstring(text, 5, "1111111"));

        System.out.println("Fourth task: ");

        System.out.println("String: ");
        System.out.println(StringProcessor.deleteNonlettersExceptSpaces(text));

        System.out.println("CharArray: ");
        System.out.println(CharArrayProcessor.deleteNonlettersExceptSpaces(text));

        System.out.println("Regex: ");
        System.out.println(RegexProcessor.deleteNonlettersExceptSpaces(text));

        System.out.println("Fifth task: ");

        System.out.println("String: ");
        System.out.println(StringProcessor.deleteWordsStartingWithConsonant(text, 5));

        System.out.println("CharArray: ");
        System.out.println(CharArrayProcessor.deleteWordsStartingWithConsonant(text, 5));

        System.out.println("Regex: ");
        System.out.println(RegexProcessor.deleteWordsStartingWithConsonant(text, 5));
    }
}
