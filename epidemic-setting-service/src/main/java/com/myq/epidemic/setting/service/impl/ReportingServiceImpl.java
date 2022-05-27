package com.myq.epidemic.setting.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myq.epidemic.setting.service.ReportingService;
import com.myq.epidemic.setting.entity.Morbidity;
import com.myq.epidemic.setting.entity.Patient;
import com.myq.epidemic.setting.entity.Reporting;
import com.myq.epidemic.setting.mapper.ReportingMapper;
import com.myq.epidemic.setting.model.dto.ReportingDTO;
import com.myq.epidemic.setting.service.MorbidityService;
import com.myq.epidemic.setting.service.PatientService;
import com.myq.epidemic.setting.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private ReportingMapper reportingMapper;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MorbidityService morbidityService;

    @Autowired
    private RegionService regionService;


    @Override
    public List<Reporting> findByCondition(ReportingDTO dto) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ReportingDTO dto) {
        QueryWrapper<Patient> patientQueryWrapper = new QueryWrapper();
        patientQueryWrapper.eq("name", dto.getUserName())
                .eq("identity_card", dto.getIdentityCard());
        Patient patient = this.patientService.getBaseMapper().selectOne(patientQueryWrapper);
        //  更新病发记录
        if (patient != null) {
            Morbidity morbidity = new Morbidity();
            morbidity.setPatientId(patient.getId());
            morbidity.setCreatDate(Date.from(Instant.now().atZone(ZoneId.systemDefault()).toInstant()));
            morbidity.setSituationCon(dto.getPhysicalCondition());
            morbidity.setRemarks("暂无");
            this.morbidityService.getBaseMapper().insert(morbidity);
        } else {

        }
        //  更新地区记录
        if ("1".equals(dto.getNucleicResults())) {
            this.regionService.increase(dto.getCity());
        }
        //  数据归档
        Reporting reporting = JSONObject.parseObject(JSONObject.toJSONString(dto), Reporting.class);
        Reporting insert = this.reportingMapper.insert(reporting);
    }
}
