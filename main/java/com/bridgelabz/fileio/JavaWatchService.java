package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Watches a directory and all its sub-directories.
 */
public class JavaWatchService {

    private final WatchService watcher;
    private final Map<WatchKey, Path> dirWatchers;

    /**
     * Constructor.
     */
    public JavaWatchService(Path directory) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<>();
        scanAndRegisterDirectories(directory);
    }

    /**
     * Register a directory.
     */
    private void registerDirectory(Path directory) throws IOException {

        WatchKey key = directory.register(
                watcher,
                ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY);

        dirWatchers.put(key, directory);
    }

    /**
     * Register root directory and all sub-directories.
     */
    private void scanAndRegisterDirectories(Path start) throws IOException {

        Files.walkFileTree(start, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                                                     BasicFileAttributes attrs)
                    throws IOException {

                registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Process file events.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void processEvents() {

        while (true) {

            WatchKey key;

            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                return;
            }

            Path dir = dirWatchers.get(key);

            if (dir == null)
                continue;

            for (WatchEvent event : key.pollEvents()) {

                WatchEvent.Kind kind = event.kind();

                Path name = ((WatchEvent<Path>) event).context();

                Path child = dir.resolve(name);

                System.out.printf("%s : %s%n",
                        kind.name(), child);

                if (kind == ENTRY_CREATE) {

                    try {

                        if (Files.isDirectory(child))
                            scanAndRegisterDirectories(child);

                    } catch (IOException ignored) {
                    }
                }
            }

            boolean valid = key.reset();

            if (!valid) {
                dirWatchers.remove(key);

                if (dirWatchers.isEmpty())
                    break;
            }
        }
    }
}