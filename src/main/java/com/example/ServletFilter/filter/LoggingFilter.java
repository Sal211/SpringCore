package com.example.ServletFilter.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Initializing Logging Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //  LOG REQUEST DETAIL
        logger.info("Request URI : {}", httpServletRequest.getRequestURI());
        logger.info("Request Method: {}", httpServletRequest.getMethod());
        logger.info("Client IP : {}", httpServletRequest.getRemoteAddr());

        // CONTINUE THE FILTER CHAIN
        filterChain.doFilter(servletRequest, servletResponse);

        // LOG RESPONSE DETAILS
        logger.info("Response sent for URI: {}", httpServletRequest.getRequestURI());
    }

    @Override
    public void destroy(){
        logger.info("Destroying Logging Filter");
    }
}
