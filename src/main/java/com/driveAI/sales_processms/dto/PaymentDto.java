package com.driveai.sales_processms.dto;

import com.driveai.sales_processms.model.Payment;

import java.math.BigDecimal;

public class PaymentDto {
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

    public PaymentDto(Payment payment) {
        this.id = payment.getId();
        this.invoice_id = payment.getInvoice_id();
        this.dec_payment_amount = getDec_payment_amount();
        this.str_payment_method = payment.getStr_payment_method();
    }
}
