package com.driveAI.sales_processms.service;

import com.driveAI.sales_processms.dto.InsurancesDto;
import com.driveAI.sales_processms.model.Insurances;
import com.driveAI.sales_processms.repository.InsurancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InsurancesService{
    @Autowired
    InsurancesRepository insurancesRepository;
    public Insurances saveInsurances(Insurances insurances) throws Exception{
        if(insurances.getPk_num_id_insurances()!=0){
            Optional<Insurances> insurancesInDb = insurancesRepository.findById(insurances.getPk_num_id_insurances());
            if(!insurancesInDb.isPresent()){
                throw new Exception("Insurances "+insurances.getPk_num_id_insurances()+" does not exist");
            }
            insurances=insurancesRepository.save(insurances);
        }else{
            insurances=insurancesRepository.save(insurances);
        }
        return insurances;
    }

    public void deleteInsurances(int pk_num_id_insurances)throws Exception{
        Optional<Insurances> insurancesOptional=insurancesRepository.findById(pk_num_id_insurances);
        if(insurancesOptional.isPresent()){
            insurancesRepository.delete(insurancesOptional.get());
        }else{
            throw new Exception("Insurances "+pk_num_id_insurances+" does not exist");
        }
    }

    public List<InsurancesDto> findAll(){
        List<Insurances> insurancesList = insurancesRepository.findAll();
        List<InsurancesDto> result = new ArrayList<>();
        for(Insurances t:
                insurancesList){
            InsurancesDto dto = new InsurancesDto(t);
            result.add(dto);
        }
        return result;
    }
    public InsurancesDto findById(int pk_num_id_insurances) throws Exception{
        Optional<Insurances> insurancesOptional=insurancesRepository.findById(pk_num_id_insurances);
        if(insurancesOptional.isPresent()){
            return new InsurancesDto((insurancesOptional.get()));
        }else{
            throw new Exception("Insurance " + pk_num_id_insurances + " does not exist");
        }
    }


}
