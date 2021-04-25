package com.epam.webdev.service;

import com.epam.webdev.util.CharArraySplitterUnifier;
import com.epam.webdev.util.LetterChecker;

public class CharArrayProcessor {

    public static String replaceLetterInEachWord(String text, char newLetter, int letterPosition) {
        char[] chars = text.toCharArray();

        int pointer = 0;
        while (pointer < chars.length) {
            int wordLength = 0;

            for (int i = pointer; i < chars.length; i++) {
                char currentSymbol = chars[i];

                if (LetterChecker.checkPunctuationSymbol(currentSymbol)) {
                    break;
                }

                wordLength++;
            }

            if (wordLength >= letterPosition) {
                chars[pointer + letterPosition - 1] = newLetter;
            }

            pointer += wordLength;

            if (wordLength == 0) {
                pointer++;
            }
        }

        return new String(chars);
    }

    public static String replaceAWithOAfterP(String text) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length - 2; i++) {
            char firstLetter = chars[i];
            char secondLetter = chars[i + 1];
            char thirdLetter = chars[i + 2];

            if (firstLetter == 'P'
                    && secondLetter == 'A'
                    && !LetterChecker.checkPunctuationSymbol(thirdLetter)) {
                chars[i + 1] = 'O';
            }
        }

        return new String(chars);
    }

    public static String replaceWordsWithSubstring(String text, int wordLength, String substring) {
        char[] chars = text.toCharArray();
        char[] newCharSequence = substring.toCharArray();

        int pointer = text.length() - 1;

        while (pointer >= wordLength - 1) {
            int currentWordLength = 0;

            for (int i = pointer; i >= 0; i--) {
                char currentChar = chars[i];

                if (LetterChecker.checkPunctuationSymbol(currentChar)) {
                    break;
                }

                currentWordLength++;
            }

            if (currentWordLength == wordLength) {
                char[] leftSubArray = CharArraySplitterUnifier.subarray(chars, 0, pointer + 1 - wordLength);
                char[] rightSubArray = CharArraySplitterUnifier.subarray(chars, pointer + 1, chars.length);
                chars = CharArraySplitterUnifier.concatenate(leftSubArray, newCharSequence);
                chars = CharArraySplitterUnifier.concatenate(chars, rightSubArray);
            }

            pointer -= currentWordLength;

            if (currentWordLength == 0) {
                pointer--;
            }
        }

        return new String(chars);
    }

    public static String deleteNonlettersExceptSpaces(String text) {
        char[] chars = text.toCharArray();

        int pointer = text.length() - 1;

        while (pointer >= 0) {
            int nonLetterSequenceLength = 0;

            for (int i = pointer; i > 0; i--) {
                char currentChar = chars[i];

                if (currentChar >= 'A' && currentChar <= 'Z'
                        || currentChar >= 'a' && currentChar <= 'z') {
                    break;
                }

                nonLetterSequenceLength++;
            }

            if (nonLetterSequenceLength > 0) {
                char[] leftSubArray = CharArraySplitterUnifier.subarray(chars, 0, pointer + 1 - nonLetterSequenceLength);
                char[] rightSubArray = CharArraySplitterUnifier.subarray(chars, pointer + 1, chars.length);
                chars = CharArraySplitterUnifier.concatenate(leftSubArray, new char[]{' '});
                chars = CharArraySplitterUnifier.concatenate(chars, rightSubArray);
            }

            pointer -= nonLetterSequenceLength;

            if (nonLetterSequenceLength == 0) {
                pointer--;
            }
        }

        return new String(chars);
    }

    public static String deleteWordsStartingWithConsonant(String text, int wordLength) {
        char[] chars = text.toCharArray();

        int pointer = text.length() - 1;

        while (pointer >= wordLength - 1) {
            int currentWordLength = 0;

            for (int i = pointer; i >= 0; i--) {
                char currentChar = chars[i];

                if (LetterChecker.checkPunctuationSymbol(currentChar)) {
                    break;
                }

                currentWordLength++;
            }

            Character firstLetter = chars[pointer - wordLength + 1];

            if (currentWordLength == wordLength && LetterChecker.checkConsonantSymbol(firstLetter)){
                char[] leftSubArray = CharArraySplitterUnifier.subarray(chars, 0, pointer + 1 - currentWordLength);
                char[] rightSubArray = CharArraySplitterUnifier.subarray(chars, pointer + 1, chars.length);
                chars = CharArraySplitterUnifier.concatenate(leftSubArray, rightSubArray);
            }

            pointer -= currentWordLength;

            if (currentWordLength == 0) {
                pointer--;
            }
        }

        return new String(chars);
    }
}

