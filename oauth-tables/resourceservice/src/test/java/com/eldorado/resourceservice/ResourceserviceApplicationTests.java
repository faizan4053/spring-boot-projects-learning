package com.eldorado.resourceservice;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ResourceserviceApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void testGetCouponWithoutAuth_Forbidden() throws Exception {
		mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser
	void testGetCouponWithoutAuth_Success() throws Exception {
		mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles = { "ADMIN" })
	void testGetCouponWithoutAuthRoleADMIN_Success() throws Exception {
		mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isOk());
	}

	@Test
//	@WithMockUser(roles = { "USER" })
	@WithUserDetails("doug@bailey.com")
	void testGetCouponWithoutAuthRoleUSER_Success() throws Exception {
		mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isOk()).andExpect(
				content().string("{\"id\":1,\"code\":\"SUPERSALE\",\"discount\":10.00,\"expDate\":\"12/12/2021\"}"));
	}

	@Test
	@WithMockUser(roles = { "ADMIN" })
	void testGetCoupon_WithoutCSRF_Forbidden() throws Exception {
		mvc.perform(post("/couponapi/coupons/")
				.content("{\"code\":\"SUPERSALE5\",\"discount\":10.00,\"expDate\":\"12/12/2021\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles = { "ADMIN" })
	@Ignore
	void testGetCoupon_WithCSRF_Forbidden() throws Exception {
		mvc.perform(post("/couponapi/coupons/")
				.content("{\"code\":\"SUPERSALE6\",\"discount\":10.00,\"expDate\":\"12/12/2021\"}")
				.contentType(MediaType.APPLICATION_JSON).with(csrf().asHeader())).andExpect(status().isOk());
	}

//	@Test
//	@WithMockUser(roles = { "USER" })
//	void testGetCoupon_WithCSRF_NonAdminUser_Forbidden() throws Exception {
//		mvc.perform(post("/couponapi/coupons/")
//				.content("{\"code\":\"SUPERSALE5\",\"discount\":10.00,\"expDate\":\"12/12/2021\"}")
//				.contentType(MediaType.APPLICATION_JSON).with(csrf().asHeader())).andExpect(status().isForbidden());
//	}

//	@Test
//	@WithMockUser(roles = { "ADMIN" })
//	void testCors() throws Exception {
//
//		mvc.perform(options("/couponapi/coupons/").header("Access-Control-Request-Method", "POST")
//				.header("Origin","www.sapient.com")).andExpect(status().isOk())
//				.andExpect(header().exists("Access-Control-Allow-Origin"))
//				.andExpect(header().string("Access-Control-Allow-Origin","*"))
//				.andExpect(header().exists("Access-Control-Allow-Methods"))
//				.andExpect(header().string("Access-Control-Allow-Methods","POST"))
//					
//		;
//
//	}
}
