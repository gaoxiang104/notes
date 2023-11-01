# 4. Http协议介绍

- [4. Http协议介绍](#4-http协议介绍)
  - [4.1. 请求头](#41-请求头)
  - [4.2. 响应头](#42-响应头)
  - [4.3. 状态码](#43-状态码)
  - [4.4. MIME 类型](#44-mime-类型)
  - [4.5. GET请求和POST请求分别有哪些？](#45-get请求和post请求分别有哪些)

## 4.1. 请求头

| 请求头名称                      | 示例值                             | 作用                                                     |
|---------------------------------|------------------------------------|----------------------------------------------------------|
| Accept                          | text/html, application/xml;q=0.9   | 告诉服务器客户端可以接受哪些媒体类型。                  |
| Accept-Language                 | en-US, en;q=0.5                    | 客户端可接受的语言及其优先级。                          |
| Accept-Encoding                 | gzip, deflate                      | 告诉服务器客户端支持的压缩算法。                        |
| User-Agent                      | Mozilla/5.0 (Windows NT 10.0; …)  | 标识客户端的用户代理（浏览器或应用程序）。               |
| Host                            | www.example.com                    | 指定服务器的主机名和端口号。                             |
| Connection                      | keep-alive                        | 控制连接的持久性（保持连接或关闭连接）。                |
| Authorization                   | Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ== | 包含用于身份验证的凭证信息。                           |
| Cookie                          | sessionid=abc; user=JohnDoe       | 包含客户端发送的Cookie信息。                            |
| Content-Type                    | application/json; charset=utf-8   | 指定请求体的媒体类型和字符集。                         |
| Content-Length                  | 12345                            | 指定请求体的长度（字节数）。                            |
| Referer                         | http://www.example.com/page1      | 指示请求是从哪个页面链接过来的。                        |
| If-Modified-Since               | Sat, 01 Oct 2023 00:00:00 GMT    | 用于条件GET请求，如果资源未修改，返回304响应。        |
| If-None-Match                   | "etag123"                        | 用于条件GET请求，如果匹配ETag值，返回304响应。        |
| Origin                          | http://www.example.com            | 用于跨域请求的源信息。                                   |
| Accept-Charset                  | utf-8                            | 告诉服务器客户端支持的字符集。                         |
| Cache-Control                   | no-cache, max-age=3600            | 控制缓存行为，例如不缓存或缓存最大时间。              |
| X-Requested-With                | XMLHttpRequest                    | 表示请求是通过Ajax发送的。                              |

参考链接：[https://www.runoob.com/http/http-methods.html](https://www.runoob.com/http/http-methods.html)

## 4.2. 响应头

| 响应头名称                  | 示例值                            | 作用                                              |
|-----------------------------|-----------------------------------|---------------------------------------------------|
| Content-Type                | text/html; charset=utf-8          | 指定响应体的媒体类型和字符集。                   |
| Content-Length              | 12345                             | 指定响应体的长度（字节数）。                    |
| Server                      | Apache/2.4.41 (Unix)              | 揭示服务器软件的信息。                           |
| Date                        | Sat, 23 Oct 2023 14:30:00 GMT     | 指定响应的日期和时间。                           |
| Last-Modified               | Sat, 01 Oct 2023 00:00:00 GMT     | 指示资源的最后修改日期。                         |
| ETag                        | "etag123"                         | 为资源分配的唯一标识，用于条件GET请求。        |
| Expires                     | Sat, 23 Oct 2023 15:30:00 GMT     | 指定响应的过期日期和时间。                      |
| Cache-Control               | no-store, max-age=3600, public    | 控制响应的缓存行为，如不缓存或缓存最大时间。  |
| Location                    | http://www.example.com/new-page    | 重定向响应中指定新的URL。                        |
| Set-Cookie                  | sessionid=xyz; path=/; HttpOnly   | 在客户端上设置Cookie。                           |
| Access-Control-Allow-Origin | *                                 | 允许跨域请求的源。                              |
| Content-Disposition          | attachment; filename="document.pdf" | 指定响应体应以附件方式下载，并指定文件名。 |
| WWW-Authenticate             | Basic realm="Authentication"      | 用于需要身份验证的资源请求。                  |
| X-Frame-Options             | DENY                              | 控制是否允许在iframe中嵌入响应内容。          |

参考链接：[https://www.runoob.com/http/http-header-fields.html](https://www.runoob.com/http/http-header-fields.html)

## 4.3. 状态码

- 状态码分类

| 类别       | 描述                                |
|------------|-----------------------------------|
| 1xx - 信息  | 服务器收到请求，需要进一步操作。    |
| 2xx - 成功  | 请求成功被接受、理解和处理。        |
| 3xx - 重定向 | 需要进一步操作以完成请求。          |
| 4xx - 客户端错误 | 客户端发送无效请求或无权限。      |
| 5xx - 服务器错误 | 服务器未能完成有效请求。          |

- 常见状态码

| 状态码  | 含义                                   |
|---------|----------------------------------------|
| 100     | Continue (继续)                      |
| 101     | Switching Protocols (切换协议)       |
| 200     | OK (请求成功)                         |
| 201     | Created (已创建)                     |
| 204     | No Content (无内容)                  |
| 206     | Partial Content (部分内容)           |
| 300     | Multiple Choices (多种选择)          |
| 301     | Moved Permanently (永久重定向)       |
| 302     | Found (临时重定向)                   |
| 304     | Not Modified (未修改)                |
| 400     | Bad Request (请求错误)               |
| 401     | Unauthorized (未授权)               |
| 403     | Forbidden (禁止访问)                |
| 404     | Not Found (未找到)                   |
| 405     | Method Not Allowed (方法不允许)      |
| 500     | Internal Server Error (服务器错误)  |
| 501     | Not Implemented (未实现)            |
| 502     | Bad Gateway (网关错误)              |
| 503     | Service Unavailable (服务不可用)      |

- 说明：
  - 302 举例：
    - 浏览器请求 `T1Servlet`
    - `T1Servlet` 返回 302 的状态码，并且指定浏览器重定向到 `h1.html`
    - 浏览器发出第二次请求 `hi.html`

  - 304 说明：
    - 当我们请求资源时，服务器会返回该资源的最近修改时间 `Last-Modified: Thu, 13 Jun 2019 08:34:05 GMT` ;
    - 如果浏览器禁用缓存，这个 `Last-Modified` 信息就没有使用，浏览器就每次要求返回该资源；
    - 如果浏览器没有禁用缓存，服务器就会比较时间，如果服务器的资源更新，就会返回该资源，如果发现没有修改，就返回 `304 状态码` （但是不会返回该资源）；

参考链接：[https://www.runoob.com/http/http-status-codes.html](https://www.runoob.com/http/http-status-codes.html)

## 4.4. MIME 类型

- MIME 是 HTTP 协议中数据类型。 MIME 类型的格式时 “大类型/小类型”；

| MIME类型                     | 描述                                         |
|-----------------------------|--------------------------------------------|
| text/plain                  | 纯文本，不包含任何格式化或样式信息。         |
| text/html                   | HTML文档，包含超文本标记语言。                |
| application/json            | JSON数据，常用于数据交换和API通信。          |
| application/xml             | XML数据，常用于数据交换和配置文件。         |
| application/pdf             | Adobe Portable Document Format（PDF）文件。  |
| image/jpeg                 | JPEG图像文件，常用于图片展示。               |
| image/png                  | PNG图像文件，支持透明背景。                |
| audio/mpeg                 | MPEG音频文件，常用于音频流媒体。            |
| video/mp4                  | MPEG-4视频文件，常用于视频流媒体。         |
| application/octet-stream   | 未知文件类型，通常用于二进制文件。        |
| application/zip            | ZIP归档文件，包含多个文件和文件夹。       |
| application/msword         | Microsoft Word文档，二进制格式。           |
| application/vnd.ms-excel   | Microsoft Excel电子表格，二进制格式。     |

参考链接：[https://www.runoob.com/http/mime-types.html](https://www.runoob.com/http/mime-types.html)

## 4.5. GET请求和POST请求分别有哪些？

- GET 请求有哪些：
  - form 标签 method=get 【指定】
  - a 标签
  - link 标签引入 css 【以 GET 方式引入】
  - script 标签引入 js 文件
  - img 标签引入图片
  - iframe 引入 html 页面
  - 在浏览器地址栏中输入地址后敲回车

- POST 请求有哪些：
  - form 标签 method = post