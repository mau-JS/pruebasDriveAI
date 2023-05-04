package com.driveai.sales_processms.repository;

import com.driveai.sales_processms.model.Orderr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrderrRepository extends CrudRepository<Orderr,Integer> {
    List<Orderr> findAll();
}
