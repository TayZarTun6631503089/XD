package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LastInfo;

@Repository
public interface LastInfoRepo extends CrudRepository<LastInfo, Long>{

}
