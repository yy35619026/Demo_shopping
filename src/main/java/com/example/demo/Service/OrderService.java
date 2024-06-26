package com.example.demo.Service;

import com.example.demo.DAO.OrderRepository;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") int orderID){
        return orderRepository.findById(orderID)
                .map(order -> ResponseEntity.ok().body(order))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable("id") int orderID, @RequestBody Order request) {
        Optional<Order> orderOptional = orderRepository.findById(orderID);
        if(orderOptional.isPresent()){
            Order order = orderOptional.get();
            order.setMember_id(request.getMember_id());
            order.setPrice(request.getPrice());
            order.setPayStatus(request.isPayStatus());
            orderRepository.save(order);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int orderID) {
        if(orderRepository.existsById(orderID)){
            orderRepository.deleteById(orderID);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
