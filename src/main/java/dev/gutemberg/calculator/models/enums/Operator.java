package dev.gutemberg.calculator.models.enums;

import java.util.Arrays;

public enum Operator {
    SUM('+') {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }

        @Override
        public int precedence() {
            return 0;
        }
    },

    SUBTRACTION('-') {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }

        @Override
        public int precedence() {
            return 0;
        }
    },

    MULTIPLICATION('*') {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }

        @Override
        public int precedence() {
            return 1;
        }
    },

    DIVISION('/') {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }

        @Override
        public int precedence() {
            return 1;
        }
    };

    private final char symbol;

    Operator(final char symbol) {
        this.symbol = symbol;
    }

    public char symbol() {
        return symbol;
    }

    public abstract double apply(double x, double y);
    public abstract int precedence();

    public static Operator from(final char symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol() == symbol)
                .findFirst()
                .orElseThrow();
    }

    public static boolean equals(final char symbol) {
        return Arrays.stream(values()).anyMatch(operator -> operator.symbol() == symbol);
    }
}
