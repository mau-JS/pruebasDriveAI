package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.ShipmentDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Shipment;
import com.driveai.sales_processms.repository.FinancingRepository;
import com.driveai.sales_processms.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    ShipmentRepository shipmentRepository;
    public Shipment saveShipment(Shipment shipment) throws Exception{
        if(shipment.getId()!=0){
            Optional<Shipment> shipmentInDb = shipmentRepository.findById(shipment.getId());
            if(!shipmentInDb.isPresent()){
                throw new Exception("Shipment " + shipment.getId()+" does not exist");
            }
            shipment=shipmentRepository.save(shipment);
        }else{
            shipment=shipmentRepository.save(shipment);
        }
        return shipment;
    }
    public void deleteShipment(int id) throws Exception{
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);
        if(shipmentOptional.isPresent()){
            shipmentRepository.delete(shipmentOptional.get());
        }else{
            throw new Exception("Shipment "+id+" does not exist");
        }
    }
    public List<ShipmentDto> findAll(){
        List<Shipment> shipmentList = shipmentRepository.findAll();
        List<ShipmentDto> result = new ArrayList<>();
        for(Shipment t:
                shipmentList){
            ShipmentDto dto = new ShipmentDto(t);
            result.add(dto);
        }
        return  result;
    }
    public ShipmentDto findByid(int id) throws Exception{
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);
        if(shipmentOptional.isPresent()){
            return new ShipmentDto((shipmentOptional.get()));
        }else{
            throw new Exception("Shipment "+ id + " does not exist");
        }
    }
}
