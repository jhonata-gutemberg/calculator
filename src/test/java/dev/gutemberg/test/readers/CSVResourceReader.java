package dev.gutemberg.test.readers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CSVResourceReader {
    public static List<String[]> read(final String resourceName, final String separator) throws IOException {
        final var classLoader = CSVResourceReader.class.getClassLoader();
        final var resource = classLoader.getResource(resourceName);
        if (resource == null) {
            throw new RuntimeException("resource not found");
        }
        final var file = new File(resource.getFile());
        return Files.readAllLines(file.toPath())
                .stream()
                .map(line -> line.split(separator))
                .toList();
    }
}
