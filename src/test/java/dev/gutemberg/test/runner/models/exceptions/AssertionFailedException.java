package dev.gutemberg.test.runner.models.exceptions;

public class AssertionFailedException extends RuntimeException {
    public AssertionFailedException(final String message) {
        super(message);
    }
}
