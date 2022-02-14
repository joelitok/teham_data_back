package com.dataproject.dataproject.dao;

import java.util.List;

import com.dataproject.dataproject.model.BatteryData;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatteryDataRepository extends MongoRepository<BatteryData, String> {
  List<BatteryData> findBatteryDataById(String batteryDataId);

}
