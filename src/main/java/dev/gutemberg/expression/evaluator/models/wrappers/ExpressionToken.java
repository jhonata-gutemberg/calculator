package dev.gutemberg.expression.evaluator.models.wrappers;

import dev.gutemberg.expression.evaluator.models.enums.Operator;
import dev.gutemberg.expression.evaluator.models.enums.Parentheses;

public record ExpressionToken(Double operand, Operator operator, Parentheses parentheses) {
    public static ExpressionToken from(final Double operand) {
        return new ExpressionToken(operand, null, null);
    }

    public static ExpressionToken from(final Operator operator) {
        return new ExpressionToken(null, operator, null);
    }

    public static ExpressionToken from(final Parentheses parentheses) {
        return new ExpressionToken(null, null, parentheses);
    }

    public boolean isOperand() {
        return operand != null;
    }

    public boolean isOperator() {
        return operator != null;
    }

    public boolean isParentheses() {
        return parentheses != null;
    }
}
