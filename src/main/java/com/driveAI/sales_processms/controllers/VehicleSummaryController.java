package com.driveAI.sales_processms.controllers;

import com.driveAI.sales_processms.dto.VehicleSummaryDto;
import com.driveAI.sales_processms.model.VehicleSummary;
import com.driveAI.sales_processms.service.VehicleSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/v1/sales-process/vehicle-summary")
public class VehicleSummaryController {
    @Autowired
    VehicleSummaryService vehicleSummaryService;
    @PostMapping("/create")
    public ResponseEntity<?> createVehicleSummary(@RequestBody VehicleSummary vehicleSummary){
        try{
            vehicleSummary = vehicleSummaryService.saveVehicleSummary(vehicleSummary);

        }catch (Exception e){

        }
        return new ResponseEntity<>(vehicleSummary, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteVehicleSummary(@RequestParam("pk_num_id_vehicle_summary") int pk_num_id_vehicle_summary){
        try {
            vehicleSummaryService.deleteVehicleSummary(pk_num_id_vehicle_summary);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Vehicle Summary with id"+pk_num_id_vehicle_summary+" deleted");
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateVehicleSummary(@RequestBody VehicleSummary vehicleSummary){
        try{
            vehicleSummary = vehicleSummaryService.saveVehicleSummary(vehicleSummary);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(vehicleSummary,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllVehicleSummary(){return new ResponseEntity<>(vehicleSummaryService.findAll(),HttpStatus.OK);}
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("pk_num_id_vehicle_summary") int ppk_num_id_vehicle_summary){
        try{
            VehicleSummaryDto vehicleSummary = vehicleSummaryService.findById((ppk_num_id_vehicle_summary));
            return new ResponseEntity<>(vehicleSummary,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
