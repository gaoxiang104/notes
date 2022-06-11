# 1. 韩顺平讲 MySQL

- [1. 韩顺平讲 MySQL](#1-韩顺平讲-mysql)
  - [1.1. MySQL安装和配置](#11-mysql安装和配置)
    - [1.1.1. 修改root用户密码](#111-修改root用户密码)
    - [1.1.2. 使用命令行窗口连接 MySQL 数据库](#112-使用命令行窗口连接-mysql-数据库)
  - [1.2. 数据库](#12-数据库)
    - [1.2.1. 三层结构](#121-三层结构)
    - [1.2.2. SQL语句分类](#122-sql语句分类)
    - [1.2.3. 创建数据库](#123-创建数据库)
    - [1.2.4. 查看、删除数据库](#124-查看删除数据库)
    - [1.2.5. 备份恢复数据库](#125-备份恢复数据库)
  - [1.3. 表](#13-表)
    - [1.3.1. 创建](#131-创建)
    - [1.3.2. 删除](#132-删除)
    - [1.3.3. 修改](#133-修改)
  - [1.4. MySQL数据类型](#14-mysql数据类型)
  - [1.5. CRUD](#15-crud)
    - [1.5.1. Insert](#151-insert)
    - [1.5.2. Update](#152-update)
    - [1.5.3. Delete](#153-delete)
    - [1.5.4. Select](#154-select)
      - [1.5.4.1. 单表](#1541-单表)
      - [1.5.4.2. 多表](#1542-多表)
  - [1.6. 函数](#16-函数)
    - [1.6.1. 统计函数](#161-统计函数)
    - [1.6.2. 时间日期](#162-时间日期)
    - [1.6.3. 字符串函数](#163-字符串函数)
    - [1.6.4. 数学函数](#164-数学函数)
    - [1.6.5. 流程控制](#165-流程控制)
  - [1.7. 内连接](#17-内连接)
  - [1.8. 外连接](#18-外连接)
  - [1.9. 约束](#19-约束)
    - [1.9.1. not null](#191-not-null)
    - [1.9.2. primary key](#192-primary-key)
    - [1.9.3. unique](#193-unique)
    - [1.9.4. foreign key](#194-foreign-key)
    - [1.9.5. check](#195-check)
    - [1.9.6. 自增长](#196-自增长)
  - [1.10. 索引](#110-索引)
    - [1.10.1. 唯一索引（UNIQUE）](#1101-唯一索引unique)
    - [1.10.2. 普通索引（INDEXs）](#1102-普通索引indexs)
    - [1.10.3. 全文索引](#1103-全文索引)
  - [1.11. 事物](#111-事物)

## 1.1. MySQL安装和配置

### 1.1.1. 修改root用户密码

Step1： 修改`my.conf`配置文件，开启`skip-grant-table`，重启 MySQL 服务后，可以免密登陆；

Step2： 修改root密码

``` SQL
use mysql;
update user set authentication_string=password('【密码】') where user='root' and Host='localhost';

flush privileges;  -- 刷新权限
```

Step3： 再次修改`my.conf`配置文件，关闭`skip-grant-table`，重启 MySQL 服务；

### 1.1.2. 使用命令行窗口连接 MySQL 数据库

`mysql -h主机名 -P端口 -u用户名 -p密码`

*注意：*

- `-p`后面不能有空格，直接输入`密码`;
- `-h`默认是`localhost`;
- `-P`默认是`3306`;

## 1.2. 数据库

### 1.2.1. 三层结构

客户端 > DBMS > 数据库 > 数据表
 
### 1.2.2. SQL语句分类

- `DDL`：数据定义语句【create 表库】
- `DML`：数据操作语句【新增，修改，删除】
- `DQL`：数据查询语句【select】
- `DCL`：数据控制语句【管理数据库：比如，用户权限 grant(授予) revoke(撤回)】

### 1.2.3. 创建数据库

``` shell
CREATE DATABASE [IF NOT EXISTS] db_name
    [create_specification [,create_specification]...]

create_specification:

  [DEFAULT] CHARACTER SET charset_name
  [DEFAULT] COLLATE collation_name

```

- CHARACTER SET : 指定数据库采用的字符集，如果不指定字符集，默认`utf8`
- COLLATE : 指定数据库字符集的校对规则（常用的 `utf8_bin`[区分大小写] 、`utf8_general_ci`[不区分大小写]。注意默认是`utf8_general_ci`）

*练习：* 创建数据库

``` SQL
-- 创建一个名称为xgo_01的数据库
CREATE DATABASE xgo_01;

-- 创建一个使用utf8字符集的xgo_02数据库
CREATE DATABASE xgo_02 CHARACTER SET utf8;

-- 创建一个使用utf8字符集，并且带校对规则的xgo_03数据库
CREATE DATABASE xgo_03 CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```

***验证`COLLATE[校验规则]`：*** 不同的[collation_name]是如何区分[大小写]的

``` shell
+--------------------+----------------------------+------------------------+
| SCHEMA_NAME        | DEFAULT_CHARACTER_SET_NAME | DEFAULT_COLLATION_NAME |
+--------------------+----------------------------+------------------------+
| xgo_02             | utf8                       | utf8_general_ci        |
| xgo_03             | utf8mb4                    | utf8mb4_bin            |
+--------------------+----------------------------+------------------------+
```

- 现有两个数据库：`xgo_02`和`xgo_03`，两个数据库的`COLLATE`分别是`utf8_general_ci`和`utf8mb4_bin`，在数据库中分别插入一些数据进行测试，脚本如下：

  ``` SQL
  USE xgo_02;
  CREATE TABLE t1 (id int , name varchar(255) );
  INSERT INTO t1 VALUES (1,'tom'),(2,'TOM');

  USE xgo_03;
  CREATE TABLE t1 (id int , name varchar(255) );
  INSERT INTO t1 VALUES (1,'tom'),(2,'TOM');
  ```

- 分别在`xgo_02`和`xgo_03`数据库中，执行查询语句`SELECT * FROM T1 WHERE name = 'tom';`，通过结果集可以看出区别：

  ``` shell
  # xgo_02中执行结果；
  mysql> USE xgo_02;
  Database changed
  mysql> SELECT * FROM T1 WHERE name = 'tom';
  +------+------+
  | id   | name |
  +------+------+
  |    1 | tom  |
  |    2 | TOM  |
  +------+------+
  2 rows in set (0.01 sec)

  # xgo_03中执行结果；
  mysql> USE xgo_03;
  Database changed
  mysql> SELECT * FROM T1 WHERE name = 'tom';
  +------+------+
  | id   | name |
  +------+------+
  |    1 | tom  |
  +------+------+
  1 row in set (0.00 sec)
  ```

### 1.2.4. 查看、删除数据库

- 显示数据库语句：
  
  ``` shell
  mysql> SHOW DATABASES;
  ```

- 显示数据库创建语句：

  ``` shell
  mysql> SHOW CREATE DATABASE db_name;
  ```

- 数据库删除语句：

  ``` shell
  mysql> DROP DATABASE [IF EXISTS] db_name;
  ```

### 1.2.5. 备份恢复数据库

- 备份数据库命令（注意：在DOS下执行）：
  
  ``` shell
  mysqldump -u 用户名 -p -B 数据库1 数据库2 数据库n > 文件名.sql
  ```

- 恢复数据库（注意：进入MySQL命令行再执行）：
  
  ``` shell
  source 文件名.sql
  ```

- 备份库的表
  
  ``` shell
  mysqldump -u用户名 -p密码 数据库 表1 表2 表n > 文件名.sql
  ```

## 1.3. 表

### 1.3.1. 创建

### 1.3.2. 删除

### 1.3.3. 修改

## 1.4. MySQL数据类型

## 1.5. CRUD

### 1.5.1. Insert

### 1.5.2. Update

### 1.5.3. Delete

### 1.5.4. Select

#### 1.5.4.1. 单表

#### 1.5.4.2. 多表

## 1.6. 函数

### 1.6.1. 统计函数

### 1.6.2. 时间日期

### 1.6.3. 字符串函数

### 1.6.4. 数学函数

### 1.6.5. 流程控制

## 1.7. 内连接

## 1.8. 外连接

## 1.9. 约束

### 1.9.1. not null

### 1.9.2. primary key

### 1.9.3. unique

### 1.9.4. foreign key

### 1.9.5. check

### 1.9.6. 自增长

## 1.10. 索引

### 1.10.1. 唯一索引（UNIQUE）

### 1.10.2. 普通索引（INDEXs）

### 1.10.3. 全文索引

## 1.11. 事物
