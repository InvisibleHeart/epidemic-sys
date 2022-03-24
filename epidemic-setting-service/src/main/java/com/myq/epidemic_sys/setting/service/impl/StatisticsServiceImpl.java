package com.myq.epidemic_sys.setting.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.common.model.dto.ParamDTO;
import com.myq.epidemic_sys.common.utils.StringUtil;
import com.myq.epidemic_sys.setting.interfaces.SimulationInterface;
import com.myq.epidemic_sys.setting.model.dto.ForecastParamDTO;
import com.myq.epidemic_sys.setting.model.dto.Patient1DTO;
import com.myq.epidemic_sys.setting.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author 毛一钦
 * @Date 2022/3/1 19:24
 **/
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired(required = false)
    private SimulationInterface simulationInterface;

    /**
     * @Author 毛一钦
     * @Date 2022/3/23 14:50
     * @Description diseasePrediction   无参预测
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    public ResponseVO diseasePrediction() {
        List result = null;
        try {
            result = this.simulationInterface.simulation();
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(result);
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/23 14:50
     * @Description diseasePrediction   有参预测
     * @param dto
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @Override
    public ResponseVO diseasePrediction(ForecastParamDTO dto) {
        List result = null;
        try {
            ParamDTO paramDTO = JSONObject.parseObject(JSONObject.toJSONString(dto), ParamDTO.class);
            result = this.simulationInterface.parametricSimulation(paramDTO);
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(result);
    }
}
