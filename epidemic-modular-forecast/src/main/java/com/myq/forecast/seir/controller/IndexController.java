package com.myq.forecast.seir.controller;

import com.myq.epidemic.setting.interfaces.SimulationInterface;

import com.myq.epidemic.common.model.dto.ParamDTO;
import com.myq.epidemic.setting.model.dto.BasicDTO;
import com.myq.forecast.seir.service.IndexServiceImpl;
import com.myq.forecast.seir.utils.ForecastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class IndexController implements SimulationInterface {

    @Autowired
    private IndexServiceImpl indexService;

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

    @Override
    @PostMapping("/basic")
    public List getResult(@RequestBody BasicDTO param) {
        return this.indexService.getResult(param);
    }
}
