package com.driveai.sales_processms.controllers;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.ShipmentDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Shipment;
import com.driveai.sales_processms.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/shipment")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;
    @PostMapping("/create")
    public ResponseEntity<?> createShipment(@RequestBody Shipment shipment){
        try{
            shipment = shipmentService.saveShipment(shipment);
        }catch (Exception e){

        }
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteShipment(@RequestParam("id")int id){
        try{
            shipmentService.deleteShipment(id);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Shipment with id"+id+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateShipment(@RequestBody Shipment shipment){
        try{
            shipment = shipmentService.saveShipment(shipment);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(shipment,HttpStatus.OK);
        }
        return  new ResponseEntity<>(shipment,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllShipment(){
        return new ResponseEntity<>(shipmentService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            ShipmentDto shipment = shipmentService.findByid((id));
            return new ResponseEntity<>(shipment,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
