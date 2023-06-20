package com.example.summativeoop.controllers.Employee.models;

public class instrumentSearchModel {
    Integer instrumentsid, quantity;
    String name, type;

    public instrumentSearchModel(Integer instrumentsid, String type, String name, Integer quantity) {
        this.instrumentsid = instrumentsid;
        this.quantity = quantity;
        this.name = name;
        this.type = type;
    }

    public Integer getInstrumentsid() {
        return instrumentsid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setInstrumentsid(Integer instrumentsid) {
        this.instrumentsid = instrumentsid;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
