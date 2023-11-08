package org.xgo.learn.servlet.controller.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet("/resp/downServletNew")
public class DownServletNew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DownServletNew.doGet...");
        ServletContext servletContext = getServletContext();

        resp.setContentType("text/plain");
        // Content-Disposition 是HTTP协议中的一个头部字段，用于指示文件的名称和下载方式
        resp.setHeader("Content-Disposition","attachment; filename=\"example.txt\"");
        int bytesRead;
        byte[] buffer = new byte[1024];

        // 获取文件，并且下载
        String realPath = servletContext.getRealPath("/resp/file.txt");
        try (FileInputStream fileInputStream = new FileInputStream(realPath);
                ServletOutputStream outputStream = resp.getOutputStream();) {
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
