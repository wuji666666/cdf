package com.yong.cdf.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截
 * @Author
 * @Date 2021/5/11
 * @Time 20:50
 * @Version 1.0
 */

//@Configuration
public class WebMvcConf implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/cdf/buyer/**")
//                .excludePathPatterns("/seller/login")
//                .excludePathPatterns("/seller/login/system")
//                .excludePathPatterns("/seller/register")
//                .excludePathPatterns("/seller/register/system")
//                .excludePathPatterns("login.html")
//                .excludePathPatterns("register.html");
    }
}
