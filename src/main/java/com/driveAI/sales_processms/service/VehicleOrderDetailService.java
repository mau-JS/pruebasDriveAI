package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.VehicleOrderDetailDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.VehicleOrderDetail;
import com.driveai.sales_processms.repository.VehicleOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleOrderDetailService {
    @Autowired
    VehicleOrderDetailRepository vehicleOrderDetailRepository;
    public VehicleOrderDetail saveVehicleOrderDetail(VehicleOrderDetail vehicleOrderDetail) throws Exception{
        if(vehicleOrderDetail.getId()!=0){
            Optional<VehicleOrderDetail> vehicleOrderDetailInDb = vehicleOrderDetailRepository.findById(vehicleOrderDetail.getId());
            if(!vehicleOrderDetailInDb.isPresent()){
                throw new Exception("Vehicle Order " + vehicleOrderDetail.getId()+" does not exist");
            }
            vehicleOrderDetail=vehicleOrderDetailRepository.save(vehicleOrderDetail);
        }else{
            vehicleOrderDetail=vehicleOrderDetailRepository.save(vehicleOrderDetail);
        }
        return vehicleOrderDetail;
    }
    public void deleteVehicleOrderDetail(int id) throws Exception{
        Optional<VehicleOrderDetail> vehicleOrderDetailOptional = vehicleOrderDetailRepository.findById(id);
        if(vehicleOrderDetailOptional.isPresent()){
            vehicleOrderDetailRepository.delete(vehicleOrderDetailOptional.get());
        }else{
            throw new Exception("Vehicle Order "+id+" does not exist");
        }
    }
    public List<VehicleOrderDetailDto> findAll(){
        List<VehicleOrderDetail> vehicleOrderDetailList = vehicleOrderDetailRepository.findAll();
        List<VehicleOrderDetailDto> result = new ArrayList<>();
        for(VehicleOrderDetail t:
                vehicleOrderDetailList){
            VehicleOrderDetailDto dto = new VehicleOrderDetailDto(t);
            result.add(dto);
        }
        return  result;
    }
    public VehicleOrderDetailDto findByid(int id) throws Exception{
        Optional<VehicleOrderDetail> vehicleOrderDetailOptional = vehicleOrderDetailRepository.findById(id);
        if(vehicleOrderDetailOptional.isPresent()){
            return new VehicleOrderDetailDto((vehicleOrderDetailOptional.get()));
        }else{
            throw new Exception("Vehicle Order "+ id + " does not exist");
        }
    }
}
