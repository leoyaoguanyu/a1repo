@Test
public void divideNegativeNumbers() {
    // Testing negative dividend and divisor
    assertEquals(-2.0, calc.divide(-6, 3));
    assertEquals(2.0, calc.divide(-6, -3));
}

@Test
public void divideDecimalResult() {
    // Verifying that 5 / 2 yields 2.5 instead of 2.0
    assertEquals(2.5, calc.divide(5, 2), 0.001);
}
