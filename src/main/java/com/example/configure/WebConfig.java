package com.example.configure;

import com.example.interceptor.Logininterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration registration=registry.addInterceptor(new Logininterceptor());
        registration.excludePathPatterns(
                "/login.html",
                "/register.html",
                "/css/**",
                "/font/css",
                "/img/css",
                "/user/**"
        );
    }
}
