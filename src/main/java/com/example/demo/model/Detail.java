package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detail")
@Getter
@Setter
public class Detail {
    @Id
    @GeneratedValue
    private int OrderItemSN;
    @Column(name = "Order_ID")
    private String OrderId;
    @Column(name = "Price")
    private int Price;
    @Column(name = "StandPrice")
    private int StandPrice;
    @Column(name = "ItemPrice")
    private int ItemPrice;
}
