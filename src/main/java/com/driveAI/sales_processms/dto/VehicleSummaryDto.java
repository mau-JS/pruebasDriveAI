package com.driveAI.sales_processms.dto;
import com.driveAI.sales_processms.model.VehicleSummary;

public class VehicleSummaryDto {
    private int pk_num_id_vehicle_summary;
    private int num_year;
    private String str_brand;
    private String str_car_model;
    private float num_version;
    private String str_color;
    private int num_kilometers;
    private float num_price;
    private float num_offer;
    private String dat_date_offer;
    private String dat_date_offer_deadline;

    public int getPk_num_id_vehicle_summary() {
        return pk_num_id_vehicle_summary;
    }

    public void setPk_num_id_vehicle_summary(int pk_num_id_vehicle_summary) {
        this.pk_num_id_vehicle_summary = pk_num_id_vehicle_summary;
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

    public float getNum_version() {
        return num_version;
    }

    public void setNum_version(float num_version) {
        this.num_version = num_version;
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

    public float getNum_price() {
        return num_price;
    }

    public void setNum_price(float num_price) {
        this.num_price = num_price;
    }

    public float getNum_offer() {
        return num_offer;
    }

    public void setNum_offer(float num_offer) {
        this.num_offer = num_offer;
    }

    public String getDat_date_offer() {
        return dat_date_offer;
    }

    public void setDat_date_offer(String dat_date_offer) {
        this.dat_date_offer = dat_date_offer;
    }

    public String getDat_date_offer_deadline() {
        return dat_date_offer_deadline;
    }

    public void setDat_date_offer_deadline(String dat_date_offer_deadline) {
        this.dat_date_offer_deadline = dat_date_offer_deadline;
    }

    public VehicleSummaryDto(VehicleSummary vehicleSummary) {
        this.pk_num_id_vehicle_summary = vehicleSummary.getPk_num_id_vehicle_summary();
        this.num_year = vehicleSummary.getNum_year();
        this.str_brand = vehicleSummary.getStr_brand();
        this.str_car_model = vehicleSummary.getStr_car_model();
        this.num_version = vehicleSummary.getNum_version();
        this.str_color = vehicleSummary.getStr_color();
        this.num_kilometers = vehicleSummary.getNum_kilometers();
        this.num_price = vehicleSummary.getNum_price();
        this.num_offer = vehicleSummary.getNum_offer();
        this.dat_date_offer = vehicleSummary.getDat_date_offer();
        this.dat_date_offer_deadline = vehicleSummary.getDat_date_offer_deadline();
    }
}
