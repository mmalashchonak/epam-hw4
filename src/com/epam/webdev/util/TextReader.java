package com.epam.webdev.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextReader {

    public static String readStringFromConsole() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        String content = "";
        content = scanner.nextLine();

        return content;
    }

    public static String readStringFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));

        return content;
    }
}
