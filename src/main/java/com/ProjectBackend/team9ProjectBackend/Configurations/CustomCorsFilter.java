//package com.ProjectBackend.team9ProjectBackend.Configurations;
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class CustomCorsFilter implements Filter {
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        try {
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//            httpResponse.setHeader("Access-Control-Max-Age", "3600");
//            httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
//
//            chain.doFilter(request, response);
//        } catch (IOException | ServletException e) {
//            throw e; // rethrow the exception to propagate it further
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization logic, if needed
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup logic, if needed
//    }
//}