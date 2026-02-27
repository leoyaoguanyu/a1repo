package com.example.shop;

public class OrderService {

    private final PaymentValidator paymentValidator = new PaymentValidator();
    private final DiscountService discountService = new DiscountService();
    private final PricingService pricingService = new PricingService();

    public double processOrder(Order order, String discountCode, String paymentMethod) {

        boolean validPayment;

        try {
            validPayment = paymentValidator.isPaymentMethodValid(paymentMethod);
        } catch (UnsupportedOperationException ex) {
            validPayment = false;
        }

        if (!validPayment) {
            order.setStatus(OrderStatus.CANCELLED);
            return 0.0;
        }

        double subtotal = pricingService.calculateSubtotal(order);
        double discounted = discountService.applyDiscount(subtotal, discountCode);
        double tax = pricingService.calculateTax(discounted);
        double total = discounted + tax;

        order.setStatus(OrderStatus.PAID);
        return total;
    }
}