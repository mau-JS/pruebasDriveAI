package com.driveai.sales_processms.controllers;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.OrderrDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Orderr;
import com.driveai.sales_processms.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/order")
public class OrderrController {
    @Autowired
    OrderrService orderrService;
    @PostMapping("/create")
    public ResponseEntity<?> createOrderr(@RequestBody Orderr orderr){
        try{
            orderr = orderrService.saveOrderr(orderr);
        }catch (Exception e){

        }
        return new ResponseEntity<>(orderr, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrderr(@RequestParam("id")int id){
        try{
            orderrService.deleteOrderr(id);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","Financing with id"+id+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody Orderr orderr){
        try{
            orderr = orderrService.saveOrderr(orderr);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(orderr,HttpStatus.OK);
        }
        return  new ResponseEntity<>(orderr,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllOrderr(){
        return new ResponseEntity<>(orderrService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            OrderrDto orderr = orderrService.findByid((id));
            return new ResponseEntity<>(orderr,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
