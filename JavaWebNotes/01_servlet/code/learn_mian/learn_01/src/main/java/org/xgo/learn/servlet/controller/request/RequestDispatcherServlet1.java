package org.xgo.learn.servlet.controller.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/req/d1"})
public class RequestDispatcherServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("name","gao");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/req/d2");
        requestDispatcher.forward(req,resp);
    }
}
