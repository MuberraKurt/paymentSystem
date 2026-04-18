# Payment System (SOLID - OCP & SRP)

This project demonstrates how to integrate a new payment method into a simple payment flow using **SOLID principles**, especially **SRP** and **OCP**.

## Goal

- Extend the system with a new payment method without breaking existing structure
- Keep responsibilities clear and isolated

## Architecture

- `PaymentController`: receives payment requests and starts the flow
- `PaymentManager`: handles payment process orchestration
- `PaymentMethod` (interface): common contract for all payment methods
- `PaymentFactory`: creates the correct `PaymentMethod` by payment type
- `PaymentRequest`: carries payment data (`type`, `amount`)

## Payment Methods

- Existing method: `CreditCardPayment`
- Newly added method: `PayPalPayment`
- (Optional extension) `ApplePayPayment`

## SOLID Decisions

### SRP (Single Responsibility Principle)
Each class has one clear responsibility:
- Controller routes requests
- Manager coordinates the process
- Factory handles object creation
- Payment classes implement only their own payment logic

### OCP (Open/Closed Principle)
The system is open for extension via new `PaymentMethod` implementations.  
New methods can be added with minimal changes to existing flow.

## Run

Use `Application` as the entry point to test:
- `creditcard`
- `paypal`
- (optional) `applepay`

## Extending the System

To add a new payment method:
1. Create a class implementing `PaymentMethod`
2. Register/add it in `PaymentFactory`
3. Test it from `Application`

This design keeps the codebase simple, maintainable, and scalable for future payment integrations.