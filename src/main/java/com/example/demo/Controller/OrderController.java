package com.example.demo.Controller;

import com.example.demo.Service.OrderService;
import com.example.demo.model.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order API")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        return orderService.getAllOrder();
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") int orderID){
        return orderService.getOrder(orderID);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable("id") int orderID, @RequestBody Order request) {
        return orderService.updateOrder(orderID, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int orderID) {
        return orderService.deleteOrder(orderID);
    }
}
