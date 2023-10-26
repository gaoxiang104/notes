package org.xgo.learn.servlet.controller.work01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CatServlet implements Servlet {
    private int count = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getMethod().equalsIgnoreCase("get")) {
            this.doGet(servletRequest, servletResponse);
        } else if (request.getMethod().equalsIgnoreCase("post")) {
            this.doPost(servletRequest, servletResponse);
        }
    }

    private void doGet(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.printf("CatServlet.doGet(), count = %d", count);
        System.out.println();
    }

    private void doPost(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.printf("CatServlet.doPost(), count = %d", count);
        System.out.println();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
