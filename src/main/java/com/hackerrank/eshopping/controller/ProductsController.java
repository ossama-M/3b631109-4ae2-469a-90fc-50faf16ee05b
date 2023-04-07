package com.hackerrank.eshopping.controller;

import com.hackerrank.eshopping.dto.request.ProductRequest;
import com.hackerrank.eshopping.dto.request.UpdateRequest;
import com.hackerrank.eshopping.exception.ErrorModel;
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
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest) throws Exception{
        boolean create  = productsService.CreateProduct(productRequest);
        if (create == false)

            return new ResponseEntity<>(null, HttpStatus.valueOf(400));
        else
            return new ResponseEntity<>(productRequest, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateRequest> updateProduct(@RequestBody UpdateRequest updateRequest, @PathVariable long id) throws Exception{
        boolean update  = productsService.updateProduct(updateRequest,id);
        if (update== false)
            return new ResponseEntity<>(null, HttpStatus.valueOf(404));
        else
            return new ResponseEntity<>(updateRequest, HttpStatus.valueOf(200));

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRequest> getAllProduct(){
        System.out.println("all");
        return productsService.getAllProduct();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductRequest getAllProduct(@PathVariable long id){
        System.out.println("in id ");

        return productsService.getProdcutById(id);
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRequest> getAllProductByCategory(@PathVariable String category){
        System.out.println("in categroy");
        return productsService.getAllProdcutByCategroy(category);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorModel> handleException(RuntimeException ex){
        ErrorModel error = new ErrorModel(HttpStatus.FORBIDDEN.value(),ex.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    }




}
