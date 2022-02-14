package com.dataproject.dataproject.dao;

import java.util.List;

import com.dataproject.dataproject.model.Data;
import com.dataproject.dataproject.model.Module1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Data, String> {

    Data findDataById(String dataid);

    List<Data> findDataByModule1(Module1 module1);

}
