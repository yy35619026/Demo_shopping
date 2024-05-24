package com.example.demo.DAO;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
//    List<Product> findAll();
//    List<Product> findById(String id);
}
