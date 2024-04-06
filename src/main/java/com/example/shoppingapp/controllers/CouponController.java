package com.example.shoppingapp.controllers;

import com.example.shoppingapp.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/fetchCoupons")
    public ResponseEntity<String> fetchCoupons() {
        String coupons = couponService.fetchCoupons();
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/fetchCoupons/{discountPercentage}")
    public ResponseEntity<String> fetchCouponsByDiscountPercentage(@PathVariable int discountPercentage) {
        String coupons = couponService.fetchCouponsByDiscountPercentage(discountPercentage);
        return ResponseEntity.ok(coupons);
    }
}
