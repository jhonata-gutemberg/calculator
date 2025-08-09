package dev.gutemberg.expression.evaluator.evaluators;

import dev.gutemberg.expression.evaluator.parsers.ExpressionTokenParser;
import dev.gutemberg.expression.evaluator.parsers.PostfixExpressionTokenParser;

public class ExpressionEvaluator {
    public static double evaluate(final String expression) {
        final var tokens = ExpressionTokenParser.parse(expression);
        final var postfixTokens = PostfixExpressionTokenParser.parse(tokens);
        return PostfixExpressionTokenEvaluator.evaluate(postfixTokens);
    }
}
