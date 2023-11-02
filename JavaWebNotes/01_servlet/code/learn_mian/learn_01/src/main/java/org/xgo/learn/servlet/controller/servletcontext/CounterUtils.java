package org.xgo.learn.servlet.controller.servletcontext;

import javax.servlet.ServletContext;

/**
 * 网站计数器 Utils
 */
public class CounterUtils {

    /**
     * Servlet 访问一次，计数加一次
     *
     * @param servletContext
     * @return
     */
    public static Integer add(ServletContext servletContext) {
        Integer counter = (Integer) servletContext.getAttribute("counter");
        if (null == counter) {
            counter = 1;
        } else {
            counter++;
        }
        servletContext.setAttribute("counter", counter);
        return counter;
    }

    /**
     * 返回 计数器值
     * @param servletContext
     * @return
     */
    public static Integer getCount(ServletContext servletContext) {
        Integer counter = (Integer) servletContext.getAttribute("counter");
        if (null == counter) {
            counter = 0;
        }
        return counter;
    }

}
