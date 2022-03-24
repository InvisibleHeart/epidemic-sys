package com.myq.epidemic_sys.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic_sys.common.enums.PageResponseEnum;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.common.utils.StringUtil;
import com.myq.epidemic_sys.setting.entity.Patient;
import com.myq.epidemic_sys.setting.entity.Region;
import com.myq.epidemic_sys.setting.mapper.PatientMapper;
import com.myq.epidemic_sys.setting.model.dto.PatientDTO;
import com.myq.epidemic_sys.setting.model.dto.PatientPageDTO;
import com.myq.epidemic_sys.setting.model.vo.PatientPageVO;
import com.myq.epidemic_sys.setting.model.vo.StatisticsInfectionDegreeVO;
import com.myq.epidemic_sys.setting.model.vo.StatisticsVO;
import com.myq.epidemic_sys.setting.service.PatientService;
import com.myq.epidemic_sys.setting.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 16:13:13
 */
@Slf4j
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Autowired
    private RegionService regionService;

    /**
     * @Author 毛一钦
     * @Date 2022/2/14 15:50
     * @Description selectOne
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "patient", key = "#id")
    public ResponseVO selectOne(String id) {
        QueryWrapper<Patient> patientQueryWrapper = new QueryWrapper<>();
        patientQueryWrapper.eq("id", id);
        Patient patient = this.baseMapper.selectOne(patientQueryWrapper);
        return ResponseVO.success(patient);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/23 21:22
     * @Description selecetPage
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "patient")
    public ResponseVO selecetPage(PatientPageDTO dto) {
        IPage<Patient> page = new Page(dto.getCurrent(), dto.getSize(), dto.getTotal());
        Patient patient = new Patient();
        try {
            patient.setName(dto.getName());
            patient.setSource(dto.getSource());
            patient.setSex(dto.getSex());
            patient.setStatus(dto.getStatus());
            patient.setRegionId(dto.getRegionId());
            patient.setCrowd(dto.getCrowd());
        } catch (Exception e) {
            log.info(StringUtil.errorToString(e));
        }
        page = this.baseMapper.selectAllByPage(page, patient);
        PatientPageVO vo = new PatientPageVO();
        try {
            vo.setCurrent(page.getCurrent())
                    .setTotal(page.getTotal())
                    .setPage(page.getPages())
                    .setSize(page.getSize())
                    .setRecords(page.getRecords());
        } catch (Exception e) {
            log.info(StringUtil.errorToString(e));
        }
        return ResponseVO.success(vo);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 20:41
     * @Description insertOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = {"patient",
            "region",
            "crowdStatistics",
            "regionStatistics",
            "statusStatistics",
            "infectionDegree"}, allEntries = true, beforeInvocation = true)
    public ResponseVO insertOne(PatientDTO dto) {
        QueryWrapper<Patient> patientQueryWrapper = new QueryWrapper<>();
        patientQueryWrapper.eq("identity_card", dto.getIdentityCard());
        Patient patient = this.baseMapper.selectOne(patientQueryWrapper);

        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        regionQueryWrapper.eq("id", dto.getRegionId());
        Region region = this.regionService.getBaseMapper().selectOne(regionQueryWrapper);

        if (patient != null && region == null) {
            return ResponseVO.newInstance(PageResponseEnum.PAGE_ERR, "录入失败", null);
        }
        try {
            dto.setUpdateDate(new Date());
            this.baseMapper.insert(dto);
            // 地区人数 + 1
            region.setRegionCount(region.getRegionCount() + 1);
            this.regionService.updateById(region);
            return ResponseVO.success(null);
        } catch (Exception e) {
            StringUtil.errorToString(e);
            //  事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResponseVO.error();
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:49 
     * @Description updateOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @CacheEvict(value = {"patient",
            "crowdStatistics",
            "regionStatistics",
            "statusStatistics",
            "infectionDegree"}, allEntries = true, beforeInvocation = true)
    public ResponseVO updateOne(PatientDTO dto) {
        QueryWrapper<Patient> wrapper = new QueryWrapper<>();
        wrapper.eq("id", dto.getId());
        dto.setUpdateDate(new Date());
        this.baseMapper.updateById(dto);
        return ResponseVO.success(null);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/3 17:25
     * @Description deleteOne
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = {"patient",
            "region",
            "crowdStatistics",
            "regionStatistics",
            "statusStatistics",
            "infectionDegree"}, allEntries = true, beforeInvocation = true)
    public ResponseVO deleteOne(String param) {
        QueryWrapper<Patient> patientQueryWrapper = new QueryWrapper<>();
        patientQueryWrapper.eq("id",param);
        Patient patient = this.baseMapper.selectOne(patientQueryWrapper);

        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        regionQueryWrapper.eq("id", patient.getRegionId());
        Region region = this.regionService.getBaseMapper().selectOne(regionQueryWrapper);

        if (patient == null && region == null) {
            return ResponseVO.newInstance(PageResponseEnum.PAGE_ERR, "没有数据", null);
        }
        try {
            //  删除患者信息
            this.baseMapper.delete(patientQueryWrapper);
            //  地区数减一
            region.setRegionCount(region.getRegionCount() - 1);
            this.regionService.updateById(region);
            return ResponseVO.success(null);
        } catch (Exception e) {
            StringUtil.errorToString(e);
            //  事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResponseVO.error();
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:49 
     * @Description SelectListByCrowdStatistics
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "crowdStatistics")
    public ResponseVO selectListByCrowdStatistics() {
        List<StatisticsVO> statisticsVOList = this.baseMapper.selectListByCrowdStatistics();
        return ResponseVO.success(statisticsVOList);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:49
     * @Description SelectListByRegionStatistics
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    @Cacheable(value = "regionStatistics")
    public ResponseVO selectListByRegionStatistics() {
        List<StatisticsVO> statisticsVOList = this.baseMapper.selectListByRegionStatistics();
        return ResponseVO.success(statisticsVOList);
    }

    @Override
    @Cacheable(value = "statusStatistics")
    public ResponseVO selectListByStatusStatistics() {
        List<StatisticsVO> statisticsVOList = this.baseMapper.selectListByStatusStatistics();
        return ResponseVO.success(statisticsVOList);
    }

    @Override
    @Cacheable(value = "infectionDegree")
    public ResponseVO statisticsInfectionDegree() {
        StatisticsInfectionDegreeVO vo = new StatisticsInfectionDegreeVO();
        List<String> dateList = this.baseMapper.selectListByDateStatistics();
        List<StatisticsVO> statisticsList = this.baseMapper.selectListByStatusStatistics2();
        try {
            vo.setDateList(dateList).setStatisticsList(statisticsList);
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(vo);
    }


}
