package dev.gutemberg.test.runner;

import dev.gutemberg.test.runner.annotations.Test;
import dev.gutemberg.test.runner.models.enums.Emoji;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static java.lang.System.out;

public class TestRunner {
    public static void main(final String[] args) {
        out.printf("Starting tests %s\n", Emoji.ROCKET);
        out.println("--------------------------------");
        try {
            final var clazz = Class.forName("dev.gutemberg.expression.evaluator.evaluators.ExpressionEvaluatorTest");
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
                out.printf("Passed %s\n", Emoji.CHECK_MARK_BUTTON);
            }
        } catch (final InvocationTargetException e) {
            out.printf("Failed %s\n", Emoji.NO_ENTRY);
           throw new RuntimeException(e.getCause());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (final ClassNotFoundException ignored) {}
        out.println("--------------------------------");
        out.printf("Success %s\n", Emoji.PARTY_POPPER);
    }
}
