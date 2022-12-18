package com.example.EMSystem.repository;

import com.example.EMSystem.entity.ConnectionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionTypeRespository extends CrudRepository<ConnectionType,Integer> {
}
