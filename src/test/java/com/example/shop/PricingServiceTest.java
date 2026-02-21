package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PricingServiceTest {

    @Test
    void subtotalAddsUpItemTotals() {
        PricingService s = new PricingService();
        Order o = new Order();
        o.addItem(new OrderItem("Book", 2, 10.0)); // 20
        o.addItem(new OrderItem("Pen", 1, 5.0));   // 5
        assertEquals(25.0, s.calculateSubtotal(o), 1e-9);
    }

    @Test
    void taxOnPositiveSubtotalIsTwentyPercent() {
        PricingService s = new PricingService();
        assertEquals(20.0, s.calculateTax(100.0), 1e-9);
    }

    @Test
    void taxOnZeroIsZero() {
        PricingService s = new PricingService();
        assertEquals(0.0, s.calculateTax(0.0), 1e-9);
    }

    @Test
    void negativeSubtotalThrows() {
        PricingService s = new PricingService();
        assertThrows(IllegalArgumentException.class,
                () -> s.calculateTax(-0.01));
    }
}