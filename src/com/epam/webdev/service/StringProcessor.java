package com.epam.webdev.service;

import com.epam.webdev.util.LetterChecker;

public class StringProcessor {

    public static String replaceLetterInEachWord(String text, char newLetter, int letterPosition) {
        int pointer = 0;
        StringBuilder stringBuilder = new StringBuilder(text);

        while (pointer < text.length()) {
            int wordLength = 0;

            for (int i = pointer; i < text.length(); i++) {
                char currentSymbol = text.charAt(i);

                if (LetterChecker.checkPunctuationSymbol(currentSymbol)) {
                    break;
                }

                wordLength++;
            }

            if (wordLength >= letterPosition) {
                stringBuilder.setCharAt(pointer + letterPosition - 1, newLetter);
            }

            pointer += wordLength;

            if (wordLength == 0) {
                pointer++;
            }
        }

        return stringBuilder.toString();
    }

    public static String replaceAWithOAfterP(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < text.length() - 2; i++) {
            char firstLetter = text.charAt(i);
            char secondLetter = text.charAt(i + 1);
            char thirdLetter = text.charAt(i + 2);

            if (firstLetter == 'P'
                    && secondLetter == 'A'
                    && !LetterChecker.checkPunctuationSymbol(thirdLetter)) {
                stringBuilder.setCharAt(i + 1, 'O');
            }
        }

        return stringBuilder.toString();
    }

    public static String replaceWordsWithSubstring(String text, int wordLength, String substring) {
        int pointer = text.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(text);

        while (pointer >= wordLength - 1) {
            int currentWordLength = 0;

            for (int i = pointer; i >= 0; i--) {
                char currentChar = text.charAt(i);

                if (LetterChecker.checkPunctuationSymbol(currentChar)) {
                    break;
                }

                currentWordLength++;
            }

            if (currentWordLength == wordLength) {
                stringBuilder.delete(pointer - wordLength + 1, pointer + 1);
                stringBuilder.insert(pointer - wordLength + 1, substring);
            }

            pointer -= currentWordLength;

            if (currentWordLength == 0) {
                pointer--;
            }
        }

        return stringBuilder.toString();
    }

    public static String deleteNonlettersExceptSpaces(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar < 'A' || (currentChar > 'Z' && currentChar < 'a')
                    || currentChar > 'z') {
                stringBuilder.setCharAt(i, ' ');
            }
        }

        String[] wordsArray = stringBuilder.toString().split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : wordsArray) {
            if (!word.equals("")) {
                result.append(word);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }

    public static String deleteWordsStartingWithConsonant(String text, int wordLength) {
        int pointer = text.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(text);

        while (pointer >= wordLength - 1) {
            int currentWordLength = 0;

            for (int i = pointer; i >= 0; i--) {
                char currentChar = text.charAt(i);

                if (LetterChecker.checkPunctuationSymbol(currentChar)) {
                    break;
                }

                currentWordLength++;
            }

            Character firstLetter = text.charAt(pointer - wordLength + 1);

            if (currentWordLength == wordLength && LetterChecker.checkConsonantSymbol(firstLetter)) {
                stringBuilder.delete(pointer - wordLength + 1, pointer + 1);
            }

            pointer -= currentWordLength;

            if (currentWordLength == 0) {
                pointer--;
            }
        }

        return stringBuilder.toString();
    }
}


