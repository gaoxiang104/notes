package org.xgo.learn.servlet.controller.servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取 ServletConfig
 */
public class DBServlet extends HttpServlet {

    /**
     * 1。当 DBServlet 对象初始化时，tomcat 会同时创建一个 ServletConfig 对象；
     * 2。这时如果 DBServlet init() 方法调用 super.init(config)
     * 3。调用 父类 GenericServlet 的 public void init(ServletConfig config) 方法，
     * 4。因此如果你重写 init() 方法，记住如果你想在其他方法通过 getServletConfig() 方法获取 ServletConfig，则一定要记住调用 super.init(config);
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String pwd = servletConfig.getInitParameter("pwd");

        System.out.printf("username=%s, pwd=%s \n", username, pwd);
    }
}
