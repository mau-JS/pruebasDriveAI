package com.driveai.sales_processms.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class TradeInVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int num_year;
    private String str_brand;
    private String str_car_model;
    private BigDecimal dec_version;
    private String str_color;
    private int num_kilometers;
    private BigDecimal dec_price;
    private BigDecimal dec_offer;
    private BigDecimal dec_amount_offer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_year() {
        return num_year;
    }

    public void setNum_year(int num_year) {
        this.num_year = num_year;
    }

    public String getStr_brand() {
        return str_brand;
    }

    public void setStr_brand(String str_brand) {
        this.str_brand = str_brand;
    }

    public String getStr_car_model() {
        return str_car_model;
    }

    public void setStr_car_model(String str_car_model) {
        this.str_car_model = str_car_model;
    }

    public BigDecimal getDec_version() {
        return dec_version;
    }

    public void setDec_version(BigDecimal dec_version) {
        this.dec_version = dec_version;
    }

    public String getStr_color() {
        return str_color;
    }

    public void setStr_color(String str_color) {
        this.str_color = str_color;
    }

    public int getNum_kilometers() {
        return num_kilometers;
    }

    public void setNum_kilometers(int num_kilometers) {
        this.num_kilometers = num_kilometers;
    }

    public BigDecimal getDec_price() {
        return dec_price;
    }

    public void setDec_price(BigDecimal dec_price) {
        this.dec_price = dec_price;
    }

    public BigDecimal getDec_offer() {
        return dec_offer;
    }

    public void setDec_offer(BigDecimal dec_offer) {
        this.dec_offer = dec_offer;
    }

    public BigDecimal getDec_amount_offer() {
        return dec_amount_offer;
    }

    public void setDec_amount_offer(BigDecimal dec_amount_offer) {
        this.dec_amount_offer = dec_amount_offer;
    }
}
