package com.study.drug.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限控制Shiro配置类
 */
@Configuration
public class ShiroFilterConfiguration {

    /**
     * 创建过滤工厂Bean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        /**
         * Shiro内置过滤器，实现权限相关的拦截器
         * anon:无需登录，可以访问
         * authc:必须登录才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/admin/**","anon");  //放行静态资源
        filterMap.put("/layui/**","anon");  //放行静态资源
        filterMap.put("/login","anon");     //放行登录请求
        filterMap.put("/toLogin","anon");   //放行登录请求
        filterMap.put("/**","authc");       //其他都需要登录成功才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //不登录自动转向的页面(页面一启动也会自动跳转到登录页面)
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //登录后自动转向的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        return shiroFilterFactoryBean;
    }

    /**
     * 权限管理
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 创建Realm ，认证用
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * thymeleaf整合Shiro
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}














