package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Counts number of lines in a file.
 */
public class FileEntryCounter {

    /**
     * Count file entries.
     */
    public static long countEntries(Path file) throws IOException {

        return Files.lines(file).count();
    }
}