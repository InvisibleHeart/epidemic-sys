package com.myq.epidemic.setting.service;

import com.myq.epidemic.setting.entity.Reporting;
import com.myq.epidemic.setting.model.dto.ReportingDTO;

import java.util.List;

public interface ReportingService {

    List<Reporting> findByCondition(ReportingDTO dto);

    void insert(ReportingDTO dto);

}
