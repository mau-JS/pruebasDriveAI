package com.driveai.sales_processms.repository;

import com.driveai.sales_processms.model.Payment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PaymentRepository extends CrudRepository<Payment,Integer> {
    List<Payment> findAll();
}
