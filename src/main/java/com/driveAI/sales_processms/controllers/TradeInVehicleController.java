package com.driveai.sales_processms.controllers;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.TradeInVehicleDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.TradeInVehicle;
import com.driveai.sales_processms.service.TradeInVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/trade-in-vehicle")
public class TradeInVehicleController {
    @Autowired
    TradeInVehicleService tradeInVehicleService;
    @PostMapping("/create")
    public ResponseEntity<?> createTradeInVehicle(@RequestBody TradeInVehicle tradeInVehicle){
        try{
            tradeInVehicle = tradeInVehicleService.saveTradeInVehicle(tradeInVehicle);
        }catch (Exception e){

        }
        return new ResponseEntity<>(tradeInVehicle, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTradeInVehicle(@RequestParam("id")int id){
        try{
            tradeInVehicleService.deleteTradeInVehicle(id);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Trade in with id"+id+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateTradeInVehicle(@RequestBody TradeInVehicle tradeInVehicle){
        try{
            tradeInVehicle = tradeInVehicleService.saveTradeInVehicle(tradeInVehicle);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(tradeInVehicle,HttpStatus.OK);
        }
        return  new ResponseEntity<>(tradeInVehicle,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllTradeInVehicle(){
        return new ResponseEntity<>(tradeInVehicleService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            TradeInVehicleDto tradeInVehicle = tradeInVehicleService.findByid((id));
            return new ResponseEntity<>(tradeInVehicle,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
