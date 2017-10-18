package com.interceptor;

/**
 *
 */

import com.User.model.UserAuth;
import com.User.services.UserInfoAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @author zh
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    @Autowired

    private UserInfoAuthService authService;


    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
    private void writeContent(String content,HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("icop-content-type", "exception");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.print(content);
        writer.flush();
        writer.close();
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
        System.out.println("fdf");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // writeContent("code:dfd",response);
//        String token = request.getHeader("token");
//        if(token==null)
//        {
//             throw  new RuntimeException("token is nil ");
//        }else
//        {
//            UserAuth auth = authService.searchAuthByToken(token);
//            if(auth==null)
//            {
//                throw  new RuntimeException("token is error");
//            }
//            if(auth.tokenIsValid())
//            {
//                return super.preHandle(request, response, handler);
//            }else
//            {
//                throw  new RuntimeException();
//            }
//            request.setAttribute("userId","2");
            return super.preHandle(request,response,handler);
//        }

    }
}
