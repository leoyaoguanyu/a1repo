@Test
public void divideNormalNumbers() {
    Calculator calc = new Calculator();
    // Normal case: 6 / 3 = 2.0
    assertEquals(2.0, calc.divide(6, 3));
}

@Test
public void divideByZeroThrowsException() {
    Calculator calc = new Calculator();
    // Boundary case: y = 0 must throw ArithmeticException
    assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
}
