package com.hana.config;

import com.hana.filter.LoginCheckFilter;
import jakarta.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${app.dir.imgdir}")
    String imgdir;
    @Value("${app.dir.logdir}")
    String logdir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("================"+logdir);
        log.info("================"+imgdir);


        registry.addResourceHandler("/imgs/**").addResourceLocations(imgdir);
        registry.addResourceHandler("/logs/**").addResourceLocations(logdir);
    }

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter()); //내가 구현한 필터 넣기
        filterRegistrationBean.setOrder(1); //필터 체인할 때 가장 먼저 실행
        filterRegistrationBean.addUrlPatterns("/*"); //모든 요청 url에 대해 실행
        return filterRegistrationBean;
    }


}