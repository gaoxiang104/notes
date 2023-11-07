package org.xgo.learn.servlet.controller.work03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/work03/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userAgent = req.getHeader("User-Agent");
        String[] parts = userAgent.split("\\s+");
        System.out.println(Arrays.toString(parts));

        Map<String, String> userAgentInfo = new HashMap<>();
        if (parts.length >= 5) {
            userAgentInfo.put("Browser", parts[5]);
            userAgentInfo.put("Version", parts[6]);

            String osInfo = parts[1];
            osInfo = osInfo.replaceAll("[()]", ""); // 移除括号
            String[] osParts = osInfo.split(";");

            if (osParts.length >= 3) {
                userAgentInfo.put("OS", osParts[0]);
                userAgentInfo.put("OS Version", osParts[2]);
            }
        }


        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String confirmPwd = req.getParameter("confirmPwd");
        String[] sports = req.getParameterValues("sport");
        String gender = req.getParameter("gender");
        String favoriteCity = req.getParameter("favoriteCity");
        String intro = req.getParameter("intro");

        StringBuilder result = new StringBuilder("<ul>");
        result.append("<li>用户注册信息</li>");
        result.append("<li>用户名称：").append(name).append("</li>");
        result.append("<li>用户密码：").append(password).append("</li>");
        result.append("<li>确认密码：").append(confirmPwd).append("</li>");
        result.append("<li>你喜欢的运动项目：").append(Arrays.toString(sports)).append("</li>");
        result.append("<li>你的性别：").append(gender).append("</li>");
        result.append("<li>你喜欢的城市：").append(favoriteCity).append("</li>");
        result.append("<li>自我介绍：").append(intro).append("</li>");
        result.append("</ul>");

        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.print(result);
        }

    }
}
