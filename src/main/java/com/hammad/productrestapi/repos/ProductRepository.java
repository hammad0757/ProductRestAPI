package com.hammad.productrestapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hammad.productrestapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
