package org.xgo.learn.servlet.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RegisterServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("RegisterServlet.service()");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        if ("get".equalsIgnoreCase(httpServletRequest.getMethod())){
            doGet();
        } else if("post".equalsIgnoreCase(httpServletRequest.getMethod())){
            doPost();
        }
    }

    private void doGet(){
        System.out.println("doGet()");
    }

    private void doPost(){
        System.out.println("doPost()");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
