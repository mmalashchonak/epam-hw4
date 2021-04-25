package com.epam.webdev.util;

public class CharArraySplitterUnifier {

    public static char[] subarray(char[] array, int start, int end) {
        char[] result = new char[end - start];

        for (int i = 0; i < result.length; i++) {
            result[i] = array[start + i];
        }

        return result;
    }

    public static char[] concatenate(char[] firstArray, char[] secondArray) {
        int resultedLength = firstArray.length + secondArray.length;
        char[] result = new char[resultedLength];

        for (int i = 0; i < firstArray.length; i++) {
            result[i] = firstArray[i];
        }

        for (int i = 0; i < secondArray.length; i++) {
            result[firstArray.length + i] = secondArray[i];
        }
        return result;
    }
}
