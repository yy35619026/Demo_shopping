package com.example.demo.JPA;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
//    List<Product> findAll();
//    List<Product> findById(String id);
}
