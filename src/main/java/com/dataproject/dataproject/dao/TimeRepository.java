package com.dataproject.dataproject.dao;

import com.dataproject.dataproject.model.*;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeRepository extends MongoRepository<Time, String> {

}
