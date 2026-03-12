package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Root path
        registry.addViewController("/").setViewName("forward:/index.html");
        
        // Single level paths like /register, /login
        registry.addViewController("/{x:[\\w\\-]+}").setViewName("forward:/index.html");
        
        // Nested paths like /admin/dashboard, /user/profile
        registry.addViewController("/{x:^(?!api$).*$}/**").setViewName("forward:/index.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static resources (CSS, JS, images)
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}