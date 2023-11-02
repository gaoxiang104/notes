package org.xgo.learn.servlet.controller.servletcontext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/counter01"}, name = "CounterServlet_01")
public class CounterServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String servletName = servletConfig.getServletName();

        ServletContext servletContext = getServletContext();
        // 计数器值+1
        Integer counter = CounterUtils.add(servletContext);

        String output = String.format("正在访问%s，当前网站访问人数是：%d", servletName, counter);
        System.out.printf("%s \n", output);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            output = "<h1>" + output + "</h1>";
            writer.print(output);
        }
    }
}
