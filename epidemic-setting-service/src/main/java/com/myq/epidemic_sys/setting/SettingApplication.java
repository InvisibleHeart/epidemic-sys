package com.myq.epidemic_sys.setting;

import com.myq.epidemic_sys.setting.config.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@MapperScan("com.myq.epidemic_sys.setting.mapper")
@ComponentScan("com.myq.epidemic_sys")
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.myq.epidemic_sys.setting.*"})
@EnableDiscoveryClient
@EnableAsync // 开启异步注解
@EnableCaching  //  开启缓存
public class SettingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SettingApplication.class, args);
        GlobalExceptionHandler bean = context.getBean(GlobalExceptionHandler.class);
        log.info(" start success ~~~");
    }
}
