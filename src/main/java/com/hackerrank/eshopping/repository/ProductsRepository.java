package com.hackerrank.eshopping.repository;

import com.hackerrank.eshopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    Optional<Product> findAllById(Long id);
}
