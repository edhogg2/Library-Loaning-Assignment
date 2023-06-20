package com.example.summativeoop.controllers.Employee.models;

public class allSearchModel {
    Integer booksid, dvdid, cdid, instrumentsid;
    String title, name;

    public allSearchModel(Integer booksid, Integer dvdid, Integer cdid, Integer instrumentsid, String title, String name) {
        this.booksid = booksid;
        this.dvdid = dvdid;
        this.cdid = cdid;
        this.instrumentsid = instrumentsid;
        this.title = title;
        this.name = name;
    }

    public Integer getBooksid() {
        return booksid;
    }

    public Integer getDvdid() {
        return dvdid;
    }

    public Integer getCdid() {
        return cdid;
    }

    public Integer getInstrumentsid() {
        return instrumentsid;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public void setBooksid(Integer booksid) {
        this.booksid = booksid;
    }

    public void setDvdid(Integer dvdid) {
        this.dvdid = dvdid;
    }

    public void setCdid(Integer cdid) {
        this.cdid = cdid;
    }

    public void setInstrumentsid(Integer instrumentsid) {
        this.instrumentsid = instrumentsid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }
}
