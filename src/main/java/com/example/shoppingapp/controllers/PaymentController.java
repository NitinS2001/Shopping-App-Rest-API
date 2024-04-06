package com.example.shoppingapp.controllers;

import com.example.shoppingapp.models.Payment;
import com.example.shoppingapp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable long userId) {
        List<Payment> payments = paymentService.getPaymentsByUserId(userId);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/payments/{userId}/{orderId}")
    public ResponseEntity<Payment> getPaymentByOrderId(@PathVariable long userId, @PathVariable long orderId) {
        Payment payment = paymentService.getPaymentByOrderId(userId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
