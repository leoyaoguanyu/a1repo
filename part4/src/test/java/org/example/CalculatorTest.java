package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void divideNormalNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    public void divideByZeroThrowsException() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}