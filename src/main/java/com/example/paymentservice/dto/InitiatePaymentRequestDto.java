package com.example.paymentservice.dto;

import lombok.Data;

@Data
public class InitiatePaymentRequestDto {
    private String email;
    private String phoneNumber;
    private double amount;
    private  Long orderId;
}
