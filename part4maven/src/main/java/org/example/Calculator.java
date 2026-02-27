package org.example;

public class Calculator {

    public double divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) x / (double) y;
    }
}
