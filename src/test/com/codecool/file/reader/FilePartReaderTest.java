package com.codecool.file.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void readAllLinesTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 2, 4);
        String result = "first line one two three second line one two three third line one two three fourth line one two three fifth line one two three anna civic kayak level madam mom noon";
        assertEquals(result, filePartReader.read());
    }

    @Test
    public void readAllLinesInvalidPathTest() throws IOException {
        assertThrows(NoSuchFileException.class, () -> {
            filePartReader.setup("/asdadsadsasdasd", 2, 4);
            filePartReader.read();
        });
    }

    @Test
    public void readMiddleLinesFromToTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 2, 4);
        String result = "second line one two three third line one two three fourth line one two three";
        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void readFirstLineFromToTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 1, 1);
        String result = "first line one two three";
        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void readLastLineFromToTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 5, 5);
        String result = "fifth line one two three";
        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void readNonExistingLinesFromToTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 10, 22);
        String result = "These lines does not exist in the file";
        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void readLinesValidFromAndInvalidToTest() throws IOException {
        filePartReader.setup("./resources/test.txt", 4, 100);
        String result = "fourth line one two three fifth line one two three anna civic kayak level madam mom noon";
        assertEquals(result, filePartReader.readLines());
    }

    @Test
    public void setupWithNegativeNumbers() throws IOException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("./resources/test.txt", -27, -5);
        });
    }
}