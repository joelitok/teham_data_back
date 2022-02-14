package com.dataproject.dataproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Data {

    @Id
    private String id;

    private BatteryData batteryData;

    private Module1 module1;

    private Time time;

    public Data(String id, BatteryData batteryData,
            Module1 module1,

            Time time) {
        this.id = id;
        this.batteryData = batteryData;
        this.module1 = module1;
        this.time = time;
    }

    public Data() {

    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    public BatteryData getBatteryData() {
        return batteryData;
    }

    public void setBatteryData(BatteryData batteryData) {
        this.batteryData = batteryData;
    }

    public Module1 getModule_1() {
        return module1;
    }

    public void setModule_1(Module1 module1) {
        this.module1 = module1;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
