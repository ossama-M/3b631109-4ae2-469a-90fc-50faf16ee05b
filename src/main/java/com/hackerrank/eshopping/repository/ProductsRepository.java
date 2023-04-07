package com.hackerrank.eshopping.repository;

import com.hackerrank.eshopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    Optional<Product> findAllById(Long id);

    @Query(value = "SELECT * from product p where p.category =:category order by p.availability asc, p.discountedPrice desc, p.id desc", nativeQuery = true)
    List<Product> findAllByCategory(@Param("category") String category);
}
