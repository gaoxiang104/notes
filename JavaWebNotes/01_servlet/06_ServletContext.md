# 6. ServletContext

- [6. ServletContext](#6-servletcontext)
  - [6.1. ServletContext 基本介绍](#61-servletcontext-基本介绍)

## 6.1. ServletContext 基本介绍

- ServletContext 是一个接口，它表示 Servlet 上下文对象；
- 一个 web 工程，只有一个 ServletContext 对象实例；
- ServletContext 对象是在 web 工程启动的时候被创建，在 web 工程停止时销毁；
- ServletContext 对象可以通过 `ServletConfig.getServletContext()` 方法获得 `ServletContext` 对象引用，也可以通过 `this.getServletContext()` 来获得其对象的引用；
- 由于一个 web 应用中的所有 Servlet 共享一个 ServletContext 对象，因此 Servlet 对象之间可以通过 `ServletContext` 对象来实现多个 `Servlet` 间通讯。 `ServletContext` 对象通常也被称之为 `域对象` ;

![07.png](./imgs/07.png)