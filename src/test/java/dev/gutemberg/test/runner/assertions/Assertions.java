package dev.gutemberg.test.runner.assertions;

import dev.gutemberg.test.runner.models.exceptions.AssertionFailedException;

public class Assertions {
    public static void assertEquals(final double expected, final double actual) {
        if (expected != actual) {
            throw new AssertionFailedException(
                    "The actual value is different from expected. expected = %f; actual = %f".formatted(expected, actual)
            );
        }
    }
}
