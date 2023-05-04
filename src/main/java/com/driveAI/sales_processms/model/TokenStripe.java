package com.driveai.sales_processms.model;

import jakarta.persistence.*;

@Entity
public class TokenStripe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int user_id;
    private String str_token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStr_token() {
        return str_token;
    }

    public void setStr_token(String str_token) {
        this.str_token = str_token;
    }
}
