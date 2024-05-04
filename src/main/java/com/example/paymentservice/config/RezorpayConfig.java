package com.example.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RezorpayConfig {

    @Value(value = "${rezorpay.key.id}")
    private String rezorpayKeyId;
    @Value("${rezorpay.key.secret}")
    private String rezorpayKeySecret;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(rezorpayKeyId, rezorpayKeySecret);
    }
}
