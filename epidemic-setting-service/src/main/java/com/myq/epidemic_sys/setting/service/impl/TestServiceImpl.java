package com.myq.epidemic_sys.setting.service.impl;


import com.myq.epidemic_sys.setting.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    @Cacheable(value = "test", key = "")
    public String test1() {
        System.out.println("没走缓存");
        return "走了缓存";
    }


}
