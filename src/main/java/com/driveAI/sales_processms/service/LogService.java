package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.LogDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Log;
import com.driveai.sales_processms.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    @Autowired
    LogRepository logRepository;
    public Log saveLog(Log log) throws Exception{
        if(log.getId()!=0){
            Optional<Log> logInDb = logRepository.findById(log.getId());
            if(!logInDb.isPresent()){
                throw new Exception("Log " + log.getId()+" does not exist");
            }
            log=logRepository.save(log);
        }else{
            log=logRepository.save(log);
        }
        return log;
    }
    public void deleteLog(int id) throws Exception{
        Optional<Log> logOptional = logRepository.findById(id);
        if(logOptional.isPresent()){
            logRepository.delete(logOptional.get());
        }else{
            throw new Exception("Log "+id+" does not exist");
        }
    }
    public List<LogDto> findAll(){
        List<Log> logList = logRepository.findAll();
        List<LogDto> result = new ArrayList<>();
        for(Log t:
                logList){
            LogDto dto = new LogDto(t);
            result.add(dto);
        }
        return  result;
    }
    public LogDto findByid(int id) throws Exception{
        Optional<Log> logOptional = logRepository.findById(id);
        if(logOptional.isPresent()){
            return new LogDto((logOptional.get()));
        }else{
            throw new Exception("Log "+ id + " does not exist");
        }
    }
}
