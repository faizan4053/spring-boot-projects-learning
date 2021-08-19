package com.springsecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
