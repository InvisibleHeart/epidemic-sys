package com.myq.epidemic.setting.controller;

import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseVO test() {
        return ResponseVO.success(null);
    }

}
