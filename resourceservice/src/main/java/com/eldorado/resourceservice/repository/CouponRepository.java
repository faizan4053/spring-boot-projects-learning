package com.eldorado.resourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldorado.resourceservice.models.Coupon;

/*
 * Coupon Repository is just for testing pupose
 * Later It will be removed
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
