package dev.gutemberg.expression.evaluator.evaluators;

import dev.gutemberg.expression.evaluator.models.wrappers.ExpressionToken;

import java.util.List;
import java.util.Stack;

public class PostfixExpressionTokenEvaluator {
    public static double evaluate(List<ExpressionToken> tokens) {
        final var stack = new Stack<Double>();
        for (var token: tokens) {
            if (token.isOperator()) {
                final var y = stack.pop();
                var x = 0.0;
                if (!stack.isEmpty()) {
                    x = stack.pop();
                }
                stack.push(token.operator().apply(x, y));
            } else {
                stack.push(token.operand());
            }
        }
        return stack.pop();
    }
}
