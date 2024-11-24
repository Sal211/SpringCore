package com.example.ServletFilter.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//  avoid handling repeated executions of the same request
public class CustomHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Add a custom header to the response
        response.addHeader("X-Custom-Header", "CustomValue");

        // Log request info
        System.out.println("Processing request URI: " + request.getRequestURI());

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }


}
