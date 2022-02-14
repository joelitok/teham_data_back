package com.dataproject.dataproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyData {

    @Id
    private String id;

    private String bacteryDataIndex;

    private Data data;

    public MyData(String id, Data data) {
        this.id = id;
        this.data = data;
    }

    public MyData() {

    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonIgnore
    public String getBacteryDataIndex() {
        return bacteryDataIndex;
    }

    @JsonSetter
    public void setBacteryDataIndex(String bacteryDataIndex) {
        this.bacteryDataIndex = bacteryDataIndex;
    }

}
