package dev.gutemberg.expression.evaluator.evaluators;

import dev.gutemberg.test.readers.CSVResourceReader;
import dev.gutemberg.test.runner.annotations.Test;
import dev.gutemberg.test.runner.assertions.Assertions;
import java.io.IOException;
import java.util.Map;

import static dev.gutemberg.expression.evaluator.evaluators.ExpressionEvaluator.evaluate;
import static dev.gutemberg.test.runner.assertions.Assertions.assertEquals;

public class ExpressionEvaluatorTest {
    @Test
    public void shouldReturnCorrectValueWhenEvaluate() throws IOException {
        CSVResourceReader.read("expression-evaluator-test-cases.csv", "=")
                .forEach(line -> {
                    final var expression = line[0];
                    final var expectedValue = Double.parseDouble(line[1]);

                    final var actualValue = evaluate(expression);

                    Assertions.assertEquals(expectedValue, actualValue);
                });
    }

    @Test
    public void shouldReturnCorrectValueWhenEvaluateWithVariables() {
        final var expression = """
                1 +
                (
                    availableOnlineOrders + availableOfflineOrders + availableCashOrders -
                        (
                            futureAllocationOfflineOrders +
                            futureAllocationOnlineOrders +
                            futureAllocationCashOrders +
                            availableDrivers
                        )
                )
                /
                (availableDrivers + workingDrivers)
                """;

        final var value = evaluate(
                expression,
                Map.of(
                        "availableOnlineOrders", 100.0,
                        "availableOfflineOrders", 150.0,
                        "availableCashOrders", 73.0,
                        "futureAllocationOfflineOrders", 100.0,
                        "futureAllocationOnlineOrders", 80.0,
                        "futureAllocationCashOrders", 45.0,
                        "availableDrivers", 37.0,
                        "workingDrivers", 20.0
                )
        );

        assertEquals(2.0701754385964914, value);
    }
}
