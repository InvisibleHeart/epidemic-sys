package com.myq.epidemic.controller.sys;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/forecast")
public class SysForecastController {

    private String prefix = "/sys/";

    // 疾病预测
    @GetMapping("/manage.html")
    public String sysIndexHtml() {
        return prefix + "forecast";
    }

}
