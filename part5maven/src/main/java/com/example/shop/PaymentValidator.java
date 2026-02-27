package com.example.shop;

public class PaymentValidator {

    public boolean isPaymentMethodValid(String method) {

        if (method == null || method.trim().isEmpty()) {
            return false;
        }

        String m = method.trim().toLowerCase();

        switch (m) {
            case "card":
            case "paypal":
                return true;
            case "crypto":
                return false;
            default:
                throw new UnsupportedOperationException("Unknown payment method");
        }
    }
}