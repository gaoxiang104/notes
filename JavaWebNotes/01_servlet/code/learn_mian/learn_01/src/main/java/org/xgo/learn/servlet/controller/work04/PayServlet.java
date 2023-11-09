package org.xgo.learn.servlet.controller.work04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work04/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PayServlet.doPost()");

        // 接收参数
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String amount = req.getParameter("amount");
        System.out.printf("id=%s, amount=%s \n", id, amount);
        // 处理返回
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getContextPath();

        int i = 0;
        try {
            i = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("输入的金额格式错误");
        }
        if (i > 100) {
            resp.sendRedirect(contextPath + "/work04/payok.html");
        } else {
            resp.sendRedirect(contextPath + "/work04/pay.html");
        }

    }
}
