package org.panda_lang.utilities.annotations.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class PathUtils {

    private PathUtils() {}

    /**
     * Efficient way to collect all paths (with subdirectories) in the specified directory
     *
     * @param root                   the directory to search in
     * @param pathFilter             if path matches the filter, path is added to the list. Otherwise path will be checked as directory.
     * @return the list of collected paths
     */
    public static List<Path> collectPaths(Path root, Predicate<Path> pathFilter) {
        return collectPaths(new ArrayList<>(), root, pathFilter);
    }

    /**
     * Efficient way to collect all paths (with subdirectories) in the specified directory
     *
     * @param root                   the directory to search in
     * @param estimatedAmountOfPaths the estimated amount of paths to collect
     * @param pathFilter             if path matches the filter, path is added to the list. Otherwise path will be checked as directory.
     * @return the list of collected paths
     */
    public static List<Path> collectPaths(Path root, int estimatedAmountOfPaths, Predicate<Path> pathFilter) {
        return collectPaths(new ArrayList<>(estimatedAmountOfPaths), root, pathFilter);
    }

    private static List<Path> collectPaths(List<Path> files, Path root, Predicate<Path> pathFilter) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {
            for (Path path : stream) {
                if (pathFilter.test(path)) {
                    files.add(path);
                }
                else if (Files.isDirectory(path)) {
                    collectPaths(files, path, pathFilter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return files;
    }

}
