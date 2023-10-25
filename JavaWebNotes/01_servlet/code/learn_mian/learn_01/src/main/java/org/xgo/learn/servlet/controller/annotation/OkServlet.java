package org.xgo.learn.servlet.controller.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPattern 对应 web.xml 的 <url-pattern> <br/>
 * {"/ok1","/ok2"} 可以给 OkServlet 配置多个 url-pattern
 * initParams 对应 web.xml 中的 <init-param>
 */
@WebServlet(urlPatterns = {"/ok1", "/ok2"},
        initParams = {@WebInitParam(name = "xx", value = "yy")})
public class OkServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("OkServlet.init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OkServlet.doGet");
        resp.getWriter().print("annotation OkServlet");
    }
}
