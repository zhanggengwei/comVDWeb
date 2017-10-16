package com.exception;
import org.slf4j.Logger;
import org.springframework.web.servlet.*;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;


public class DefaultExceptionHandler implements HandlerExceptionResolver {
    private static Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  Exception ex) {
        ModelAndView mv = new ModelAndView();
            /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", "1000001");
        attributes.put("msg", ex.getMessage());
        view.setAttributesMap(attributes);
        mv.setView(view);
        log.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }
}