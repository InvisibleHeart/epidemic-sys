package com.myq.epidemic_sys.setting.mapper;

import com.myq.epidemic_sys.setting.entity.Reporting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingMapper extends MongoRepository<Reporting, Long> {
}
