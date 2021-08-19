package com.eldorado.resourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldorado.resourceservice.models.AuthUser;

public interface UserRepository extends JpaRepository<AuthUser, Long>{
	
	public AuthUser findByEmail(String email);

}
