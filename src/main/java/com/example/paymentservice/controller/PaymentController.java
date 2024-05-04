package com.example.paymentservice.controller;

import com.example.paymentservice.dto.InitiatePaymentRequestDto;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentService razorpayPaymentService;
    PaymentService stripePaymentService;

    public PaymentController(@Qualifier("razorpay") PaymentService razorpayPaymentService,
                             @Qualifier("stripe") PaymentService stripePaymentService) {
        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
    }

    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws Exception{
        getPaymentService().dopayment(initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getPhoneNumber(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getOrderId());

        return "Success";
    }

    private PaymentService getPaymentService() {
        if (Math.random() > 0.4) {
            return razorpayPaymentService;
        } else {
            return stripePaymentService;
        }
    }
}
