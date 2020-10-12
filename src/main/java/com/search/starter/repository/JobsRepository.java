package com.search.starter.repository;

import com.search.starter.data.JobsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepository extends MongoRepository<JobsEntity, Integer> {
  // JobsEntity findByExtId(String extId);
} 