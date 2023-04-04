package com.hackerrank.eshopping.controller;

import com.hackerrank.eshopping.dto.ProductRequest;
import com.hackerrank.eshopping.dto.ProductResponseList;
import com.hackerrank.eshopping.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService ;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest){
        boolean create  = productsService.CreateProduct(productRequest);
        if (create= false)
                return new ResponseEntity<>(productRequest, HttpStatus.valueOf(400));
        else
            return new ResponseEntity<>(productRequest, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductRequest> updateProduct(@RequestBody ProductRequest productRequest,@PathVariable long id){
        boolean update  = productsService.updateProduct(productRequest,id);
        if (update= false)
            return new ResponseEntity<>(productRequest, HttpStatus.valueOf(400));
        else
            return new ResponseEntity<>(productRequest, HttpStatus.valueOf(200));

    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRequest> getAllProduct(){

        return productsService.getAllProduct();
    }




}
