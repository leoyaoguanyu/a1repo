package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void totalPriceIsQuantityTimesUnitPrice() {
        OrderItem item = new OrderItem("Book", 3, 10.0);
        assertEquals(30.0, item.getTotalPrice(), 1e-9);
    }

    @Test
    void quantityMustBePositive() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Bad", 0, 10.0));
    }

    @Test
    void unitPriceCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Bad", 1, -0.01));
    }
}