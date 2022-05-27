package com.myq.epidemic.config;

import com.myq.epidemic.shiro.realm.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //  1.创建shiroFilter     负责拦截请求的
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //  给Filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //  配置系统的受限资源

        // 配置系统的公共资源
        /**
         * anon 匿名访问
         * authc 需获取相关认证信息才允许访问
         * authcBasic 需要basic登陆
         * logout 登出过滤器
         * port 指定端口访问
         * ssl  指定https访问
         * user 已登出或记住我才能访问
         * 。。。。
         **/
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/logout.html", "logout");
        filterChainDefinitionMap.put("/register.html", "anon");
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/pub/statistics/**", "anon");
        filterChainDefinitionMap.put("/sys/**", "authc");


        //  默认认证路径
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //  设置过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return shiroFilterFactoryBean;
    }

    //  2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //  给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //  3.创建自定义realm
    @Primary
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }

}
