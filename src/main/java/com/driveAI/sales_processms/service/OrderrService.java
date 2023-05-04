package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.OrderrDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Orderr;
import com.driveai.sales_processms.repository.OrderrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderrService {
    @Autowired
    OrderrRepository orderrRepository;
    public Orderr saveOrderr(Orderr orderr) throws Exception{
        if(orderr.getId()!=0){
            Optional<Orderr> orderInDb = orderrRepository.findById(orderr.getId());
            if(!orderInDb.isPresent()){
                throw new Exception("Order " + orderr.getId()+" does not exist");
            }
            orderr=orderrRepository.save(orderr);
        }else{
            orderr=orderrRepository.save(orderr);
        }
        return orderr;
    }
    public void deleteOrderr(int id) throws Exception{
        Optional<Orderr> orderrOptional = orderrRepository.findById(id);
        if(orderrOptional.isPresent()){
            orderrRepository.delete(orderrOptional.get());
        }else{
            throw new Exception("Address "+id+" does not exist");
        }
    }
    public List<OrderrDto> findAll(){
        List<Orderr> orderrList = orderrRepository.findAll();
        List<OrderrDto> result = new ArrayList<>();
        for(Orderr t:
                orderrList){
            OrderrDto dto = new OrderrDto(t);
            result.add(dto);
        }
        return  result;
    }
    public OrderrDto findByid(int id) throws Exception{
        Optional<Orderr> orderrOptional = orderrRepository.findById(id);
        if(orderrOptional.isPresent()){
            return new OrderrDto((orderrOptional.get()));
        }else{
            throw new Exception("Order "+ id + " does not exist");
        }
    }
}
