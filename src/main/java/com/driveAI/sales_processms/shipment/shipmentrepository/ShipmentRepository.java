package com.driveAI.sales_processms.shipment.shipmentrepository;

import com.driveAI.sales_processms.shipment.shipmentmodel.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment,Integer> {
    List<Shipment> findAll();
}
