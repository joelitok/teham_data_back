package com.dataproject.dataproject.dao;


import com.dataproject.dataproject.model.Module1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Module1Repository extends MongoRepository<Module1,String> {
   Module1 findByModulesn(String modulesn);
}
