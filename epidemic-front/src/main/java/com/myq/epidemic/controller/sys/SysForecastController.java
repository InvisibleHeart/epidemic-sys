package com.myq.epidemic.controller.sys;


import com.myq.epidemic.setting.interfaces.SimulationInterface;
import com.myq.epidemic.setting.model.dto.BasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sys/forecast")
public class SysForecastController {

    private String prefix = "/sys/";

    @Autowired
    private SimulationInterface simulationInterface;

    // 疾病预测
    @GetMapping("/manage.html")
    public String sysIndexHtml() {
        return prefix + "forecast";
    }

    @ResponseBody
    @PostMapping("/get")
    public List getResult(@RequestBody BasicDTO dto) {

//        @RequestParam String s,
//        @RequestParam String e,
//        @RequestParam String i,
//        @RequestParam String time

//        BasicDTO dto = new BasicDTO();
//        dto.setS(Double.parseDouble(s));
//        dto.setE(Double.parseDouble(e));
//        dto.setI(Double.parseDouble(i));
//        dto.setTime(time);
        return this.simulationInterface.getResult(dto);
    }
}
