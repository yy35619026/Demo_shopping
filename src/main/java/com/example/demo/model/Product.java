package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "Product_ID")
    private String id;
    @Column(name = "Product_Name")
    private String name;
    @Column(name = "Price")
    private int price;
    @Column(name = "Quantity")
    private int quantity;
}
