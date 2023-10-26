package org.xgo.learn.servlet.controller.annotation;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * urlPattern 4种匹配方式测试
 */
@WebServlet(urlPatterns = {"/upTest/aa"}) // 精确匹配，http://localhost:8180/learn_01/upTest/aa
//@WebServlet(urlPatterns = {"/upTest/*"}) // 目录匹配，http://localhost:8180/learn_01/upTest/aa/bb
//@WebServlet(urlPatterns = {"*.action"}) // 扩展名匹配，http://localhost:8180/learn_01/upTest/cc.action
//@WebServlet(urlPatterns = {"/*"}) // 任意匹配，http://localhost:8180/learn_01/upTest/xx.do
public class UrlPatternServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.print("Hi URL Pattern");
        }
    }
}
