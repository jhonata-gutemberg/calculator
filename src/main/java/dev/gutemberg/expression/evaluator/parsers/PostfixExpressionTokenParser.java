package dev.gutemberg.expression.evaluator.parsers;

import dev.gutemberg.expression.evaluator.models.wrappers.ExpressionToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixExpressionTokenParser {
    public static List<ExpressionToken> parse(final List<ExpressionToken> tokens) {
        final List<ExpressionToken> output = new ArrayList<>();
        final Stack<ExpressionToken> stack = new Stack<>();
        for (final var token: tokens) {
            if (token.isOperand()) {
                output.add(token);
            } else if (token.isOperator()) {
                while (!stack.isEmpty() &&
                        stack.peek().isOperator() &&
                        token.operator().precedence() <= stack.peek().operator().precedence()
                ) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.parentheses().isOpen()) {
                stack.push(token);
            } else {
                while (!stack.peek().isParentheses() || !stack.peek().parentheses().isOpen()) {
                    output.add(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }
}
