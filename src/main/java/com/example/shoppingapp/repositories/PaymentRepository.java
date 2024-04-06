package com.example.shoppingapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingapp.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long orderId);

	List<Payment> findByUserId(Long userId);

	Payment findByUserIdAndOrderId(Long userId, Long orderId);
}
