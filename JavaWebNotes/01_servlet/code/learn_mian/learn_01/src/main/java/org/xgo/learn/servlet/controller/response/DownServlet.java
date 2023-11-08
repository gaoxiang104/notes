package org.xgo.learn.servlet.controller.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp/downServlet")
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        // 获取上下文路径，即：http://localhost:8080/【项目名】/[servlet] 中的项目名
        String contextPath = servletContext.getContextPath();

        // 方法1：使用 resp.sendRedirect() 方法
//        resp.sendRedirect(contextPath + "/resp/downServletNew");
        // 方法2：设置 302 响应码，并指定 location
        resp.setStatus(302);
        resp.setHeader("Location",contextPath + "/resp/downServletNew");
    }
}
