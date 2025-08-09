package dev.gutemberg.expression.evaluator;

import dev.gutemberg.expression.evaluator.evaluators.ExpressionEvaluator;

public class Main {
    public static void main(final String[] args) {
        System.out.println(ExpressionEvaluator.evaluate("(1 + 3) / (3 + 2 * 2)"));
    }
}
