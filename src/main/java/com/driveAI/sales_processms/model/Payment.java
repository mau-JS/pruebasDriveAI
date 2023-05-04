package com.driveai.sales_processms.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int invoice_id;
    private BigDecimal dec_payment_amount;
    private String str_payment_method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public BigDecimal getDec_payment_amount() {
        return dec_payment_amount;
    }

    public void setDec_payment_amount(BigDecimal dec_payment_amount) {
        this.dec_payment_amount = dec_payment_amount;
    }

    public String getStr_payment_method() {
        return str_payment_method;
    }

    public void setStr_payment_method(String str_payment_method) {
        this.str_payment_method = str_payment_method;
    }
}
