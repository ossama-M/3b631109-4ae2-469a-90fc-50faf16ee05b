package com.hackerrank.eshopping.service;

import com.hackerrank.eshopping.dto.request.ProductRequest;
import com.hackerrank.eshopping.dto.request.UpdateRequest;
import com.hackerrank.eshopping.entity.Product;
import com.hackerrank.eshopping.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository ;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public boolean CreateProduct(ProductRequest productRequest) {
        boolean present = productsRepository.findById(productRequest.getId()).isPresent();
        if(present) return false;
        System.out.println("not found in db");
        Product tempproduct = new Product(productRequest.getId(),
                productRequest.getName(),
                productRequest.getCategory(),
                productRequest.getRetailPrice(),
                productRequest.getDiscountedPrice(),
                productRequest.getAvailability());
        productsRepository.save(tempproduct);
        return true ;
    }

    public boolean updateProduct(UpdateRequest updateRequest, long id) {
        Product product = productsRepository.findById(id).orElse(new Product());
        if (Objects.isNull(product.getName()))
            return false ;
        product.setAvailability(updateRequest.getAvailability());
        product.setDiscountedPrice(updateRequest.getDiscountedPrice());
        product.setRetailPrice(updateRequest.getRetailPrice());
        productsRepository.save(product);
        return true ;
    }

    public List<ProductRequest> getAllProduct() {
        List<Product>products = productsRepository.findAll();
        return products.stream().map(prod ->mapToProductResponse(prod)).collect(Collectors.toList());
    }


    public ProductRequest getProdcutById(long id) {
        Product product=  productsRepository.findAllById(id).get();
        return new ProductRequest(product.getId()
                ,product.getName()
                ,product.getCategory()
                ,product.getRetailPrice()
                ,product.getDiscountedPrice(),product.getAvailability());

    }

    public List<ProductRequest> getAllProdcutByCategroy(String category) {
        List<Product>products = productsRepository.findAllByCategory(category);
        return products.stream().map(prod ->mapToProductResponse(prod)).collect(Collectors.toList());
    }

    private ProductRequest mapToProductResponse(Product product) {
        return new ProductRequest(product.getId(),product.getName()
                ,product.getCategory(),product.getRetailPrice()
                ,product.getDiscountedPrice()
                ,product.getAvailability());

    }
}
