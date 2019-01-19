package com.ron.springbootshiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登陆的URL
        shiroFilterFactoryBean.setLoginUrl("/index");
        //登陆成功后的URL
        shiroFilterFactoryBean.setSuccessUrl("/main");
        //配置无权限界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //配置免密认证
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/acutator/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin","anon");
        filterChainDefinitionMap.put("/", "anon");
        // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        //设置ShiroRealm
        defaultSecurityManager.setRealm(myShiroRealm());
        return defaultSecurityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }

}
