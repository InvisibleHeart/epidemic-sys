package com.myq.epidemic_sys.setting.interfaces;

import com.myq.epidemic_sys.common.model.dto.ParamDTO;
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
}
