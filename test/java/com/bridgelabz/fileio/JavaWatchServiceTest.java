package com.bridgelabz.fileio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Test class for Watch Service.
 */
public class JavaWatchServiceTest {

    /**
     * Project playground directory.
     */
    private static final Path PLAYGROUND =
            Paths.get("TempPlayGround");

    /**
     * Demonstrates Watch Service.
     */
    @Test
    public void givenDirectoryWhenWatchedListAllActivities() throws IOException {

        // Create playground directory if it doesn't exist
        if (Files.notExists(PLAYGROUND)) {
            Files.createDirectories(PLAYGROUND);
        }

        // Create sample files
        for (int i = 1; i <= 3; i++) {

            Path file = PLAYGROUND.resolve("temp" + i + ".txt");

            if (Files.notExists(file)) {
                Files.createFile(file);
            }
        }

        System.out.println("Files in Directory\n");

        Files.list(PLAYGROUND)
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

        System.out.println("\nWatching Directory...\n");

        JavaWatchService watchService =
                new JavaWatchService(PLAYGROUND);

        watchService.processEvents();
    }

    /**
     * Demonstrates counting file entries.
     */
    @Test
    public void givenFileWhenCountedShouldReturnEntries() throws IOException {

        if (Files.notExists(PLAYGROUND)) {
            Files.createDirectories(PLAYGROUND);
        }

        Path file = PLAYGROUND.resolve("employee.txt");

        if (Files.notExists(file)) {
            Files.createFile(file);
        }

        Files.write(file,
                java.util.List.of(
                        "101,Raj,45000",
                        "102,Amit,50000",
                        "103,Priya,60000",
                        "104,John,70000"
                ));

        long count = FileEntryCounter.countEntries(file);

        System.out.println("Number of Entries : " + count);
    }
}