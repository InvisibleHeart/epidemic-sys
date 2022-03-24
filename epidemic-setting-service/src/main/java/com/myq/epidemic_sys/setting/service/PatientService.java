package com.myq.epidemic_sys.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.entity.Patient;
import com.myq.epidemic_sys.setting.model.dto.PatientDTO;
import com.myq.epidemic_sys.setting.model.dto.PatientPageDTO;


/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 16:13:13
 */
public interface PatientService extends IService<Patient> {

    /**
     * @Author 毛一钦
     * @Date 2022/2/14 15:49 
     * @Description selectOne
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selectOne(String id);

    /**
     * @Author 毛一钦
     * @Date 2022/2/23 21:20
     * @Description selecetPage
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selecetPage(PatientPageDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 20:40
     * @Description insertOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO insertOne(PatientDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 21:24
     * @Description updateOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO updateOne(PatientDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/3/3 17:25
     * @Description deleteOne
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO deleteOne(String param);

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 19:45
     * @Description SelectListByCrowdStatistics
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selectListByCrowdStatistics();

    ResponseVO selectListByRegionStatistics();

    ResponseVO selectListByStatusStatistics();

    ResponseVO statisticsInfectionDegree();
}
