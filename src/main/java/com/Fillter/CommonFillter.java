package com.Fillter;

import com.User.model.UserAuth;
import com.User.services.UserInfoAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Component("requestFillter")
public class CommonFillter extends CompositeFilter {

    @Autowired
    private UserInfoAuthService authService;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest rq = (HttpServletRequest)request;
        String token = token = request.getParameter("token");
        if(token==null) {
            token = rq.getHeader("token");
        }
        if(token!=null)
        {
            UserAuth auth = authService.searchAuthByToken(token);
            if(auth!=null) {
                request.setAttribute("auth", auth);
                request.setAttribute("userId",auth.getUserId());
            }
        }
        chain.doFilter(request,response);
    }

}
