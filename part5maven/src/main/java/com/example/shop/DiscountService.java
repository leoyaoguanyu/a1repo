package com.example.shop;

public class DiscountService {

    public double applyDiscount(double amount, String code) {

        if (code == null || code.trim().isEmpty()) {
            return amount;
        }

        String normalized = code.trim().toUpperCase();

        if (normalized.equals("INVALID")) {
            throw new IllegalArgumentException("Invalid discount code");
        }

        if (normalized.equals("STUDENT10")) {
            return amount * 0.9;
        }

        if (normalized.equals("BLACKFRIDAY")) {
            return amount * 0.7;
        }

        return amount;
    }
}