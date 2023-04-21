package com.driveAI.sales_processms.repository;


import com.driveAI.sales_processms.model.VehicleSummary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleSummaryRepository extends CrudRepository<VehicleSummary,Integer> {
    List<VehicleSummary> findAll();
}
