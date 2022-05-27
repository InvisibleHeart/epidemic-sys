package com.myq.epidemic.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic.setting.entity.Morbidity;
import com.myq.epidemic.setting.model.dto.MorbidityDTO;
import com.myq.epidemic.setting.model.dto.MorbidityPageDTO;
import com.myq.epidemic.common.model.ResponseVO;


/**
 * (Morbidity)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 16:11:55
 */
public interface MorbidityService extends IService<Morbidity> {

    /**
     * @Author 毛一钦
     * @Date 2022/2/21 17:23
     * @Description selectByPage 分页请求
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selectByPage(MorbidityPageDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:25
     * @Description insertOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO insertOne(MorbidityDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:25
     * @Description updateOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO updateOne(MorbidityDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/3/3 17:23
     * @Description deleteOne
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO deleteOne(String param);
}
