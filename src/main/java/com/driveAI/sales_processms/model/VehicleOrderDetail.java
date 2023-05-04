package com.driveai.sales_processms.model;

import jakarta.persistence.*;

@Entity
public class VehicleOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    private int orderr_id;
    private String str_automotive_group;
    private int vehicle_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderr_id() {
        return orderr_id;
    }

    public void setOrderr_id(int orderr_id) {
        this.orderr_id = orderr_id;
    }

    public String getStr_automotive_group() {
        return str_automotive_group;
    }

    public void setStr_automotive_group(String str_automotive_group) {
        this.str_automotive_group = str_automotive_group;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
