//package com.hzwtech.cjwjs.util.shiro;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map
//
///**
// * @author Jasper Liuzengyu 刘增玉
// * @version v1.0.0
// * @description
// * @date 2021/6/2
// * @since v1.0
// */
//@Configuration
//public class ShiroConfig {
//    @Bean
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
//        //设置安全管理器
//        bean.setSecurityManager(securityManager);
//        Map<String ,String > filterMap=new LinkedHashMap<>();
//        filterMap.put("/htApi/testshiro2","perms[user:1]");
//        //设置放行的url，在/*之前放行
//        filterMap.put("/htApi/login", "anon");
//        //拦截所有没有自定义放行的url
//        filterMap.put("/htApi/*","authc");
//        bean.setFilterChainDefinitionMap(filterMap);
//        //没有登录的操作，可以指定一个html或者返回json到前端（前后端分离项目）
//        bean.setLoginUrl("/htApi/toLogin");
//        //没有权限的操作，可以指定一个html或者返回json到前端（前后端分离项目）
//        bean.setUnauthorizedUrl("/htApi/toPower");
//        return bean;
//    }
//    @Bean
//    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
//        securityManager.setRealm(userRealm);
//        return  securityManager;
//    }
//    @Bean
//    public  UserRealm userRealm(){
//        return new UserRealm();
//    }
//}
