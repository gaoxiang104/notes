package org.xgo.learn.servlet.controller.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet(urlPatterns = {"/context01"})
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取 ServletContext 对象
        ServletContext servletContext = getServletContext();
        // 2. 获取 context-param 数据
        String website = servletContext.getInitParameter("website");
        String company = servletContext.getInitParameter("company");
        System.out.printf("website=%s, company=%s \n", website, company);
        // 3. 获取项目的工程路径
        String contextPath = servletContext.getContextPath();
        System.out.printf("contextPath=%s \n", contextPath);
        // 4. 获取项目发布，正在的工作路径
        URL resource = servletContext.getResource("/");
        // 真实工作 根路径
        String realPath = servletContext.getRealPath("/");
        System.out.printf("resource=%s \n", resource);
        System.out.printf("realPath=%s \n", realPath);
    }
}
