package dev.gutemberg.calculator.evaluators;

import dev.gutemberg.calculator.parsers.ExpressionTokenParser;
import dev.gutemberg.calculator.parsers.PostfixExpressionTokenParser;

public class ExpressionEvaluator {
    public static double evaluate(final String expression) {
        final var tokens = ExpressionTokenParser.parse(expression);
        final var postfixTokens = PostfixExpressionTokenParser.parse(tokens);
        return PostfixExpressionTokenEvaluator.evaluate(postfixTokens);
    }
}
