# Payment System (SOLID: SRP & OCP)

This project implements a simple payment flow and demonstrates how to add new payment methods with minimal impact on existing code.

## Project Objective

- Keep the existing structure stable
- Add new payment methods in a SOLID-friendly way
- Focus on:
  - **SRP (Single Responsibility Principle)**
  - **OCP (Open/Closed Principle)**

## Simple Payment Flow

`Application` creates a payment request and sends it through:

1. `PaymentController`
2. `PaymentManager`
3. `PaymentFactory`
4. `PaymentMethod` implementation (`CreditCardPayment`, `PayPalPayment`, etc.)

## Core Components

- `PaymentController`  
  Accepts incoming payment requests and triggers the payment process.

- `PaymentManager`  
  Coordinates payment execution using a `PaymentMethod`.

- `PaymentMethod` (interface)  
  Defines the common contract for all payment methods.

- `PaymentFactory`  
  Creates the correct payment strategy according to payment type.

- `PaymentRequest`  
  Carries input data (`type`, `amount`).

## Implemented Payment Methods

- Existing: `CreditCardPayment`
- Added: `PayPalPayment`
- Optional extension: `ApplePayPayment`

## SOLID Design Notes

### SRP
Each class has one focused responsibility:
- Controller handles request routing
- Manager handles process orchestration
- Factory handles object creation
- Payment classes handle payment-specific behavior

### OCP
The system is open for extension via new `PaymentMethod` implementations.  
New payment methods can be added without changing the payment flow (`Controller`/`Manager`).

## Reflection + Properties (Optional Advanced Extension)

For better scalability, `PaymentFactory` can load payment class mappings from `payment.properties` and instantiate them with reflection.

Example:

```properties
creditcard=main.core.CreditCardPayment
paypal=main.core.PayPalPayment
