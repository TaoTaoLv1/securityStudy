package com.ywt.com.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *   只是加上 @Component 注解并不能起作用， 还需要在 WebConfig 里 添加配置
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 在 controller 的方法之前被调用
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("preHandle");

        //object handler 参数 是 真正处理当前 request 请求 controller 的方法
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", new Date().getTime());
        return true;
    }

    /**
     * 在 controller 的方法之后被调用
     *     如果方法抛出异常，则不会调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        System.out.println("postHandle");
        System.out.println("时间拦截器postHandle耗时：" + (new Date().getTime() - (long) request.getAttribute("startTime")));
    }

    /**
     *  无论 controller 的方法 是否抛出异常 都会调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        System.out.println("afterCompletion");
        System.out.println("时间拦截器afterCompletion耗时：" + (new Date().getTime() - (long) request.getAttribute("startTime")));
        System.out.println("ex : " + ex);
    }
}
