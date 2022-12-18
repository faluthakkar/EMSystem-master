package com.example.EMSystem.Service;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.entity.Connections;

import java.util.List;
import java.util.Optional;

public interface ConnectionService {

    Connections saveConnection(Connections connections);
    List<Connections> getAll();
    Optional<Connections> getById(Integer id) throws ResourceNotFoundException;
    void deleteById(Integer id) throws ResourceNotFoundException;
}
