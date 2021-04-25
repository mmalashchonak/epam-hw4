package com.epam.webdev.util;

public class LetterChecker {
    public static final Character[] PUNCTUATION_CHARS = {'.', ',', ':', ';', '!', '?', '-', ' ', '\n', '\"', ')', '(', '«', '»'};
    public static final Character[] CONSONANT_CHARS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p',
            'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    public static boolean checkPunctuationSymbol(char symbol) {
        boolean isPunctuationSymbol = false;

        for (Character punctuationSymbol : PUNCTUATION_CHARS) {
            if (symbol == punctuationSymbol) {
                isPunctuationSymbol = true;
                break;
            }
        }

        return isPunctuationSymbol;
    }

    public static boolean checkConsonantSymbol(Character symbol) {
        boolean isConsonantSymbol = false;

        for (Character consonantSymbol : CONSONANT_CHARS) {
            if (Character.toLowerCase(symbol) == consonantSymbol) {
                isConsonantSymbol = true;
                break;
            }
        }

        return isConsonantSymbol;
    }
}
