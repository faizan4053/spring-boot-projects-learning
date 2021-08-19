package com.outh2demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outh2demo.model.AuthUser;

@Repository
public interface UserRepo extends JpaRepository<AuthUser, Long>{
	
	Optional<AuthUser> findByUserName(String userName);
	
	Optional<AuthUser> findByUserNameOrEmail(String userName,String email);
	
}	
