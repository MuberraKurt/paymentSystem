package main;

import main.controller.PaymentController;
import main.entity.PaymentRequest;

public class Application {
    public static void main(String[] args) {
        PaymentController controller = new PaymentController();

        try {
            controller.makePayment(new PaymentRequest("creditcard", 150.0));
            controller.makePayment(new PaymentRequest("paypal", 350.0));
            // controller.makePayment(new PaymentRequest("applepay", 420.0)); // enable only if configured
        } catch (Exception e) {
            System.err.println("Payment failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}