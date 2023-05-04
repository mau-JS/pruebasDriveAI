package com.driveai.sales_processms.repository;
import com.driveai.sales_processms.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {
    List<Log> findAll();
}
