package com.dataproject.dataproject.controller;

import java.util.List;

import com.dataproject.dataproject.dao.BatteryDataRepository;
import com.dataproject.dataproject.dao.DataRepository;
import com.dataproject.dataproject.dao.Module1Repository;
import com.dataproject.dataproject.dao.MyDataRepository;
import com.dataproject.dataproject.dao.TimeRepository;
import com.dataproject.dataproject.model.MyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class DataController {
   private Logger logger = LoggerFactory.getLogger(DataController.class);

   // debut de l'injection des differente interface
   @Autowired
   private DataRepository dataRepository;

   @Autowired
   private Module1Repository module1Repository;

   @Autowired
   private MyDataRepository myDataRepository;

   @Autowired
   private BatteryDataRepository batteryDataRepository;

   @Autowired
   private TimeRepository timeRepository;

   @Autowired
   private MongoTemplate mongoTemplate;

   // rechercher tous les element de ma base de donnees
   @GetMapping(value = "/")
   public List<MyData> getAlldatas() {
      logger.info("Getting all datas.");
      return myDataRepository.findAll();
   }

   // rechercher un element dans la base de donnees suivant l'id
   @GetMapping(value = "/{myDataId}")
   public MyData getDataById(@PathVariable String myDataId) {
      logger.info("Getting data with ID: ", myDataId);
      return myDataRepository.findMyDataById(myDataId);
   }

   // rechercher un element suivant le module 1 entrer
   @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
   public List<MyData> getMyDataByModulesn(@PathVariable String name) {

      // rechercher la table data correspondante
      Query queryMyData = new Query();
      queryMyData.addCriteria(Criteria.where("bacteryDataIndex").is(name));
      List<MyData> myData = mongoTemplate.find(queryMyData, MyData.class);

      return myData;

   }

   // ajouter un element data dans la base de donnees
   @PostMapping(value = "/create")
   public MyData addData(@RequestBody MyData data) {

      // compter les element de la base de donnees
      String index = data.getData().getModule_1().getModulesn();

      // ici je counte le nombre d'element en sur je met l'option suivant
      data.setBacteryDataIndex(index);

      // enregistrer dans la table data
      dataRepository.save(data.getData());

      // enregistrer dans la table bactery data
      batteryDataRepository.save(data.getData().getBatteryData());

      // modifier le count option de module_1
      data.getData().getModule_1().setBacteryDataIndex(index);

      // enregistrer module_1
      module1Repository.save(data.getData().getModule_1());

      // enregistrer Time
      timeRepository.save(data.getData().getTime());

      logger.info("Saving data.");
      return myDataRepository.save(data);
   }

   // modifier un element de type data de ma base de donnees
   @PutMapping(value = "/update/{myDataId}")
   public MyData updateData(@PathVariable String myDataId, @RequestBody MyData data) {
      logger.info("Updating data with ID: {}", myDataId);
      return myDataRepository.save(data);
   }

   // supprimer un element de ma base de donnees
   @DeleteMapping(value = "/delete/{myDataId}")
   public void deleteData(@PathVariable String myDataId) {
      logger.info("Deleting data with ID: {}", myDataId);
      myDataRepository.deleteById(myDataId);
   }

}
