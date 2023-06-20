package com.example.summativeoop.controllers.Employee.models;

public class cdSearchModel {
    Integer cdid, quantity;
    String title, genre;


    public cdSearchModel(Integer cdid, String title, String genre, Integer quantity) {
        this.cdid = cdid;
        this.quantity = quantity;
        this.title = title;
        this.genre = genre;
    }

    public Integer getCdid() {
        return cdid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setCdid(Integer cdid) {
        this.cdid = cdid;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
