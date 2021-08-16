package com.eldorado.resourceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eldorado.resourceservice.models.Coupon;
import com.eldorado.resourceservice.repository.CouponRepository;

@RestController
@RequestMapping("/couponapi")
@CrossOrigin
public class CouponRestController {
	
	@Autowired
	private CouponRepository repo;
	
	
	@RequestMapping(value = "/coupons",method = RequestMethod.POST)
//	@PreAuthorize("hasRole('ADMIN')")
	public Coupon create(@RequestBody Coupon coupon) {
		System.out.println(coupon);
		return repo.save(coupon);
	}
	
	@RequestMapping(value = "/coupons/{code}",method = RequestMethod.GET)
//	@PostAuthorize("returnObject.discount<60")
//	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}

}
