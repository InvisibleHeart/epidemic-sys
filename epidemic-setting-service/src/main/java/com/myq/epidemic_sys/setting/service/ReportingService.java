package com.myq.epidemic_sys.setting.service;

import com.myq.epidemic_sys.setting.entity.Reporting;
import com.myq.epidemic_sys.setting.model.dto.ReportingDTO;

import java.util.List;

public interface ReportingService {

    List<Reporting> findByCondition(ReportingDTO dto);

    void insert(ReportingDTO dto);

}
