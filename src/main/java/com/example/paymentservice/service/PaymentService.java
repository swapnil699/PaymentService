package com.example.paymentservice.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    void dopayment(String email,String phoneNumber, double amount, long orderId) throws Exception;
}
