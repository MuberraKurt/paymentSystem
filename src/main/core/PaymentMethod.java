package main.core;

import main.entity.PaymentRequest;

public interface PaymentMethod {
    void pay(PaymentRequest request);
}
