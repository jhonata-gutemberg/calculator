package dev.gutemberg.calculator.models.enums;

import java.util.Arrays;

public enum Parentheses {
    OPEN('('),
    CLOSE(')');

    private final char symbol;

    Parentheses(final char symbol) {
        this.symbol = symbol;
    }

    public static Parentheses from(final char symbol) {
        return Arrays.stream(values())
                .filter(parentheses -> parentheses.symbol() == symbol)
                .findFirst()
                .orElseThrow();
    }

    public static boolean equals(final char symbol) {
        return Arrays.stream(values()).anyMatch(parentheses -> parentheses.symbol() == symbol);
    }

    private char symbol() {
        return symbol;
    }

    public boolean isOpen() {
        return this.equals(OPEN);
    }
}
