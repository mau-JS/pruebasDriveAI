package com.driveai.sales_processms.controllers;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.LogDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Log;
import com.driveai.sales_processms.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/log")
public class LogController {
    @Autowired
    LogService logService;
    @PostMapping("/create")
    public ResponseEntity<?> createLog(@RequestBody Log log){
        try{
            log = logService.saveLog(log);
        }catch (Exception e){

        }
        return new ResponseEntity<>(log, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLog(@RequestParam("id")int id){
        try{
            logService.deleteLog(id);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Log with id"+id+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateLog(@RequestBody Log log){
        try{
            log = logService.saveLog(log);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(log,HttpStatus.OK);
        }
        return  new ResponseEntity<>(log,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllFinancing(){
        return new ResponseEntity<>(logService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            LogDto log = logService.findByid((id));
            return new ResponseEntity<>(log,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
