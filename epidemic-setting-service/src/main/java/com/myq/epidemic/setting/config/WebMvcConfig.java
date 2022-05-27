
package com.myq.epidemic.setting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 生产traceid的拦截器LogInterceptor到容器
 * @Author: zy
 */

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


/**
     * 注解LogInterceptor类到IOC容器中
     */

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册日志拦截器
        registry.addInterceptor(logInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * 解决 webmvc 与 swagger 页面冲突的问题
         * https://blog.csdn.net/Kerwin_luo/article/details/114266444
         * @param registry
         */

        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);

        //添加静态页面资源，文件下载资源等
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/",
                "classpath:/resources/", "classpath:/static/", "classpath:/public/","file:/E:/","file:/");
    }

}

