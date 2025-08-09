package dev.gutemberg.expression.evaluator.evaluators;

import dev.gutemberg.test.runner.annotations.Test;
import dev.gutemberg.test.runner.assertions.Assertions;

import static dev.gutemberg.test.runner.assertions.Assertions.assertEquals;

public class ExpressionEvaluatorTest {
    @Test
    public void shouldReturnCorrectValueWhenEvaluate1() {
        final var expression = "(1 + 3) / (3 + 2 * 2)";

        final var value = ExpressionEvaluator.evaluate(expression);

        Assertions.assertEquals(0.5714285714285714, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate2() {
        final var expression = "2 + 3 * 4";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(14.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate3() {
        final var expression = "(2 + 3) * 4";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(20.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate4() {
        final var expression = "(5 + 3) / (2 + 6)";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(1.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate5() {
        final var expression = "10 - 2 * 3 ";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(4.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate6() {
        final var expression = "(10 - 2) * 3";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(24.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate7() {
        final var expression = "100 / (5 * (2 + 3))";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(4.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate8() {
        final var expression = "(8 + 2 * 5) / (1 + 3 * 2 - 4)";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(6.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate9() {
        final var expression = "7 + 3 * (10 / (12 / (3 + 1) - 1))";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(22.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate10() {
        final var expression = "(3 + 4) * (5 - 2)";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(21.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate11() {
        final var expression = "-3 + 4";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(1.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate12() {
        final var expression = "-4 + 3";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(-1.0, value);
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluate13() {
        final var expression = "-10";

        final var value = ExpressionEvaluator.evaluate(expression);

        assertEquals(-10.0, value);
    }
}
