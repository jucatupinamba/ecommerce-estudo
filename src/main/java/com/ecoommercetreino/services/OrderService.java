package com.ecoommercetreino.services;

import com.ecoommercetreino.entities.Order;
import com.ecoommercetreino.entities.User;
import com.ecoommercetreino.repositories.OrderRepository;
import com.ecoommercetreino.repositories.UserRepository;
import com.ecoommercetreino.services.exceptions.DataBaseException;
import com.ecoommercetreino.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
            return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Order insert(Order obj) {
        return orderRepository.save(obj);
    }

    public void delete(Long id){
        try{
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order obj){
        try {
            Order entity = orderRepository.getReferenceById(id);
            updateData(entity, obj);
            return orderRepository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order entity, Order obj) {
        entity.setClient(obj.getClient());
        entity.setOrderStatus(obj.getOrderStatus());
        entity.setPayment(obj.getPayment());
        entity.setMoment(obj.getMoment());
    }
}
