package com.codecool.file.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    public void initBeforeEach() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("./resources/test.txt", 1, 6);
        this.fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    }

    @Test
    public void getWordOrderedAlphabeticallyTest() throws IOException {
        String result = "[anna, civic, fifth, first, fourth, kayak, level, line, line, line, line, line, madam, mom, noon, one, one, one, one, one, second, third, three, three, three, three, three, two, two, two, two, two]";
        assertEquals(result, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    public void getWordsContainingSubstringTest() throws IOException {
        String result = "[three, three, third, three, fourth, three, fifth, three]";
        assertEquals(result, fileWordAnalyzer.getWordsContainingSubstring("th").toString());
    }

    @Test
    public void getWordsContainingSubstringWithNonExistingSubstringTest() throws IOException {
        String result = "[]";
        assertEquals(result, fileWordAnalyzer.getWordsContainingSubstring("wqerfgsadsgfvsga").toString());
    }

    @Test
    public void getStringsWhichPalindromesTest() throws IOException {
        String result = "[anna, civic, kayak, level, madam, mom, noon]";
        assertEquals(result, fileWordAnalyzer.getStringsWhichPalindromes().toString());
    }

}