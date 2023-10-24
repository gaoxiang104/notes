package org.xgo.learn.servlet.controller;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
    /**
     * 1. 初始化 servlet
     * 2. 当创建 HelloServlet 实例时，会调用 init 方法
     * 3. 该方法只会被调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet.init()");
    }

    /**
     * 返回 servlet 的配置
     * @return 返回 ServletConfig 对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 1. service 方法处理 浏览器的请求（包括get/post）
     * 2. 当浏览器每次请求 servlet 时，就会调用一次 service
     * 3. 当 tomcat 调用该方法时，会把 http 请求的数据封装成实现了 ServletRequest 接口的 request 对象
     * 4. 通过 ServletRequest 对象，可以得到用户提交的数据
     * 5. ServletResponse 对象可以用于返回数据给 tomcat，tomcat 再返回浏览器
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.print("HelloServlet.service() : ");
        System.out.printf("Thread_id_%s" , Thread.currentThread().getId());
        System.out.println();
        try (PrintWriter writer = servletResponse.getWriter()) {
            writer.print("<h3>Hello Servlet !!!!</h3>");
        }
    }

    /**
     * 返回 servlet 信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 1. 该方法是在 servlet 销毁时，被调用
     * 2. 只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("HelloServlet.destroy()");
    }
}
