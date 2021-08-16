package com.eldorado.resourceservice.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static final String RESOURCE_ID = "couponservice";
	
//	@Value("${publicKey}")
//	private String publicKey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//		resources.resourceId(RESOURCE_ID);
		
//		for symmetric encryption
		resources.resourceId(RESOURCE_ID).tokenStore(tokenStore());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupons/**").hasAnyRole("USER","ADMIN")
//		.mvcMatchers(HttpMethod.GET,"/showCreateCoupon","/createCoupon","createResponse").hasRole("ADMIN")
//		.mvcMatchers(HttpMethod.POST,"/getCoupon").hasAnyRole("USER","ADMIN")
		.mvcMatchers(HttpMethod.POST, "/couponapi/coupons").hasRole("ADMIN")
//		.mvcMatchers("/","/login","/showReg","/registerUser").permitAll()
		.anyRequest().denyAll().and().csrf().disable()
//		.logout().logoutSuccessUrl("/")
		;
	}
	
	
//1)When Public key is fetch from peoperties file
//	@Bean
//	public TokenStore tokenStore() {
//		return new JwtTokenStore(jwtAccessTokenConverter());
//	}
//
//	@Bean
//	public JwtAccessTokenConverter jwtAccessTokenConverter() {
//		JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
//		jwtAccessTokenConverter.setVerifierKey(publicKey);;
//		return jwtAccessTokenConverter;
//	}
	
	
//2) no need of above funtions in case of Asymmetric (public - private )	
	
//3) for symmetric encryption using only private keys
	
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
//		jwtAccessTokenConverter.setVerifierKey(publicKey);
		jwtAccessTokenConverter.setSigningKey("testKey");
		return jwtAccessTokenConverter;
	}
	

}