package com.driveai.sales_processms.service;

import com.driveai.sales_processms.dto.FinancingDto;
import com.driveai.sales_processms.dto.PaymentDto;
import com.driveai.sales_processms.model.Financing;
import com.driveai.sales_processms.model.Payment;
import com.driveai.sales_processms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public Payment savePayment(Payment payment) throws Exception{
        if(payment.getId()!=0){
            Optional<Payment> paymentInDb = paymentRepository.findById(payment.getId());
            if(!paymentInDb.isPresent()){
                throw new Exception("Financing " + payment.getId()+" does not exist");
            }
            payment=paymentRepository.save(payment);
        }else{
            payment=paymentRepository.save(payment);
        }
        return payment;
    }
    public void deletePayment(int id) throws Exception{
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if(paymentOptional.isPresent()){
            paymentRepository.delete(paymentOptional.get());
        }else{
            throw new Exception("Payment "+id+" does not exist");
        }
    }
    public List<PaymentDto> findAll(){
        List<Payment> paymentList = paymentRepository.findAll();
        List<PaymentDto> result = new ArrayList<>();
        for(Payment t:
                paymentList){
            PaymentDto dto = new PaymentDto(t);
            result.add(dto);
        }
        return  result;
    }
    public PaymentDto findByid(int id) throws Exception{
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if(paymentOptional.isPresent()){
            return new PaymentDto((paymentOptional.get()));
        }else{
            throw new Exception("Payment "+ id + " does not exist");
        }
    }

}
