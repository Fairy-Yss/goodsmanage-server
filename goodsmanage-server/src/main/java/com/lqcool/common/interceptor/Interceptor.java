package com.lqcool.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 定义的拦截器，在将请求发送给控制器之前执行相应的操作，在将结果返回到客户端之前执行相应的操作，在请求完成以后执行相应的操作
 */
@Component
public class Interceptor implements HandlerInterceptor {
    /**
     * 用于在将请求发送到控制器之前执行操作。此方法应返回true，以将响应返回给客户端。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object account = session.getAttribute("account");

        if(null != account) { //已登录，返回true，将请求转发至各个controller执行
            return true;
        }else {//未登录 设置状态码401，表示需要登陆
            response.setStatus(401);
            return false;
        }
    }
    /**
     * 用于在将响应发送到客户端之前执行操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }
    /**
     * 用于在完成请求和响应后执行操作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
