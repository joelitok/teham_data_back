package com.dataproject.dataproject.dao;

import com.dataproject.dataproject.model.*;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyDataRepository extends MongoRepository<MyData,String>{

    MyData findByData(Data data);

    MyData findMyDataById(String dataid);
}
