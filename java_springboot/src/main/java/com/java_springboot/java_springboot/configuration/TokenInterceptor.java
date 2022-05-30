package com.java_springboot.java_springboot.configuration;


import com.java_springboot.java_springboot.Response.regresponse;
import com.java_springboot.java_springboot.Response.tregpostres;
import com.java_springboot.java_springboot.Service.bankdataservice;
import com.java_springboot.java_springboot.Service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    regservice regs;
    @Autowired
    bankdataservice service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandler");
        String url = request.getRequestURI();
        //passing the headers
        if (url.contains("/SelectCustomers")||url.contains("/web")||url.contains("html")|| url.contains("/customerregerror")|| url.contains("/cutsomerreg")|| url.contains("/logintE")) {
                 return true;

        }
        else   {
            try {
                String token = request.getHeader("token");
              String user_id = request.getHeader("user_id");
               // regresponse res=new regresponse();
                System.out.println("token is" + token);
                if (token.equals("") || token == null) {
                    System.out.println("empty token, so cannot go to the controller");
                     throw new Exception("token is empty");
                    //return false;
                }
                if (user_id.equals("") || user_id == null) {
                    System.out.println("empty user_id, so cannot go to the controller");
                    throw new Exception("user id is empty");
                    //return false;
                }

                if (service.TokenValidation(token,user_id)){
                    return true;
                }

                 else if ( regs.tokenValidation(user_id, token)) {
                   return true;
                }

                else {
                    return false;
                }

            } catch (Exception e) {
                //e.printStackTrace();
                response.getWriter().append("token error" + "" + e.getMessage());
                throw new CustomException(e.getMessage());

            }

        }

    }
        @Override
        public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
        modelAndView) throws Exception {
            System.out.println("posthandler");
        }

        @Override
        public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
        ex) throws Exception {
            System.out.println("aftercompletion");
        }

}