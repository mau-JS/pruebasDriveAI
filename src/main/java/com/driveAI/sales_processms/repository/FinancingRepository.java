package com.driveai.sales_processms.repository;

import com.driveai.sales_processms.model.Financing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface FinancingRepository  extends CrudRepository<Financing,Integer> {
    List<Financing> findAll();
}
