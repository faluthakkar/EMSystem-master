package com.example.EMSystem.repository;


import com.example.EMSystem.entity.DateTimeInfo;
import org.springframework.data.repository.CrudRepository;

public interface DateTimeRepository extends CrudRepository<DateTimeInfo,Integer> {
}
