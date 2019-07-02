package com.codecool.file.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if (toLine < fromLine || fromLine < 0) {
            throw new IllegalArgumentException("Insert valid numbers!");
        }
    }

    public String read() throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path, StandardCharsets.UTF_8).toString();

    }

    public String readLines() throws IOException {
        StringBuilder scannedLines = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        int counter = 0;
        while (scanner.hasNextLine()) {
            if (counter >= fromLine && counter <= toLine) {
                scannedLines.append(scanner.nextLine());
            }
        }
        return scannedLines.toString();

    }


}
