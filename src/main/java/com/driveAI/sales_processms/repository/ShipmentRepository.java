package com.driveai.sales_processms.repository;


import com.driveai.sales_processms.model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ShipmentRepository extends CrudRepository <Shipment, Integer>{
    List<Shipment>  findAll();
}
