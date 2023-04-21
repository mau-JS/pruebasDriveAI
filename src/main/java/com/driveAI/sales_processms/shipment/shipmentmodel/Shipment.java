package com.driveAI.sales_processms.shipment.shipmentmodel;

import jakarta.persistence.*;

@Entity
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String saved_address;
    private String agency;
    private String new_address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaved_address() {
        return saved_address;
    }

    public void setSaved_address(String saved_address) {
        this.saved_address = saved_address;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNew_address() {
        return new_address;
    }

    public void setNew_address(String new_address) {
        this.new_address = new_address;
    }
}
