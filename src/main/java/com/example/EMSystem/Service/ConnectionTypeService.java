package com.example.EMSystem.Service;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.entity.ConnectionType;
import com.example.EMSystem.entity.Consumer;

import java.util.List;
import java.util.Optional;

public interface ConnectionTypeService  {
    ConnectionType save(ConnectionType type);
    List<ConnectionType> getAll();
    Optional<ConnectionType> getById(Integer id) throws ResourceNotFoundException;

    ConnectionType update(ConnectionType connectionType, Integer id) throws ResourceNotFoundException;


}
