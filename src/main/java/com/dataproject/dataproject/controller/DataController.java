package com.dataproject.dataproject.controller;
import java.util.List;

import com.dataproject.dataproject.dao.DataRepository;
import com.dataproject.dataproject.dao.Module1Repository;
import com.dataproject.dataproject.dao.MyDataRepository;
import com.dataproject.dataproject.model.Data;
import com.dataproject.dataproject.model.Module1;
import com.dataproject.dataproject.model.MyData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController 
public class DataController {
    private Logger logger =
LoggerFactory.getLogger(DataController.class);

@Autowired
private DataRepository dataRepository;

@Autowired
private Module1Repository module_1Repository;

@Autowired
private MyDataRepository myDataRepository;



//
@GetMapping(value = "/")
public List<MyData> getAlldatas(){
   logger.info("Getting all datas.");
   return myDataRepository.findAll();
}


//
@GetMapping(value = "/{myDataId}")
public MyData getDataById(@PathVariable String myDataId){
   logger.info("Getting data with ID: {}", myDataId);
   return  myDataRepository.findMyDataById(myDataId);
}

//find by module sn
/*@RequestMapping(value = "/vmod/{modulesn}", method = RequestMethod.POST)
public MyData getMyDataByModulesn(@RequestParam String modulesn){
String value ="102";

logger.info("Getting data with modulesn: ", value);
Module1 module;
Data data;
MyData myData;

module = module_1Repository.findByModulesn(value);
logger.info("Getting data with ID: {}", module);
data = dataRepository.findByModule1(module);
myData = myDataRepository.findByData(data);
logger.info("Getting data with ID: {}", myData);

    return  myData;
}

*/
//
@PostMapping(value = "/create")
public MyData addData(@RequestBody MyData data) {
   logger.info("Saving data.");
   return myDataRepository.save(data);
}

//
@PutMapping(value = "/update/{myDataId}")
public MyData updateData(@PathVariable String myDataId, @RequestBody MyData data) {
   logger.info("Updating data with ID: {}", myDataId);
   return  myDataRepository.save(data);
}

//
@DeleteMapping(value = "/delete/{myDataId}")
public void deleteData(@PathVariable String myDataId) {
   logger.info("Deleting data with ID: {}", myDataId);
   myDataRepository.deleteById(myDataId);
}



}
