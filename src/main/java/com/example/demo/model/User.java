package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;
    private long balance;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    private boolean isLoggedIn;



    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 100;
        this.isLoggedIn = false;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getBalance(){
        return balance;
    }
}
