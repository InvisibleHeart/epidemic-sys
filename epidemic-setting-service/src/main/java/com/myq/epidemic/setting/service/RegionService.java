package com.myq.epidemic.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic.setting.entity.Region;
import com.myq.epidemic.setting.model.dto.RegionDTO;
import com.myq.epidemic.setting.model.dto.RegionPageDTO;
import com.myq.epidemic.common.model.ResponseVO;

/**
 * (Region)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 16:14:15
 */
public interface RegionService extends IService<Region> {

    /**
     * @Author 毛一钦
     * @Date 2022/2/22 19:42
     * @Description queryAll
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO queryAll();

    /**
     * @Author 毛一钦
     * @Date 2022/3/8 15:11
     * @Description selectPage
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO selectPage(RegionPageDTO param);

    /**
     * @Author 毛一钦
     * @Date 2022/3/8 15:11
     * @Description insertOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO insertOne(RegionDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/3/8 15:11
     * @Description updateOne
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO updateOne(RegionDTO dto);

    /**
     * @Author 毛一钦
     * @Date 2022/3/8 15:11
     * @Description deleteOne
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO deleteOne(String param);

    ResponseVO indexOne();

    void increase(String name);

}
