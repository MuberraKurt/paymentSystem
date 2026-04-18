package main;

import main.controller.PaymentController;
import main.entity.PaymentRequest;

public class Application {
    public static void main(String[] args) {
        PaymentController controller = new PaymentController();

        controller.makePayment(new PaymentRequest("creditcard", 150.0));
        controller.makePayment(new PaymentRequest("paypal", 350.0));
    }
}
