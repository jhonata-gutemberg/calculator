package dev.gutemberg.expression.evaluator.models.exceptions;

public class AssertionFailedException extends RuntimeException {
    public AssertionFailedException(final String message) {
        super(message);
    }
}
