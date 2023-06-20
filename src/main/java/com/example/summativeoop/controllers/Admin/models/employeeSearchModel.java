package com.example.summativeoop.controllers.Admin.models;

public class employeeSearchModel {
    Integer userid;
    String name, username, password, email_address;
    Boolean admin;

    public employeeSearchModel(Integer userid, String name, String username, String password, String email_address,
                               Boolean admin) {
        this.userid = userid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email_address = email_address;
        this.admin = admin;
    }

    public Integer getUserID() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
