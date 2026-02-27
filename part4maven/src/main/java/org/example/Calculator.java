public double divide(int x, int y) {
    if (y == 0) {
        throw new ArithmeticException("Division by zero");
    }
    // Explicit casting of both operands to ensure double-precision division
    return (double) x / (double) y;
}