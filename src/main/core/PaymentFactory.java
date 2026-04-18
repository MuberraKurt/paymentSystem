package main.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {

    private static final Map<String, Supplier<PaymentMethod>> paymentMethods = new HashMap<>();

    static {
        paymentMethods.put("creditcard", CreditCardPayment::new);
        paymentMethods.put("paypal", PayPalPayment::new);
    }

    public static PaymentMethod create(String type) {
        Supplier<PaymentMethod> paymentMethod = paymentMethods.get(type.toLowerCase());
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Invalid payment type");
        }
        return paymentMethod.get();
    }

    public  static void register( String type, Supplier<PaymentMethod> paymentMethod){
        paymentMethods.put(type.toLowerCase(), paymentMethod);
    }
}
