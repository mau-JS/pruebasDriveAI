package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.TradeInVehicleDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.TradeInVehicle;
import com.driveai.sales_processms.repository.TradeInVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeInVehicleService {
    @Autowired
    TradeInVehicleRepository tradeInVehicleRepository;
    public TradeInVehicle saveTradeInVehicle(TradeInVehicle tradeInVehicle) throws Exception{
        if(tradeInVehicle.getId()!=0){
            Optional<TradeInVehicle> tradeInVehicleInDb = tradeInVehicleRepository.findById(tradeInVehicle.getId());
            if(!tradeInVehicleInDb.isPresent()){
                throw new Exception("Trade in " + tradeInVehicle.getId()+" does not exist");
            }
            tradeInVehicle=tradeInVehicleRepository.save(tradeInVehicle);
        }else{
            tradeInVehicle=tradeInVehicleRepository.save(tradeInVehicle);
        }
        return tradeInVehicle;
    }
    public void deleteTradeInVehicle(int id) throws Exception{
        Optional<TradeInVehicle> tradeInVehicleOptional = tradeInVehicleRepository.findById(id);
        if(tradeInVehicleOptional.isPresent()){
            tradeInVehicleRepository.delete(tradeInVehicleOptional.get());
        }else{
            throw new Exception("Trade in "+id+" does not exist");
        }
    }
    public List<TradeInVehicleDto> findAll(){
        List<TradeInVehicle> tradeInVehicleList = tradeInVehicleRepository.findAll();
        List<TradeInVehicleDto> result = new ArrayList<>();
        for(TradeInVehicle t:
                tradeInVehicleList){
            TradeInVehicleDto dto = new TradeInVehicleDto(t);
            result.add(dto);
        }
        return  result;
    }
    public TradeInVehicleDto findByid(int id) throws Exception{
        Optional<TradeInVehicle> tradeInVehicleOptional = tradeInVehicleRepository.findById(id);
        if(tradeInVehicleOptional.isPresent()){
            return new TradeInVehicleDto((tradeInVehicleOptional.get()));
        }else{
            throw new Exception("Trade in "+ id + " does not exist");
        }
    }
}
