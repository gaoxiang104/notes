# 1. docker 基础使用

- [1. docker 基础使用](#1-docker-基础使用)
  - [1.1. docker 常用命令](#11-docker-常用命令)
  - [1.2. docker-compose 使用](#12-docker-compose-使用)
    - [1.2.1. docker-compose 常用命令](#121-docker-compose-常用命令)
    - [1.2.2. docker-compose 使用案例](#122-docker-compose-使用案例)


## 1.1. docker 常用命令

| 命令                                                      | 解释                                             | 命令案例                                        |
| --------------------------------------------------------- | ------------------------------------------------ | ----------------------------------------------- |
| docker --version                                          | 查看 Docker 版本                                 |                                                 |
| docker search <镜像名称>                                  | 在 Docker Hub 中搜索镜像                         | 注意只能在docker hub 上搜索，国内镜像源无非搜索 |
| docker pull <image>                                       | 拉取远程镜像                                     | docker pull hello-world                         |
| docker images                                             | 列出本地所有镜像                                 |                                                 |
| docker rmi <image>                                        | 删除本地镜像                                     | docker rmi hello-world                          |
| docker run <image>                                        | 基于指定镜像创建并启动容器                       | docker run hello-world                          |
| docker run -d -p <host_port>:<container_port> <image>     | 启动容器并映射端口                               | docker run -d -p 8080:80 nginx                  |
| docker ps                                                 | 列出正在运行的容器                               | docker ps                                       |
| docker ps -a                                              | 列出所有容器（包括停止的容器）                   | docker ps -a                                    |
| docker exec -it <container_id> <command>                  | 在运行中的容器内执行命令                         | docker exec -it my-container bash               |
| docker stop <container_id>                                | 停止运行中的容器                                 | docker stop my-container                        |
| docker start <container_id>                               | 启动已停止的容器                                 | docker start my-container                       |
| docker restart <container_id>                             | 重启一个容器                                     | docker restart my-container                     |
| docker rm <container_id>                                  | 删除已停止的容器                                 | docker rm my-container                          |
| docker logs <container_id>                                | 查看容器日志                                     | docker logs my-container                        |
| docker network ls                                         | 列出所有 Docker 网络                             | docker network ls                               |
| docker volume ls                                          | 列出所有 Docker 数据卷                           | docker volume ls                                |
| docker info                                               | 显示 Docker 的详细信息（如容器数量、镜像数量等） | docker info                                     |
| docker cp <container_id>:<source_path> <destination_path> | 从容器拷贝文件到宿主机                           | docker cp my-container:/usr/src/app /tmp/app    |
| docker cp <source_path> <container_id>:<destination_path> | 从宿主机拷贝文件到容器                           | docker cp /tmp/app my-container:/usr/src/app    |

## 1.2. docker-compose 使用

### 1.2.1. docker-compose 常用命令

| 命令                                    | 解释                                                                   | 命令案例                     |
| --------------------------------------- | ---------------------------------------------------------------------- | ---------------------------- |
| docker-compose up                       | 启动 Docker Compose 服务，并根据 docker-compose.yml 文件创建和启动容器 | docker compose up -d         |
| docker-compose down                     | 停止并删除由 docker-compose 创建的容器、网络等资源                     | docker compose down          |
| docker-compose build                    | 根据 docker-compose.yml 构建镜像                                       | docker compose build         |
| docker-compose exec <service> <command> | 在指定服务的容器内执行命令                                             | docker compose exec web bash |
| docker-compose logs                     | 查看 Docker Compose 容器的日志                                         | docker compose logs          |

### 1.2.2. docker-compose 使用案例

- 使用 docker-compose 配置 NGINX，目录结构如下：

    ``` bash
    myDocker
    ├── docker-compose.yml
    └── nginx
        ├── conf.d
        │   └── default.conf
        ├── html
        │   ├── 404.html
        │   └── index.html
        └── nginx.conf
    ```

- docker-compose.yml 示例

    ``` yml
    version: '3.8'

    services:
    nginx:
        image: nginx:1.27.5
        container_name: my_nginx
        ports:
        - "80:80"
        volumes:
        - ./nginx/nginx.conf:/etc/nginx/nginx.conf:ro
        - ./nginx/conf.d:/etc/nginx/conf.d:ro
        - ./nginx/html:/usr/share/nginx/html:ro
        restart: always%  
    ```

- 启动运行

    ``` bash
    docker compose up -d
    ```