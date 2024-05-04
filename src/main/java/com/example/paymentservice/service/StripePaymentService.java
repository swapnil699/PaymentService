package com.example.paymentservice.service;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService{

    @Override
    public void dopayment(String email, String phoneNumber, double amount, long orderId) throws Exception {

    }
}
