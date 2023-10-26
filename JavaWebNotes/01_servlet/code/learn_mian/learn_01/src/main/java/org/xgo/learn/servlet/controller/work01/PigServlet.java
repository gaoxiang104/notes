package org.xgo.learn.servlet.controller.work01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/work/pig1","/work/pig2"})
public class PigServlet extends HttpServlet {
    private int getCount = 0;
    private int postCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCount++;
        System.out.printf("PigServlet.doGet(), getCount = %d, remoteAddr= %s", getCount, req.getRemoteAddr());
        System.out.println();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postCount++;
        System.out.printf("PigServlet.doPost(), postCount = %d, remoteAddr= %s", postCount, req.getRemoteAddr());
        System.out.println();
    }
}
