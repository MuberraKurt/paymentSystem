package main.core;

import java.io.InputStream;
import java.util.Properties;

public class PaymentFactory {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = PaymentFactory.class
                .getClassLoader()
                .getResourceAsStream("payment.properties")) {
            if (input == null) {
                throw new IllegalStateException("Payment properties file not found");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load payment properties", e);
        }
    }

    public static PaymentMethod create(String type) {
        String className = properties.getProperty(type.toLowerCase());

        if (className == null) {
            throw new IllegalArgumentException("Invalid payment type: " + type);
        }

        try {
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (!(instance instanceof PaymentMethod)) {
                throw new IllegalStateException(className + " does not implement PaymentMethod");
            }

            return (PaymentMethod) instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create payment method: " + className, e);
        }
    }
}