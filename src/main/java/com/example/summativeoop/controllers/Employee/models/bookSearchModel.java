package com.example.summativeoop.controllers.Employee.models;

public class bookSearchModel {
    Integer booksid, quantity;
    String title, type, genre, description;


    public bookSearchModel(Integer booksid, String title, String type, String genre, String description, Integer quantity) {
        this.booksid = booksid;
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getBooksID() {
        return booksid;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
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

    public void setBooksID(Integer booksid) {
        this.booksid = booksid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
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
