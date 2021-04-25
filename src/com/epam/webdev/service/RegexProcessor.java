package com.epam.webdev.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcessor {

    public static String replaceLetterInEachWord(String text, char newLetter, Integer letterPosition) {
        String wordPattern = "\\w{" + letterPosition + ",}";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder(text);

        while (matcher.find()) {
            int start = matcher.start();
            stringBuilder.setCharAt(start + letterPosition - 1, newLetter);
        }

        return stringBuilder.toString();
    }

    public static String replaceAWithOAfterP(String text) {
        String targetSequence = "PA(\\w+)";
        Pattern pattern = Pattern.compile(targetSequence);
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder(text);

        while (matcher.find()) {
            int start = matcher.start();
            stringBuilder.setCharAt(start + 1, 'O');
        }

        return stringBuilder.toString();
    }

    public static String replaceWordsWithSubstring(String text, Integer wordLength, String substring) {
        String wordPattern = "(?:^\\w{" + wordLength + "}\\W|\\W\\w{" + wordLength + "}\\W)";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder(text);

        while (matcher.find()) {
            int start = matcher.start();

            if (start == 0) {
                stringBuilder.delete(start, start + wordLength);
                stringBuilder.insert(start, substring);
            } else {
                stringBuilder.delete(start + 1, start + wordLength + 1);
                stringBuilder.insert(start + 1, substring);
            }

            matcher = pattern.matcher(stringBuilder);
        }

        return stringBuilder.toString();
    }

    public static String deleteNonlettersExceptSpaces(String text) {
        text = text.replaceAll("\\W+", " ");
        return text.trim();
    }

    public static String deleteWordsStartingWithConsonant(String text, int wordLength) {
        String wordPattern = "(?i)(?:^[b-df-hj-np-tv-z]\\w{" + (wordLength - 1)
                + "}\\W|\\W[b-df-hj-np-tv-z]\\w{" + (wordLength - 1) + "}\\W)";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);

        StringBuilder stringBuilder = new StringBuilder(text);

        while (matcher.find()) {
            int start = matcher.start();

            if (start == 0) {
                stringBuilder.delete(start, start + wordLength);
            } else {
                stringBuilder.delete(start + 1, start + wordLength + 1);
            }

            matcher = pattern.matcher(stringBuilder);
        }

        return stringBuilder.toString();
    }
}
