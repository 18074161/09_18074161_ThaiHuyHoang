package com.example.a09_18074161_thaihuyhoang;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int anh;
    private int price;

    public User(String name, int anh, int price) {
        this.name = name;
        this.anh = anh;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
