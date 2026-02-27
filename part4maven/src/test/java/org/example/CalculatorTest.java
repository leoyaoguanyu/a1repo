package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    public void divideNormalNumbers() {
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    public void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    public void divideNegativeNumbers() {
        assertEquals(-2.0, calc.divide(-6, 3));
        assertEquals(2.0, calc.divide(-6, -3));
    }

    @Test
    public void divideDecimalResult() {
        assertEquals(2.5, calc.divide(5, 2), 0.0001);
    }
}
