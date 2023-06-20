package com.example.summativeoop.controllers.Employee.models;

public class dvdSearchModel {
    Integer dvdid;
    Integer quantity;
    String title;
    String genre;
    String description;

    public dvdSearchModel(Integer dvdid,  String title, String genre, String description ,Integer quantity) {
        this.dvdid = dvdid;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getDvdID() {
        return dvdid ;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setDvdID(Integer dvdid) {
        this.dvdid = dvdid;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
