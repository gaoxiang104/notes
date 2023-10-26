package org.xgo.learn.servlet.controller.work01;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DogServlet extends HttpServlet {
    private int getCount = 0;
    private int postCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCount++;
        System.out.printf("DogServlet.doGet(), getCount = %d", getCount);
        System.out.println();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postCount++;
        System.out.printf("DogServlet.doPost(), postCount = %d", postCount);
        System.out.println();
    }


}
