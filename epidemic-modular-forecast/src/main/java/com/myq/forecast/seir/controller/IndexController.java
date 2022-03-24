package com.myq.forecast.seir.controller;


import com.myq.epidemic_sys.common.model.dto.ParamDTO;
import com.myq.epidemic_sys.setting.interfaces.SimulationInterface;

import com.myq.forecast.seir.utils.ForecastUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IndexController implements SimulationInterface {

    @Override
    @GetMapping("/get")
    public List simulation() {
        return ForecastUtil.getInstance().getResult(null);
    }

    @Override
    @PostMapping("/get")
    public List parametricSimulation(@RequestBody ParamDTO param) {
        return ForecastUtil.getInstance().getResult(param);
    }

}
