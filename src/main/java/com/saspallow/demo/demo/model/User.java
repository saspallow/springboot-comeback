package com.saspallow.demo.demo.model;

/**
 * Created by dt213142 on 10/16/2017.
 */
public class User {

    public User() {
    }

    public User(String username, int age, String address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }

    private String username;
    private int age;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
