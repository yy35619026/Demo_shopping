package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(path = "/products")
@Tag(name = "Product API")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productID){
        return productService.getProduct(productID);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") String productID, @RequestBody Product request) {
        return productService.updateProduct(request, productID);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String productID) {
        return productService.deleteProduct(productID);
    }
}
