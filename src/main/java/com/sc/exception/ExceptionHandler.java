package com.sc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler implements HandlerExceptionResolver {
    //Object handler 发生异常的位置,哪个包下的哪个类的哪个方法发生的异常 是一个字符串
    //接收抛出来的异常对象  Exception ex
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //异常集中处理有什么好处，不然要写很多try catch.这就是好处
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error",ex.getMessage());
        modelAndView.setViewName("/admin/404.jsp");
        return modelAndView;
    }
}
