package main.core;

import main.entity.PaymentRequest;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(PaymentRequest request) {
        System.out.println("Paying with credit card: " + request.getAmount());
    }
}
