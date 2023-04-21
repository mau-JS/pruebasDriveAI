package com.driveAI.sales_processms.service;


import com.driveAI.sales_processms.dto.VehicleSummaryDto;

import com.driveAI.sales_processms.model.VehicleSummary;

import com.driveAI.sales_processms.repository.VehicleSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleSummaryService{
    @Autowired
    VehicleSummaryRepository vehicleSummaryRepository;
    public VehicleSummary saveVehicleSummary(VehicleSummary vehicleSummary) throws Exception{
        if(vehicleSummary.getPk_num_id_vehicle_summary()!=0){
            Optional<VehicleSummary> vehicleSummaryInDb = vehicleSummaryRepository.findById(vehicleSummary.getPk_num_id_vehicle_summary());
            if(!vehicleSummaryInDb.isPresent()){
                throw new Exception("Vehicle Summary "+vehicleSummary.getPk_num_id_vehicle_summary()+" does not exist");
            }
            vehicleSummary=vehicleSummaryRepository.save(vehicleSummary);
        }else {
            vehicleSummary=vehicleSummaryRepository.save(vehicleSummary);
        }
        return vehicleSummary;
    }

    public void deleteVehicleSummary(int pk_num_id_vehicle_summary)throws Exception{
        Optional<VehicleSummary> vehicleSummaryOptional=vehicleSummaryRepository.findById(pk_num_id_vehicle_summary);
        if(vehicleSummaryOptional.isPresent()){
            vehicleSummaryRepository.delete(vehicleSummaryOptional.get());
        }else{
            throw new Exception("Vehicle Summary "+pk_num_id_vehicle_summary+" does not exist");
        }
    }

    public List<VehicleSummaryDto> findAll(){
        List<VehicleSummary> vehicleSummaryList = vehicleSummaryRepository.findAll();
        List<VehicleSummaryDto> result = new ArrayList<>();
        for(VehicleSummary t:
                vehicleSummaryList){
            VehicleSummaryDto dto = new VehicleSummaryDto(t);
            result.add(dto);
        }
        return result;
    }
    public VehicleSummaryDto findById(int pk_num_id_vehicle_summary) throws Exception{
        Optional<VehicleSummary> vehicleSummaryOptional=vehicleSummaryRepository.findById(pk_num_id_vehicle_summary);
        if(vehicleSummaryOptional.isPresent()){
            return new VehicleSummaryDto((vehicleSummaryOptional.get()));
        }else{
            throw new Exception("Insurance " + pk_num_id_vehicle_summary + " does not exist");
        }
    }


}
