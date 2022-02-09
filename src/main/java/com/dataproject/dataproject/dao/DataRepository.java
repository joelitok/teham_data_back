package com.dataproject.dataproject.dao;



import com.dataproject.dataproject.model.Data;
import com.dataproject.dataproject.model.Module1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Data,String>{
             
            Data findDataById(String dataid);
            Data findByModule1(Module1 module_1);

}
