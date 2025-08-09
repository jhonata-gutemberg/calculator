package dev.gutemberg.expression.evaluator.evaluators;

import dev.gutemberg.expression.evaluator.parsers.ExpressionTokenParser;
import dev.gutemberg.expression.evaluator.parsers.PostfixExpressionTokenParser;
import java.util.Map;

public class ExpressionEvaluator {
    public static double evaluate(final String expression, final Map<String, Double> variables) {
        var newExpression = expression;
        for (final var variable: variables.entrySet()) {
            newExpression = newExpression.replaceAll(variable.getKey(), variable.getValue().toString());
        }
        return evaluate(newExpression);
    }

    public static double evaluate(final String expression) {
        final var tokens = ExpressionTokenParser.parse(expression);
        final var postfixTokens = PostfixExpressionTokenParser.parse(tokens);
        return PostfixExpressionTokenEvaluator.evaluate(postfixTokens);
    }
}
