package com.example.EMSystem.repository;

import com.example.EMSystem.entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill,Integer> {
}
