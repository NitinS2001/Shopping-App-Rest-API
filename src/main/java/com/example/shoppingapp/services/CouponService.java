package com.example.shoppingapp.services;

import com.example.shoppingapp.models.Coupon;
import com.example.shoppingapp.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public String fetchCoupons() {
        List<Coupon> coupons = couponRepository.findAll();
        StringBuilder couponDetails = new StringBuilder();
        for (Coupon coupon : coupons) {
            couponDetails.append("Coupon Code: ").append(coupon.getCode())
                         .append(", Discount Percentage: ").append(coupon.getDiscountPercentage())
                         .append("%\n");
        }
        return couponDetails.toString();
    }

    public String fetchCouponsByDiscountPercentage(int discountPercentage) {
        List<Coupon> coupons = couponRepository.findByDiscountPercentage(discountPercentage);
        StringBuilder couponDetails = new StringBuilder();
        for (Coupon coupon : coupons) {
            couponDetails.append("Coupon Code: ").append(coupon.getCode())
                         .append(", Discount Percentage: ").append(coupon.getDiscountPercentage())
                         .append("%\n");
        }
        return couponDetails.toString();
    }

    // Other methods for coupon management
}
