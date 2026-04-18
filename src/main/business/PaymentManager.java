package main.business;

import main.core.PaymentMethod;
import main.entity.PaymentRequest;

public class PaymentManager {
    private PaymentMethod paymentMethod;

    public  PaymentManager(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void pay(PaymentRequest request){
        paymentMethod.pay(request);
    }
}
