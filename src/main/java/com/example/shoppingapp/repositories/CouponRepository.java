package com.example.shoppingapp.repositories;

import com.example.shoppingapp.models.Coupon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String code);

	List<Coupon> findByDiscountPercentage(int discountPercentage);
}
