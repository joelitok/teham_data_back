package com.dataproject.dataproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Module1{
    @Id
    private String id;

    private String modulesn;
    private int current;
    private double soh;
    private double soc;
    private int temperature_senior;
    private int temperature_uc;

    public Module1(String id, String modulesn, int current, double soh, 
                    double soc, int temperature_senior, int temperature_uc) {
        this.id = id;
        this.modulesn = modulesn;
        this.current = current;
        this.soh = soh;
        this.soc = soc;
        this.temperature_senior = temperature_senior;
        this.temperature_uc = temperature_uc;
    }
    public  Module1(){

    }
    
    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    public String getModulesn() {
        return modulesn;
    }
    public void setModulesn(String modulesn) {
        this.modulesn = modulesn;
    }
    public int getCurrent() {
        return current;
    }
    public void setCurrent(int current) {
        this.current = current;
    }
    public double getSoh() {
        return soh;
    }
    public void setSoh(double soh) {
        this.soh = soh;
    }
    public double getSoc() {
        return soc;
    }
    public void setSoc(double soc) {
        this.soc = soc;
    }
    public int getTemperature_senior() {
        return temperature_senior;
    }
    public void setTemperature_senior(int temperature_senior) {
        this.temperature_senior = temperature_senior;
    }
    public int getTemperature_uc() {
        return temperature_uc;
    }
    public void setTemperature_uc(int temperature_uc) {
        this.temperature_uc = temperature_uc;
    }

}
