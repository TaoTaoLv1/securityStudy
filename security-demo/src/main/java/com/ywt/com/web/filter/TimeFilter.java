package com.ywt.com.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("时间过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("时间过滤器开始");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("时间过滤器耗时：" + (new Date().getTime() - start));
        System.out.println("时间过滤器结束");
    }

    @Override
    public void destroy() {
        System.out.println("时间过滤器销毁");
    }
}
