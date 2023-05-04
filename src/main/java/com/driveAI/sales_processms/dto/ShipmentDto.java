package com.driveai.sales_processms.dto;

import com.driveai.sales_processms.model.Shipment;

public class ShipmentDto {
    private int id;
    private int orderr_id;
    private int invoice_id;
    private String shipping_address;
    private String shipment_status;

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

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getShipment_status() {
        return shipment_status;
    }

    public void setShipment_status(String shipment_status) {
        this.shipment_status = shipment_status;
    }

    public ShipmentDto(Shipment shipment) {
        this.id = shipment.getId();
        this.orderr_id = shipment.getOrderr_id();
        this.invoice_id = shipment.getInvoice_id();
        this.shipping_address = shipment.getShipping_address();
        this.shipment_status = shipment.getShipment_status();
    }
}
