# 1. V2R@y配置

- [1. V2R@y配置](#1-v2ry配置)
  - [1.1. 安装前时间校准](#11-安装前时间校准)
    - [1.1.1. 更新系统时区](#111-更新系统时区)
  - [1.2. 安装](#12-安装)
  - [1.3. 安装后的目录](#13-安装后的目录)
  - [1.4. 服务端配置](#14-服务端配置)
  - [1.5. 服务器需要开放端口](#15-服务器需要开放端口)
  - [1.6. 服务端 启动/停止/查看状态](#16-服务端-启动停止查看状态)
    - [1.6.1. 启动](#161-启动)
    - [1.6.2. 设置开机自启动](#162-设置开机自启动)
    - [1.6.3. 停止](#163-停止)
    - [1.6.4. 重启](#164-重启)
    - [1.6.5. 查看状态](#165-查看状态)
  - [1.7. 客户端配置](#17-客户端配置)
  - [2. v2r@y配置Cloudflare WARP解锁ChatGPT](#2-v2ry配置cloudflare-warp解锁chatgpt)
    - [2.1. 安装CloudFlare WARP](#21-安装cloudflare-warp)
    - [2.1.1. 安装仓库 GPG key](#211-安装仓库-gpg-key)
    - [2.1.2. 添加CloudFlare WARP客户端源](#212-添加cloudflare-warp客户端源)
    - [2.1.3. 更新源](#213-更新源)
    - [2.1.4. 安装CloudFlare WARP客户端](#214-安装cloudflare-warp客户端)
      - [2.1.4.1. 安装](#2141-安装)
      - [2.1.4.2. 查看状态](#2142-查看状态)
      - [2.1.4.3. 注册客户端](#2143-注册客户端)
      - [2.1.4.4. 设置 WARP 为代理模式(很重要，否则您将无法远程连接 VPS)](#2144-设置-warp-为代理模式很重要否则您将无法远程连接-vps)
      - [2.1.4.5. 启动连接](#2145-启动连接)
      - [2.1.4.6. 查看设置](#2146-查看设置)
      - [2.1.4.7. 进行测试](#2147-进行测试)
      - [2.1.4.8. 查看连接是否成功](#2148-查看连接是否成功)
  - [2.2. 修改v2R@y 服务端配置](#22-修改v2ry-服务端配置)


## 1.1. 安装前时间校准

检查时区，输出结果中的 -0500 代表的是时区为西 5 区，需转换成东 8 区

``` shell
# date -R
Sun, 22 Jan 2017 10:10:36 -0500
```

### 1.1.1. 更新系统时区

系统是`Ubuntu`。

设置时区命令:

``` shell
# timedatectl set-timezone 'Asia/Shanghai' 

# timedatectl
               Local time: Tue 2021-10-19 15:45:42 CST
           Universal time: Tue 2021-10-19 07:45:42 UTC
                 RTC time: Tue 2021-10-19 07:45:42
                Time zone: Asia/Shanghai (CST, +0800)
System clock synchronized: yes
              NTP service: active
          RTC in local TZ: no
```

## 1.2. 安装

参考[官网](https://www.v2ray.com/)

参考[安装脚本文档](https://github.com/v2fly/fhs-install-v2ray/blob/master/README.zh-Hans-CN.md)

``` shell

// 安装可执行文件和 .dat 数据文件
# bash <(curl -L https://raw.githubusercontent.com/v2fly/fhs-install-v2ray/master/install-release.sh)

// 只更新 .dat 数据文件
# bash <(curl -L https://raw.githubusercontent.com/v2fly/fhs-install-v2ray/master/install-dat-release.sh)

// 移除 V2Ray
# bash <(curl -L https://raw.githubusercontent.com/v2fly/fhs-install-v2ray/master/install-release.sh) --remove

```

## 1.3. 安装后的目录

``` shell
installed: /usr/local/bin/v2ray
installed: /usr/local/bin/v2ctl
installed: /usr/local/share/v2ray/geoip.dat
installed: /usr/local/share/v2ray/geosite.dat
installed: /usr/local/etc/v2ray/config.json
installed: /var/log/v2ray/
installed: /var/log/v2ray/access.log
installed: /var/log/v2ray/error.log
installed: /etc/systemd/system/v2ray.service
installed: /etc/systemd/system/v2ray@.service
```

## 1.4. 服务端配置

从安装日志中找到`config`位置：`/usr/local/etc/v2ray/config.json`

[参考教程](https://github.com/v2fly/v2ray-examples)

简单配置：

``` json
{
  "inbounds": [
    {
      "port": 16823, // 服务器监听端口
      "protocol": "vmess",    // 主传入协议
      "settings": {
        "clients": [
          {
            "id": "768ba7ed-1422-46e5-8bec-8694d5c04e09",  // 用户 ID，客户端与服务器必须相同，一个uuid
            "alterId": 64
          }
        ]
      }
    }
  ],
  "outbounds": [
    {
      "protocol": "freedom",  // 主传出协议
      "settings": {}
    }
  ]
}
```

> 注意：上面配置中出现的`//`注释，需要删除，因为标准json中不能出现此符号，需要完全按照json格式标准。

## 1.5. 服务器需要开放端口

上面配置的服务端端口是：`16823`; 以`Ubuntu`系统为例，开放端口如下：

- 查看防火墙状态`sudo ufw status`,也可以看到开放的端口

``` shell
root# ufw status
Status: active

To                         Action      From
--                         ------      ----
22/tcp                     ALLOW       Anywhere
```

- 添加端口 `sudo ufw allow [端口]`

``` shell
root# sudo ufw allow 16823
```

- 删除端口 `sudo ufw delete allow [端口]`

## 1.6. 服务端 启动/停止/查看状态

### 1.6.1. 启动

``` shell
systemctl start v2ray
```

### 1.6.2. 设置开机自启动

``` shell
systemctl enable v2ray
```

### 1.6.3. 停止

``` shell
systemctl stop v2ray
```

### 1.6.4. 重启

``` shell
systemctl restart v2ray
```

### 1.6.5. 查看状态

``` shell
systemctl status v2ray
```

## 1.7. 客户端配置

``` JSON
{
  "inbounds": [
    {
      "port": 1080, // 监听端口
      "protocol": "socks", // 入口协议为 SOCKS 5
      "sniffing": {
        "enabled": true,
        "destOverride": ["http", "tls"]
      },
      "settings": {
        "auth": "noauth"  //socks的认证设置，noauth 代表不认证，由于 socks 通常在客户端使用，所以这里不认证
      }
    }
  ],
  "outbounds": [
    {
      "protocol": "vmess", // 出口协议
      "settings": {
        "vnext": [
          {
            "address": "serveraddr.com", // 服务器地址，请修改为你自己的服务器 IP 或域名
            "port": 16823,  // 服务器端口
            "users": [
              {
                "id": "b831381d-6324-4d53-ad4f-8cda48b30811",  // 用户 ID，必须与服务器端配置相同
                "alterId": 0 // 此处的值也应当与服务器相同
              }
            ]
          }
        ]
      }
    }
  ]
}
```

> 注意：上面配置中出现的`//`注释，需要删除，因为标准json中不能出现此符号，需要完全按照json格式标准。

---

---

---

## 2. v2r@y配置Cloudflare WARP解锁ChatGPT

### 2.1. 安装CloudFlare WARP

### 2.1.1. 安装仓库 GPG key

``` shell
curl https://pkg.cloudflareclient.com/pubkey.gpg | gpg --yes --dearmor --output /usr/share/keyrings/cloudflare-warp-archive-keyring.gpg
```

### 2.1.2. 添加CloudFlare WARP客户端源

``` shell
echo 'deb [arch=amd64 signed-by=/usr/share/keyrings/cloudflare-warp-archive-keyring.gpg] https://pkg.cloudflareclient.com/ bullseye main' | tee /etc/apt/sources.list.d/cloudflare-client.list
```

### 2.1.3. 更新源

``` shell
apt update
```

### 2.1.4. 安装CloudFlare WARP客户端

#### 2.1.4.1. 安装

``` shell
apt -y install cloudflare-warp
```

#### 2.1.4.2. 查看状态

``` shell
systemctl status warp-svc
```

#### 2.1.4.3. 注册客户端

``` shell
warp-cli register
```

#### 2.1.4.4. 设置 WARP 为代理模式(很重要，否则您将无法远程连接 VPS)

``` shell
warp-cli set-mode proxy
```

#### 2.1.4.5. 启动连接

WARP将启动socks5本机代理127.0.0.1:40000。

``` shell
warp-cli connect
```

#### 2.1.4.6. 查看设置

``` shell
warp-cli settings
```

#### 2.1.4.7. 进行测试

没有任何输出就说明成功了

``` shell
curl chat.openai.com --proxy socks5://127.0.0.1:40000
```

#### 2.1.4.8. 查看连接是否成功

没有任何输出就说明成功了

``` shell
warp-cli warp-stats
```

可以看到last handshake时间

``` shell
# warp-cli warp-stats
Endpoints: 162.159.192.10, ::
Time since last handshake: 18s
Sent: 362.8kB; Received: 1.0MB
Estimated latency: 136ms
Estimated loss: 0.00%;
```

## 2.2. 修改v2R@y 服务端配置

``` json
{
  // ...
  "outbounds": [
    // ....
    {
      "tag": "chatGPT_proxy",
      "protocol": "socks",
      "settings": {
        "servers": [
          {
            "address": "127.0.0.1",
            "port": 40000
          }
        ]
      }
    },
    // ....
  ],
   "routing":{  
        "domainStrategy":"IPOnDemand",  
        "rules":[  
            // ...
            // ...
            {  
                "type":"field",  
                "outboundTag":"chatgpt_proxy",  
                "domain":[  
                    "openai.com"
                ],  
                "enabled":true  
            }
        ]
   }
}

```