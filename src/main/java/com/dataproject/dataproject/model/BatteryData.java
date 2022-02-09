package com.dataproject.dataproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class BatteryData {
    
    @Id
    private String id;

    private int voltage;
    private int outputVoltage;
    
    public BatteryData(String id, int voltage, int outputVoltage) {
        this.id = id;
        this.voltage = voltage;
        this.outputVoltage = outputVoltage;
    }

    public BatteryData(){

    }


    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(int outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

}
