package com.dataproject.dataproject.dao;
import com.dataproject.dataproject.model.BatteryData;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BatteryDataRepository extends MongoRepository<BatteryData, String>{
    
BatteryData findBatteryDataById(String batteryDataId);

}
