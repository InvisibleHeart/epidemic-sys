package com.myq.epidemic.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysIndexController {

    private String prefix = "/sys/";

    // 后台首页
    @GetMapping("/sys/index.html")
    public String sysIndexHtml() {
        return prefix + "index";
    }

}
