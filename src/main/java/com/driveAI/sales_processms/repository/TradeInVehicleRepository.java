package com.driveai.sales_processms.repository;

import com.driveai.sales_processms.model.TradeInVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TradeInVehicleRepository extends CrudRepository<TradeInVehicle, Integer> {
    List<TradeInVehicle> findAll();
}
