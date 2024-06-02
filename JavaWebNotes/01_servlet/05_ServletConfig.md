# 5. ServletConfig

- [5. ServletConfig](#5-servletconfig)
  - [5.1. ServletConfig 基本介绍](#51-servletconfig-基本介绍)
  - [5.2. ServletConfig 类能干什么？](#52-servletconfig-类能干什么)
  - [5.3. 案例：配置 DBServlet](#53-案例配置-dbservlet)

## 5.1. ServletConfig 基本介绍

- `ServletConfig` 类是为 `Servlet` 程序的配置信息的类；
- `Servlet` 程序和 `ServletConfig` 对象是由 `Tomcat` 负责创建的；
- `Servlet` 程序默认时第1次访问的时候创建，`ServletConfig` 在 `Servlet` 程序创建时，就创建一个对应的 `ServletConfig` 对象；

## 5.2. ServletConfig 类能干什么？

- 获取 `Servlet` 程序的 `servlet-name` 的值；
- 获取初始化参数 `init-param` ；
- 获取 `ServletContext` 对象；

## 5.3. 案例：配置 DBServlet

- 在 `web.xml` 中配置 mysql的相关配置：`username` 和 `pwd` ，并且在 `DBServlet` 中获取配置信息；

- wex.xml 相关配置：

``` xml
<web-app>
  <servlet>
    <servlet-name>DBServlet</servlet-name>
    <servlet-class>org.xgo.learn.servlet.controller.servletconfig.DBServlet</servlet-class>
    <init-param>
      <param-name>username</param-name>
      <param-value>root</param-value>
    </init-param>
    <init-param>
      <param-name>pwd</param-name>
      <param-value>1234</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>DBServlet</servlet-name>
    <url-pattern>/dbServlet</url-pattern>
  </servlet-mapping>
</web-app>
```

- DBServlet.java ：

    ``` java
    public class DBServlet extends HttpServlet {

        /**
        * 1。当 DBServlet 对象初始化时，tomcat 会同时创建一个 ServletConfig 对象；
        * 2。这时如果 DBServlet init() 方法调用 super.init(config)
        * 3。调用 父类 GenericServlet 的 public void init(ServletConfig config) 方法，
        * 4。因此如果你重写 init() 方法，记住如果你想在其他方法通过 getServletConfig() 方法获取 ServletConfig，则一定要记住调用 super.init(config);
        * @param config
        * @throws ServletException
        */
        @Override
        public void init(ServletConfig config) throws ServletException {
            super.init(config); // 注意，一定要调用哦
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            ServletConfig servletConfig = getServletConfig();
            String username = servletConfig.getInitParameter("username");
            String pwd = servletConfig.getInitParameter("pwd");

            System.out.printf("username=%s, pwd=%s \n", username, pwd);
        }
    }
    ```

  - `getServletConfig()` 方法是 `GenericServlet` 提供的方法；
  - 返回 `private transient ServletConfig config` ；
  - > 注意1：属性被 `transient（瞬态）` 修饰，表示该属性不会 **`序列化`**；
  - > 注意2：当重写 `public void init(ServletConfig config)` 方法时，一定记住要加上 `super.init(config)` ；否则 `GenericServlet` 中的 `ServletConfig` 为空；
  - > 注意3：如果要重写 `init(ServletConfig config)` , 建议重写 `GenericServlet` 类中的 `init()` 方法；具体细节，查看 `GenericServlet` 类的源码；
