package main.controller;

import main.business.PaymentManager;
import main.core.PaymentFactory;
import main.core.PaymentMethod;
import main.entity.PaymentRequest;

public class PaymentController {
    public  void makePayment(PaymentRequest request) {
        PaymentMethod method = PaymentFactory.create(request.getType());
        new PaymentManager(method).pay(request);
    }
}
