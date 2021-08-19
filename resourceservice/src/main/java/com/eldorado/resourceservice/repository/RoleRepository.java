package com.eldorado.resourceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldorado.resourceservice.models.Role;

/*
 * Jpa repository for User Roles
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

}
