package com.example.EMSystem.repository;

import com.example.EMSystem.entity.Consumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer,Integer> {
}
