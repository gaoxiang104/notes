package org.xgo.learn.servlet.controller.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class TestAnnotationServlet {

    private static final Map<String, HttpServlet> hm = new HashMap();

    public static void main(String[] args) throws Exception {

        // 1. 首先要得到扫描的包 路径
        String classAllPath = "org.xgo.learn.servlet.controller.annotation.OkServlet";
        // 2. 得到 OkServlet 的 Class 对象
        Class<?> aClass = Class.forName(classAllPath);
        // 3. 通过 class 对象， 得到 Annotation
        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        System.out.println(annotation);
        String[] strings = annotation.urlPatterns();
        for (String url : strings) {
            System.out.println("url=" + url);
        }

        // 4. 如果匹配URL，如果时第一次，Tomcat 就会创建一个 OkServlet 实例，放入到 hashMap
        // 通过反射的方式，创建 OkServlet
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        OkServlet okServlet = (OkServlet) constructor.newInstance();
        System.out.println("instance= " + okServlet);

        // 简单模拟放入 hashMap
        hm.put(aClass.getName(), okServlet);
    }
}
