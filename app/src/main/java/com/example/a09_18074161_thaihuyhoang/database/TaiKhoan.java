package com.example.a09_18074161_thaihuyhoang.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaiKhoan {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String email;
    private String time;

    public TaiKhoan(String email, String time) {
        this.email = email;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
