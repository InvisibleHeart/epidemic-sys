package com.myq.forecast.seir;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 毛一钦
 * @Date 2022/3/15 21:40
 * @Description  SEIR模型模块
 **/
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.myq.forecast.seir.*", "com.myq.epidemic.setting.interfaces"})
@SpringBootApplication
public class SeirApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeirApplication.class);
    }
}
