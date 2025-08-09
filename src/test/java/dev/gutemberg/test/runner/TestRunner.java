package dev.gutemberg.test.runner;

import dev.gutemberg.test.runner.annotations.Test;
import dev.gutemberg.test.runner.models.enums.Emoji;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

import static java.lang.System.out;

public class TestRunner {
    public static void main(final String[] args) throws Throwable {
        try {
            scanDirectoryAndRunTests("dev/gutemberg/expression/evaluator");
        } catch (final InvocationTargetException e) {
            out.println("--------------------------------");
            throw e.getCause();
        }
        out.println("--------------------------------");
        out.printf("Success %s\n", Emoji.PARTY_POPPER);
    }

    private static void scanDirectoryAndRunTests(final String directoryPath) throws InvocationTargetException {
        try {
            final var resources = TestRunner.class.getClassLoader().getResources(directoryPath);
            while (resources.hasMoreElements()) {
                final var element = resources.nextElement();
                if (!element.getPath().contains("test")) {
                    continue;
                }
                final var directory = new File(element.getFile());
                final var files = Optional.ofNullable(directory.listFiles()).orElse(new File[]{});
                for (final var file: files) {
                    if (file.isFile()) {
                        runTests(directoryPath, file.getName());
                    } else {
                        scanDirectoryAndRunTests(directoryPath + "/" + file.getName());
                    }
                }
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTests(final String directoryPath, String className) throws InvocationTargetException {
        final var simpleClassName = className.replace(".class", "");
        out.printf("%s %s\n", simpleClassName, Emoji.ROCKET);
        out.println("--------------------------------");
        try {
            final var fullClassName = directoryPath.replaceAll("/", ".") + "." + simpleClassName;
            final var clazz = Class.forName(fullClassName);
            final var instance = clazz.getDeclaredConstructor().newInstance();
            final var tests = Arrays.stream(clazz.getMethods())
                    .filter(method ->
                            Arrays.stream(method.getAnnotations())
                                    .anyMatch(annotation -> annotation.annotationType().equals(Test.class)))
                    .toList();
            final var total = tests.size();
            for (int i = 0; i < total; i++) {
                out.printf("Running test %d/%d %s\n", i + 1, total, Emoji.TEST_TUBE);
                tests.get(i).invoke(instance);
                out.printf("  - Passed %s\n", Emoji.CHECK_MARK_BUTTON);
            }
        } catch (final InvocationTargetException e) {
            out.printf("  - Failed %s\n", Emoji.NO_ENTRY);
            throw e;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (final ClassNotFoundException ignored) {}
    }
}
