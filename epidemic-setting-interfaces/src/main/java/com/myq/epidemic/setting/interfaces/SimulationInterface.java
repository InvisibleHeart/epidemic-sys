package com.myq.epidemic.setting.interfaces;

import com.myq.epidemic.common.model.dto.ParamDTO;
import com.myq.epidemic.setting.model.dto.BasicDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient("epidemic-modular-forecast")
public interface SimulationInterface {

    @GetMapping("/get")
    List simulation();

    @PostMapping("/get")
    List parametricSimulation(@RequestBody ParamDTO dto);

    @PostMapping("/basic")
    List getResult(@RequestBody BasicDTO param);
}
