package com.myq.epidemic_sys.setting.controller;


import com.myq.epidemic_sys.common.model.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseVO test() {
        return ResponseVO.success(null);
    }

}
