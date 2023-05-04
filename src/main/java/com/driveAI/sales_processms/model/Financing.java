package com.driveai.sales_processms.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Financing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    private BigDecimal dec_amount_opening;
    private BigDecimal dec_monthly_payment;
    private BigDecimal dec_interest_rate;
    private BigDecimal dec_down_payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getDec_amount_opening() {
        return dec_amount_opening;
    }

    public void setDec_amount_opening(BigDecimal dec_amount_opening) {
        this.dec_amount_opening = dec_amount_opening;
    }

    public BigDecimal getDec_monthly_payment() {
        return dec_monthly_payment;
    }

    public void setDec_monthly_payment(BigDecimal dec_monthly_payment) {
        this.dec_monthly_payment = dec_monthly_payment;
    }

    public BigDecimal getDec_interest_rate() {
        return dec_interest_rate;
    }

    public void setDec_interest_rate(BigDecimal dec_interest_rate) {
        this.dec_interest_rate = dec_interest_rate;
    }

    public BigDecimal getDec_down_payment() {
        return dec_down_payment;
    }

    public void setDec_down_payment(BigDecimal dec_down_payment) {
        this.dec_down_payment = dec_down_payment;
    }
}
