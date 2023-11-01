package org.xgo.learn.servlet.controller.work02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 练习：重定向
 */
@WebServlet(urlPatterns = {"/org/xgo/learn/servlet/controller/work02/rd"})
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/learn_01/work02/hi.html");
    }
}
