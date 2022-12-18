package com.example.EMSystem.ServiceImpl;

import com.example.EMSystem.Exception.ResourceNotFoundException;
import com.example.EMSystem.Service.ConnectionTypeService;
import com.example.EMSystem.entity.ConnectionType;
import com.example.EMSystem.entity.Consumer;
import com.example.EMSystem.repository.ConnectionTypeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnectionTypeServiceImpl implements ConnectionTypeService {

    @Autowired
    private ConnectionTypeRespository connectionTypeRespository;
    @Override
    public ConnectionType save(ConnectionType type) {
        return connectionTypeRespository.save(type);
    }

    @Override
    public List<ConnectionType> getAll() {
        return (List<ConnectionType>) connectionTypeRespository.findAll();
    }

    @Override
    public Optional<ConnectionType> getById(Integer id) throws ResourceNotFoundException {
        Optional<ConnectionType> c = connectionTypeRespository.findById(id);
        if (c.isPresent())
            return c;
        else
            throw new ResourceNotFoundException("Connection-Type", "Id", id);
    }

    @Override
    public ConnectionType update(ConnectionType connectionType, Integer id) throws ResourceNotFoundException {
        ConnectionType c = connectionTypeRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("Connection-Type", "Id", id));
        c.setFixedCharge(connectionType.getFixedCharge());
        c.setPerUnitCharge(connectionType.getPerUnitCharge());
        return c;
    }


}
