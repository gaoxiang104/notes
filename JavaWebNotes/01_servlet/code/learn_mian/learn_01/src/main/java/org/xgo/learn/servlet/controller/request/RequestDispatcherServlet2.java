package org.xgo.learn.servlet.controller.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/req/d2"})
public class RequestDispatcherServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = (String) req.getAttribute("name");
        System.out.printf("getAttribute(), name: %s", name);

        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.print("<h1>DISPATCHER SUCCESS 成功 !!! ~~~</h1>");
        }
    }
}
