package com.example.EMSystem.ServiceImpl;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.ConnectionService;
import com.example.EMSystem.entity.ConnectionType;
import com.example.EMSystem.entity.Connections;
import com.example.EMSystem.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public Connections saveConnection(Connections connections) {
        return connectionRepository.save(connections);
    }

    @Override
    public List<Connections> getAll() {
        return (List<Connections>) connectionRepository.findAll();
    }

    @Override
    public Optional<Connections> getById(Integer id) throws ResourceNotFoundException {
        Optional<Connections> c = connectionRepository.findById(id);
        if (c.isPresent())
            return c;
        else
            throw new ResourceNotFoundException("Connection", "Id", id);
    }


    @Override
    public void deleteById(Integer id) throws ResourceNotFoundException {
        if (connectionRepository.existsById(id)) {
            connectionRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Connection", "Id", id);
        }
    }
}


