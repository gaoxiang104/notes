package org.xgo.learn.servlet.controller.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/req/register"})
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestServlet.doPost() start");

        // 获取请求的资源路径
        String requestURI = req.getRequestURI();
        System.out.printf("requestURI: %s \n", requestURI);

        StringBuffer requestURL = req.getRequestURL();
        System.out.printf("requestURL: %s \n", requestURL);

        // 获取客户IP
        String remoteAddr = req.getRemoteAddr();
        System.out.printf("remoteAddr: %s \n", remoteAddr);

        // 获取头信息
        String host = req.getHeader("Host");
        System.out.printf("host: %s \n", host);

        String referer = req.getHeader("Referer");
        System.out.printf("referer: %s \n", referer);

        String userAgent = req.getHeader("User-Agent");
        System.out.printf("userAgent: %s \n", userAgent);

        // 获取参数
        // 注意：获取参数中乱码解决方案
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String[] fruits = req.getParameterValues("fruit");
        System.out.printf("name=%s, pwd=%s, fruits=%s \n", name, pwd, Arrays.toString(fruits));

        // 获取 requestBody 中的 raw(原始数据)
        // 注意，getParameter() 和 getInputStream() 两者只能选其一
//        ServletInputStream inputStream = req.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(URLDecoder.decode(line, "utf-8"));
//        }
//        reader.close();

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        String cookiesStr = Arrays.stream(cookies)
                .map(cookie -> cookie.getName() + "=" + cookie.getValue())
                .collect(Collectors.joining(","));

        System.out.printf("cookies: [%s], session: %s \n", cookiesStr, session.getId());


        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.print("<h1>SUCCESS 成功 !!! ~~~</h1>");
        }
    }
}
