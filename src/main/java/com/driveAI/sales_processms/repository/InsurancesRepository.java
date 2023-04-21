package com.driveAI.sales_processms.repository;

import com.driveAI.sales_processms.model.Insurances;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsurancesRepository extends CrudRepository<Insurances,Integer> {
    List<Insurances> findAll();
}
