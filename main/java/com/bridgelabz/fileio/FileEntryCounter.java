package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Utility class to count entries in a file.
 */
public class FileEntryCounter {

    /**
     * Counts the number of lines in the file.
     *
     * @param filePath File path
     * @return Number of entries
     * @throws IOException if reading fails
     */
    public static long countEntries(Path filePath) throws IOException {

        return Files.lines(filePath).count();
    }
}