package main.core;

import main.entity.PaymentRequest;

public class PayPalPayment implements PaymentMethod{
    @Override
    public void pay(PaymentRequest request) {
        System.out.println("Payment with PayPal:" +request.getAmount());
    }
}
