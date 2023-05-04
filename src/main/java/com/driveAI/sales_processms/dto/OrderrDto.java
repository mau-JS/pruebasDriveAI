package com.driveai.sales_processms.dto;

import com.driveai.sales_processms.model.Orderr;

public class OrderrDto {
    private int id;
    private int user_id;
    private String order_status;

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

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public OrderrDto(Orderr orderr) {
        this.id = orderr.getId();
        this.user_id = orderr.getUser_id();
        this.order_status = orderr.getOrder_status();
    }
}
