package com.example.ServletFilter.configuration;

import com.example.ServletFilter.filter.LoggingFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class filterConfig {

//    @Bean
//    public Filter loggingFilter(){
//        return new LoggingFilter();
//    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/*"); // Apply filter to all URLs
        registrationBean.setOrder(1); // Set precedent (lower value means higher priority)

        return registrationBean;
    }
}
