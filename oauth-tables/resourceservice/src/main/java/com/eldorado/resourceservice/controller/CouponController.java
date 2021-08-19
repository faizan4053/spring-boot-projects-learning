package com.eldorado.resourceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eldorado.resourceservice.models.Coupon;
import com.eldorado.resourceservice.repository.CouponRepository;

@Controller
public class CouponController {
	
	@Autowired
	private CouponRepository repo;
	
	@GetMapping("/showCreateCoupon")
	@PreAuthorize("hasRole('ADMIN')")
	public String showCreateCoupon() {
		return "createCoupon";
	}
	
	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		repo.save(coupon);
		return "createResponse";
	}
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon(){
		return "getCoupon";
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView modelAndView = new ModelAndView("couponDetails");
		modelAndView.addObject(repo.findByCode(code));
		return modelAndView;
	}

}
