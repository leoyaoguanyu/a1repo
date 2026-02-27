package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void validOrderIsPaidAndTotalMatchesExpected() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 50.0));
        order.addItem(new OrderItem("Pen", 1, 50.0));

        OrderService service = new OrderService();

        double total = service.processOrder(order, "STUDENT10", "card");

        // subtotal=100, discount=90, tax=18, total=108
        assertEquals(OrderStatus.PAID, order.getStatus());
        assertEquals(108.0, total, 1e-9);
    }

    @Test
    void invalidPaymentCancelsOrderAndReturnsZero() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        OrderService service = new OrderService();
        double total = service.processOrder(order, null, "crypto");

        assertEquals(OrderStatus.CANCELLED, order.getStatus());
        assertEquals(0.0, total, 1e-9);
    }

    @Test
    void cannotAddItemAfterPaid() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        OrderService service = new OrderService();
        service.processOrder(order, null, "card");

        assertEquals(OrderStatus.PAID, order.getStatus());
        assertThrows(IllegalStateException.class,
                () -> order.addItem(new OrderItem("Pen", 1, 10.0)));
    }

    @Test
    void invalidDiscountCodePropagatesException() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 100.0));

        OrderService service = new OrderService();

        assertThrows(IllegalArgumentException.class,
                () -> service.processOrder(order, "INVALID", "card"));
    }
}