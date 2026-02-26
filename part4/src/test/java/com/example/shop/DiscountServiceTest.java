package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    @Test
    void student10AppliesNineTenths() {
        DiscountService s = new DiscountService();
        assertEquals(90.0, s.applyDiscount(100.0, "STUDENT10"), 1e-9);
    }

    @Test
    void blackFridayAppliesSevenTenths() {
        DiscountService s = new DiscountService();
        assertEquals(70.0, s.applyDiscount(100.0, "BLACKFRIDAY"), 1e-9);
    }

    @Test
    void nullCodeNoDiscount() {
        DiscountService s = new DiscountService();
        assertEquals(100.0, s.applyDiscount(100.0, null), 1e-9);
    }

    @Test
    void blankCodeNoDiscount() {
        DiscountService s = new DiscountService();
        assertEquals(100.0, s.applyDiscount(100.0, "   "), 1e-9);
    }

    @Test
    void invalidCodeThrows() {
        DiscountService s = new DiscountService();
        assertThrows(IllegalArgumentException.class,
                () -> s.applyDiscount(100.0, "INVALID"));
    }

    @Test
    void unknownCodeNoDiscount() {
        DiscountService s = new DiscountService();
        assertEquals(100.0, s.applyDiscount(100.0, "WELCOME"), 1e-9);
    }

    @Test
    void lowercaseCodeStillWorks() {
        DiscountService s = new DiscountService();
        assertEquals(90.0, s.applyDiscount(100.0, "student10"), 1e-9);
    }
}