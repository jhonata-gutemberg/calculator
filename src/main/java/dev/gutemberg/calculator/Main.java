package dev.gutemberg.calculator;

import dev.gutemberg.calculator.evaluators.ExpressionEvaluator;

public class Main {
    public static void main(final String[] args) {
        System.out.println(ExpressionEvaluator.evaluate("(1 + 3) / (3 + 2 * 2)"));
    }
}
