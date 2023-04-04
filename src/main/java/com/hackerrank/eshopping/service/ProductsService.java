package com.hackerrank.eshopping.service;

import com.hackerrank.eshopping.dto.ProductRequest;
import com.hackerrank.eshopping.dto.ProductResponseList;
import com.hackerrank.eshopping.model.Product;
import com.hackerrank.eshopping.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository ;
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public boolean CreateProduct(ProductRequest productRequest) {
        boolean present = productsRepository.findById(productRequest.getId()).isPresent();
        if(present) return false;

        Product tempproduct = new Product(productRequest.getId(),
                productRequest.getName(),
                productRequest.getCategory(),
                productRequest.getRetailPrice(),
                productRequest.getDiscountedPrice(),
                productRequest.getAvailability());
        productsRepository.save(tempproduct);
        return true ;
    }

    public boolean updateProduct(ProductRequest productRequest, long id) {
        boolean present = productsRepository.findById(id).isPresent();
        if(!present) return false;

        Product tempproduct = new Product(id,
                productRequest.getName(),
                productRequest.getCategory(),
                productRequest.getRetailPrice(),
                productRequest.getDiscountedPrice(),
                productRequest.getAvailability());
        productsRepository.save(tempproduct);
        return true ;
    }

    public List<ProductRequest> getAllProduct() {
        List<Product>products = productsRepository.findAll();
        return products.stream().map(prod ->mapToProductResponse(prod)).toList();
    }
    private ProductRequest mapToProductResponse(Product product) {
        return new ProductRequest(product.getId(),product.getName()
                ,product.getCategory(),product.getRetailPrice()
                ,product.getDiscountedPrice()
                ,product.getAvailability());

    }
}
