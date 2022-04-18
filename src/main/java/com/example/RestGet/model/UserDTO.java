package com.example.RestGet.model;

public class UserDTO {
    private String email;

    private String pass;

    public UserDTO() {

        this.email = email;
        this.pass=pass;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public String findByEmail(String email) {
        return email;
    }
}