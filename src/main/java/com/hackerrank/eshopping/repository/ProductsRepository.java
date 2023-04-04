package com.hackerrank.eshopping.repository;

import com.hackerrank.eshopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
