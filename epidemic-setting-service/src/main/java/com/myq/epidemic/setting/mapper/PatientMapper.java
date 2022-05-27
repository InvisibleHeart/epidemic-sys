package com.myq.epidemic.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myq.epidemic.setting.entity.Patient;
import com.myq.epidemic.setting.model.vo.StatisticsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author 毛一钦
 * @Date 2022/2/8 16:31
 * @Description
 **/
@Repository
public interface PatientMapper extends BaseMapper<Patient> {

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:33 
     * @Description selectAllByPage
     * @param obj
     * @param param
     * @return com.baomidou.mybatisplus.core.metadata.IPage
     **/
    IPage selectAllByPage(IPage<Patient> obj, @Param("param") Patient param);

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:48
     * @Description selectListByCrowdStatistics
     * @param
     * @return java.util.List<com.myq.epidemic_sys.setting.model.vo.StatisticsVO>
     **/
    List<StatisticsVO> selectListByCrowdStatistics();

    List<StatisticsVO> selectListByRegionStatistics();

    List<StatisticsVO> selectListByStatusStatistics();

    List<StatisticsVO> selectListByStatusStatistics2();

    List<String> selectListByDateStatistics();
}
