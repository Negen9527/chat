package com.negen.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @ Author     ：Negen
 * @ Date       ：Created in 14:51 2020/3/26
 * @ Description：测试
 * @ Modified By：
 * @Version: 1.0
 */
@Slf4j
//@Component
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Negen====>doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUri = httpServletRequest.getRequestURI();
        String productName = request.getParameter("productName");
        if(StringUtils.isEmpty(productName)){
            chain.doFilter(request,response);
        }else{
            request.getRequestDispatcher("/user/testProductName").forward(request,response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
