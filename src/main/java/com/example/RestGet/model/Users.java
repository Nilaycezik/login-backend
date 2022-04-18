package com.example.RestGet.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private long pass;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public void setEmail(String  email) {
        this.email = email;
    }


    public  String  getEmail() {
        return email;
    }
    public void setPass(long pass) {
        this.pass = pass;
    }

    public long getPass() {
        return pass;
    }
}