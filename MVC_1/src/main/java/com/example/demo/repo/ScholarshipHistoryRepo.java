package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ScholarshipHistory;


@Repository
public interface ScholarshipHistoryRepo extends CrudRepository<ScholarshipHistory, Long>{

}
