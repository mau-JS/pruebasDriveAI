package com.driveai.sales_processms.repository;

import com.driveai.sales_processms.model.VehicleOrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface VehicleOrderDetailRepository extends CrudRepository<VehicleOrderDetail, Integer> {
    List<VehicleOrderDetail> findAll();
}
