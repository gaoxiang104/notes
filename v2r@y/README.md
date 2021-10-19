# 1. V2R@y配置

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

## 1.4. 配置

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
