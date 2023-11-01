package org.xgo.learn.servlet.controller.work02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 练习：响应 500
 */
@WebServlet("/org/xgo/learn/servlet/controller/work02/err")
public class ErrorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("/org/xgo/learn/servlet/controller/work02/err init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new RuntimeException("这里出错喽～～～");
    }
}
