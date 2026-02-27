package com.example.shop;

public class PricingService {

    public double calculateSubtotal(Order order) {
        double total = 0.0;
        for (OrderItem item : order.getItems()) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double calculateTax(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("Subtotal cannot be negative");
        }
        return subtotal * 0.2;
    }
}