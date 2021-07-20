package com.mhdgp.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhdgp.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
