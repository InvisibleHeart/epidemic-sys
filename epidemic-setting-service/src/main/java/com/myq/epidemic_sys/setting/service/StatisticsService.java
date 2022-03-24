package com.myq.epidemic_sys.setting.service;


import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.model.dto.ForecastParamDTO;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 19:21
 **/
public interface StatisticsService {

    /**
     * @Author 毛一钦
     * @Date 2022/3/23 14:49
     * @Description diseasePrediction   无参预测
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO diseasePrediction();

    /**
     * @Author 毛一钦
     * @Date 2022/3/23 14:49
     * @Description diseasePrediction   有参预测
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    ResponseVO diseasePrediction(ForecastParamDTO dto);


}
