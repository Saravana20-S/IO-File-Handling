package com.bridgelabz.fileio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Demonstrates Java NIO File API operations using JUnit.
 */
public class NIOFileAPITest {

    /**
     * User home directory.
     */
    private static final String HOME = System.getProperty("user.home");

    /**
     * Test directory name.
     */
    private static final String PLAY_WITH_NIO = "TempPlayGround";

    /**
     * Demonstrates various file operations.
     *
     * @throws IOException if any file operation fails.
     */
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        // Home directory path
        Path homePath = Paths.get(HOME);

        // Verify home directory exists
        Assertions.assertTrue(Files.exists(homePath));

        // Playground directory path
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);

        // Delete directory if already exists
        if (Files.exists(playPath)) {
            deleteRecursively(playPath);
        }

        // Verify directory does not exist
        Assertions.assertFalse(Files.exists(playPath));

        // Create directory
        Files.createDirectory(playPath);

        // Verify directory created
        Assertions.assertTrue(Files.exists(playPath));

        // Create empty files temp1 to temp10
        for (int i = 1; i <= 10; i++) {

            Path tempFile = Paths.get(playPath + "/temp" + i + ".txt");

            Assertions.assertFalse(Files.exists(tempFile));

            Files.createFile(tempFile);

            Assertions.assertTrue(Files.exists(tempFile));
        }

        System.out.println("\nRegular Files");
        Files.list(playPath)
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

        System.out.println("\nDirectories");
        Files.list(playPath)
                .filter(Files::isDirectory)
                .forEach(System.out::println);

        System.out.println("\nFiles with .txt Extension");
        Files.list(playPath)
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(System.out::println);
    }

    /**
     * Deletes a directory recursively.
     *
     * @param path Directory path
     * @throws IOException if deletion fails
     */
    private void deleteRecursively(Path path) throws IOException {

        if (Files.notExists(path)) {
            return;
        }

        try (Stream<Path> paths = Files.walk(path)) {

            paths.sorted((first, second) -> second.compareTo(first))
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
}