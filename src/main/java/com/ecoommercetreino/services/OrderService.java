package com.ecoommercetreino.services;

import com.ecoommercetreino.entities.Order;
import com.ecoommercetreino.entities.User;
import com.ecoommercetreino.repositories.OrderRepository;
import com.ecoommercetreino.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById (Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
