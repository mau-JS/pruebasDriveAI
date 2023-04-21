package com.driveAI.sales_processms.controllers;

import com.driveAI.sales_processms.dto.InsurancesDto;
import com.driveAI.sales_processms.model.Insurances;
import com.driveAI.sales_processms.service.InsurancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/insurances")
public class InsurancesController {
    @Autowired
    InsurancesService insurancesService;
    @PostMapping("/create")
    public ResponseEntity<?> createInsurances(@RequestBody Insurances insurances){
        try{
            insurances = insurancesService.saveInsurances(insurances);
        }catch (Exception e){

        }
        return new ResponseEntity<>(insurances, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteInsurances(@RequestParam("pk_num_id_insurances")int pk_num_id_insurances){
        try{
            insurancesService.deleteInsurances(pk_num_id_insurances);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Insurances with id" + pk_num_id_insurances+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateInsurances(@RequestBody Insurances insurances){
        try{
           insurances = insurancesService.saveInsurances(insurances);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(insurances,HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllInsurances(){return new ResponseEntity<>(insurancesService.findAll(),HttpStatus.OK);}
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("pk_num_id_insurances") int pk_num_id_insurances){
        try{
            InsurancesDto insurances = insurancesService.findById((pk_num_id_insurances));
            return new ResponseEntity<>(insurances,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
