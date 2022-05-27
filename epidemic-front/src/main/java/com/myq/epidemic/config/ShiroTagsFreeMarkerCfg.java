package com.myq.epidemic.config;

import com.myq.epidemic.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ShiroTagsFreeMarkerCfg {

    @Autowired
    private FreeMarkerConfigurer configuration;

    @PostConstruct
    public void setSharedVariable() throws TemplateModelException {
        log.info("设置freeMarker 的shiro 标签");
        configuration.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }

}
