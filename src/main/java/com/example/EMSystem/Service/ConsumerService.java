package com.example.EMSystem.Service;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.entity.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConsumerService {
    Consumer saveConsumer(Consumer consumer);
    List<Consumer> getAll();
    Optional<Consumer> getById(Integer id) throws ResourceNotFoundException;
    Consumer update(Consumer consumer,Integer id) throws ResourceNotFoundException;
    void deleteById(Integer id) throws ResourceNotFoundException;
}
