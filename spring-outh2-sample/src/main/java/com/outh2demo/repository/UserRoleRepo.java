package com.outh2demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.outh2demo.model.AuthRole;

@Repository
public interface UserRoleRepo extends JpaRepository<AuthRole, Long>{
	
	AuthRole findByRoleNameContaining(String roleName);

}
