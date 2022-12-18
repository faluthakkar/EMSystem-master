package com.example.EMSystem.ServiceImpl;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.ConsumerService;
import com.example.EMSystem.entity.Consumer;
import com.example.EMSystem.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public Consumer saveConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @Override
    public List<Consumer> getAll() {
        return (List<Consumer>) consumerRepository.findAll();
    }

    @Override
    public Optional<Consumer> getById(Integer id) throws ResourceNotFoundException {
        Optional<Consumer> c = consumerRepository.findById(id);
        if (c.isPresent())
            return c;
        else
            throw new ResourceNotFoundException("Consumer", "Id", id);
    }

    @Override
    public Consumer update(Consumer consumer, Integer id) throws ResourceNotFoundException {
        Consumer c = consumerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Consumer", "Id", id));
        c.setFirstName(consumer.getFirstName());
        c.setLastName(consumer.getLastName());
        consumerRepository.save(c);
        return c;
    }

    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {
        if (consumerRepository.existsById(id)) {
            consumerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Consumer", "Id", id);
        }
    }
}