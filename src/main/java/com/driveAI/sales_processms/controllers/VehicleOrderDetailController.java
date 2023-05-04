package com.driveai.sales_processms.controllers;
import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.VehicleOrderDetailDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.service.VehicleOrderDetailService;
import com.driveai.sales_processms.model.VehicleOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/sales-process/vehicle-order-detail")
public class VehicleOrderDetailController {
    @Autowired
    VehicleOrderDetailService vehicleOrderDetailService;
    @PostMapping("/create")
    public ResponseEntity<?> createVehicleOrderDetail(@RequestBody VehicleOrderDetail vehicleOrderDetail){
        try{
            vehicleOrderDetail = vehicleOrderDetailService.saveVehicleOrderDetail(vehicleOrderDetail);
        }catch (Exception e){

        }
        return new ResponseEntity<>(vehicleOrderDetail, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteVehicleOrderDetail(@RequestParam("id")int id){
        try{
            vehicleOrderDetailService.deleteVehicleOrderDetail(id);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String,String> response = new HashMap<>();
        response.put("message","VehicleOrderDetail with id"+id+" deleted");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateVehicleOrderDetail(@RequestBody VehicleOrderDetail vehicleOrderDetail){
        try{
            vehicleOrderDetail = vehicleOrderDetailService.saveVehicleOrderDetail(vehicleOrderDetail);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(vehicleOrderDetail,HttpStatus.OK);
        }
        return  new ResponseEntity<>(vehicleOrderDetail,HttpStatus.OK);
    }
    @GetMapping("/get")
    public  ResponseEntity<?> getAllVehicleOrderDetail(){
        return new ResponseEntity<>(vehicleOrderDetailService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestParam("id")int id){
        try{
            VehicleOrderDetailDto vehicleOrderDetail = vehicleOrderDetailService.findByid((id));
            return new ResponseEntity<>(vehicleOrderDetail,HttpStatus.OK);
        }catch (Exception e){
            Map<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
