package com.example.demo.Service;

import com.example.demo.DAO.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //GET All
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    //GET by ID
    public ResponseEntity<Product> getProduct(String id){
        return productRepository.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElse(ResponseEntity.notFound().build());    }
    //POST
    public ResponseEntity<Product> createProduct(Product product){
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }
    //PUT
    public ResponseEntity<Void> updateProduct(Product request, String id){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setQuantity(request.getQuantity());
            productRepository.save(product);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    //Delete
    public ResponseEntity<Void> deleteProduct(String id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
