package dev.gutemberg.test.runner;

import dev.gutemberg.test.runner.annotations.Test;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static java.lang.System.out;

public class TestRunner {
    public static void main(final String[] args) {
        out.println("Starting tests \uD83D\uDE80");
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
                out.printf("Running test %d/%d \uD83E\uDDEA\n", i + 1, total);
                tests.get(i).invoke(instance);
                out.println("Passed ✅");
            }
        } catch (final InvocationTargetException e) {
            out.println("Failed ⛔");
           throw new RuntimeException(e.getCause());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (final ClassNotFoundException ignored) {}
        out.println("Success \uD83C\uDF89");
    }
}
