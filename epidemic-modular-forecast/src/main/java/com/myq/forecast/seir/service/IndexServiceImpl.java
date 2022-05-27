package com.myq.forecast.seir.service;

import com.myq.epidemic.common.model.dto.ParamDTO;
import com.myq.epidemic.setting.model.dto.BasicDTO;
import com.myq.forecast.seir.utils.ForecastUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IndexServiceImpl {

    public List getResult(BasicDTO dto) {
        ParamDTO param = new ParamDTO();
        BeanUtils.copyProperties(dto, param);
        try {
            param.setN(dto.getE() + dto.getS() + dto.getI());
            param.setT0(0);
            param.setTMax(Integer.parseInt(dto.getTime()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info("传入参数异常----> {}",dto.toString());
        }
        List result = ForecastUtil.getInstance().getResult(param);
        return result;
    }
}
