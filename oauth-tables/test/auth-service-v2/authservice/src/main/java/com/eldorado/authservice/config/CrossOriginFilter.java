//package com.eldorado.authservice.config;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Allows cross origin for testing swagger docs using swagger-ui from local file
// * system
// */
//@Component
//public class CrossOriginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//        // Called by the web container to indicate to a filter that it is being
//        // placed into service.
//        // We do not want to do anything here.
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletResponse response = (HttpServletResponse) resp;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "0");
//        chain.doFilter(req, resp);
//    }
//
//    @Override
//    public void destroy() {
//
//        // Called by the web container to indicate to a filter that it is being
//        // taken out of service.
//        // We do not want to do anything here.
//    }
//}