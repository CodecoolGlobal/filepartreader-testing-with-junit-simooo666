package com.codecool.file.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader = null;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        String scannedWords = filePartReader.readLines();
        ArrayList<String> scannedWordsArrayList = new ArrayList<>(Arrays.asList(scannedWords.split(" ")));
        java.util.Collections.sort(scannedWordsArrayList);
        return scannedWordsArrayList;
    }

    public List getWordsContainingSubstring(String subString) throws IOException {
        String scannedWords = filePartReader.readLines();
        ArrayList<String> scannedWordsArrayList = new ArrayList<>(Arrays.asList(scannedWords.split(" ")));
        ArrayList<String> matchingWords = new ArrayList<>();
        for (int i = 0; i < scannedWordsArrayList.size(); i++) {
            if (scannedWordsArrayList.get(i).contains(subString)) {
                matchingWords.add(scannedWordsArrayList.get(i));
            }
        }
        return matchingWords;
    }

    public List getStringsWhichPalindromes() throws IOException {
        String scannedWords = filePartReader.readLines();
        ArrayList<String> scannedWordsArrayList = new ArrayList<>(Arrays.asList(scannedWords.split(" ")));
        ArrayList<String> matchingWords = new ArrayList<>();

        for (int i = 0; i < scannedWordsArrayList.size(); i++) {

            String originalWord = scannedWordsArrayList.get(i);
            StringBuilder reversedWord = new StringBuilder();

            for (int j = originalWord.length() - 1; j >= 0; j--) {
                reversedWord.append(originalWord.charAt(j));
            }

            if (originalWord.equals(reversedWord.toString())) {
                matchingWords.add(originalWord);
            }
        }

        return matchingWords;

    }


}
