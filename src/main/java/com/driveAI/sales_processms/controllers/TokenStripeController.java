package com.driveai.sales_processms.controllers;
import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.TokenStripeDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.TokenStripe;
import com.driveai.sales_processms.service.TokenStripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/token-stripe")
public class TokenStripeController {
    @Autowired
    TokenStripeService tokenStripeService;
    @PostMapping("/create")
    public ResponseEntity<?> createTokenStripe(@RequestBody TokenStripe tokenStripe){
        try{
            tokenStripe = tokenStripeService.saveTokenStripe(tokenStripe);
        }catch (Exception e){

        }
        return new ResponseEntity<>(tokenStripe, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTokenStripe(@RequestParam("id")int id){
        try{
            tokenStripeService.deleteTokenStripe(id);
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
    public ResponseEntity<?> updateTokenStripe(@RequestBody TokenStripe tokenStripe){
        try{
            tokenStripe = tokenStripeService.saveTokenStripe(tokenStripe);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(tokenStripe,HttpStatus.OK);
        }
        return  new ResponseEntity<>(tokenStripe,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllTokenStripe(){
        return new ResponseEntity<>(tokenStripeService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            TokenStripeDto tokenStripe = tokenStripeService.findByid((id));
            return new ResponseEntity<>(tokenStripe,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
