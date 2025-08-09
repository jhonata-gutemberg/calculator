package dev.gutemberg.expression.evaluator.assertions;

import dev.gutemberg.expression.evaluator.models.exceptions.AssertionFailedException;

public class Assertions {
    public static void assertEquals(final double expected, final double actual) {
        if (expected != actual) {
            throw new AssertionFailedException(
                    "The actual value is different from expected. expected = %f; actual = %f".formatted(expected, actual)
            );
        }
    }
}
