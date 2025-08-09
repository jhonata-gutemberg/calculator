package dev.gutemberg.calculator.parsers;

import dev.gutemberg.calculator.models.enums.Operator;
import dev.gutemberg.calculator.models.enums.Parentheses;
import dev.gutemberg.calculator.models.wrappers.ExpressionToken;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTokenParser {
    public static List<ExpressionToken> parse(final String expression) {
        final List<ExpressionToken> tokens = new ArrayList<>();
        var operandBuilder = new StringBuilder();
        for (final char c: expression.toCharArray()) {
            if (c >= '0' && c <= '9') {
                operandBuilder.append(c);
            } else if (Operator.equals(c)) {
                if (!operandBuilder.isEmpty()) {
                    tokens.add(ExpressionToken.from(Double.parseDouble(operandBuilder.toString())));
                    operandBuilder = new StringBuilder();
                }
                tokens.add(ExpressionToken.from(Operator.from(c)));
            } else if (Parentheses.equals(c)) {
                if (!operandBuilder.isEmpty()) {
                    tokens.add(ExpressionToken.from(Double.parseDouble(operandBuilder.toString())));
                    operandBuilder = new StringBuilder();
                }
                tokens.add(ExpressionToken.from(Parentheses.from(c)));
            }
        }
        return tokens;
    }
}
