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
    private int minusOneToStartWithTheCorrectLine = -1;

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine + minusOneToStartWithTheCorrectLine;
        this.toLine = toLine + minusOneToStartWithTheCorrectLine;

        if (toLine < fromLine || fromLine < 0) {
            throw new IllegalArgumentException("Insert valid numbers!");
        }
    }

    public String read() throws IOException {
        Path path = Paths.get(filePath);
        String rawString = Files.readAllLines(path, StandardCharsets.UTF_8).toString();
        return rawString.replace("[", "").replace("]", "").replace(",", "").toLowerCase();

    }

    public String readLines() throws IOException {
        StringBuilder scannedLines = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        int counter = 0;
        while (scanner.hasNextLine()) {
            if (counter >= fromLine && counter <= toLine) {
                if (scannedLines.toString().equals("")) {
                    scannedLines.append(scanner.nextLine());
                } else {
                    scannedLines.append(" ");
                    scannedLines.append(scanner.nextLine());
                }
            } else {
                scanner.nextLine();
            }
            counter++;
        }
        if (fromLine > counter + minusOneToStartWithTheCorrectLine && toLine > counter + minusOneToStartWithTheCorrectLine)
            return "These lines does not exist in the file";
        return scannedLines.toString().toLowerCase();

    }


}
