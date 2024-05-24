package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Order")
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "Order_ID")
    private String Order_id;
    @Column(name = "Member_ID")
    private int Member_id;
    @Column(name = "Price")
    private int Price;
    @Column(name = "PayStatus")
    private boolean PayStatus;
}
