package com.example.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorTest {

    @Test
    void cardIsValid() {
        PaymentValidator v = new PaymentValidator();
        assertTrue(v.isPaymentMethodValid("card"));
    }

    @Test
    void paypalIsValid() {
        PaymentValidator v = new PaymentValidator();
        assertTrue(v.isPaymentMethodValid("paypal"));
    }

    @Test
    void cryptoIsInvalid() {
        PaymentValidator v = new PaymentValidator();
        assertFalse(v.isPaymentMethodValid("crypto"));
    }

    @Test
    void nullIsInvalid() {
        PaymentValidator v = new PaymentValidator();
        assertFalse(v.isPaymentMethodValid(null));
    }

    @Test
    void unknownMethodThrows() {
        PaymentValidator v = new PaymentValidator();
        assertThrows(UnsupportedOperationException.class,
                () -> v.isPaymentMethodValid("banktransfer"));
    }

    @Test
    void mixedCaseStillWorks() {
        PaymentValidator v = new PaymentValidator();
        assertTrue(v.isPaymentMethodValid("CaRd"));
    }
}