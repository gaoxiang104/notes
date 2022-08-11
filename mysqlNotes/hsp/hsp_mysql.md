# 1. 韩顺平讲 MySQL

- [1. 韩顺平讲 MySQL](#1-韩顺平讲-mysql)
  - [1.1. MySQL安装和配置](#11-mysql安装和配置)
    - [1.1.1. 修改root用户密码](#111-修改root用户密码)
    - [1.1.2. 使用命令行窗口连接 MySQL 数据库](#112-使用命令行窗口连接-mysql-数据库)
    - [1.1.3. mysql 参考手册地址](#113-mysql-参考手册地址)
  - [1.2. 数据库](#12-数据库)
    - [1.2.1. 三层结构](#121-三层结构)
    - [1.2.2. SQL语句分类](#122-sql语句分类)
    - [1.2.3. 创建数据库](#123-创建数据库)
    - [1.2.4. 查看、删除数据库](#124-查看删除数据库)
    - [1.2.5. 备份恢复数据库](#125-备份恢复数据库)
  - [1.3. 表](#13-表)
    - [1.3.1. 创建表](#131-创建表)
      - [1.3.1.1. 使用LIKE进行表的创建](#1311-使用like进行表的创建)
    - [1.3.2. 删除表](#132-删除表)
    - [1.3.3. 修改表](#133-修改表)
    - [1.3.4. 查看表](#134-查看表)
    - [1.3.5. 表复制](#135-表复制)
  - [1.4. MySQL数据类型](#14-mysql数据类型)
    - [1.4.1. 整数类型](#141-整数类型)
    - [1.4.2. 浮点类型](#142-浮点类型)
    - [1.4.3. 文本类型、二进制类型](#143-文本类型二进制类型)
    - [1.4.4. 日期](#144-日期)
  - [1.5. CRUD](#15-crud)
    - [1.5.1. Insert](#151-insert)
    - [1.5.2. Update](#152-update)
    - [1.5.3. Delete](#153-delete)
      - [1.5.3.1. 清空表中的数据 TRUNCATE](#1531-清空表中的数据-truncate)
      - [1.5.3.2. 删除表中的重复记录](#1532-删除表中的重复记录)
    - [1.5.4. Select](#154-select)
      - [1.5.4.1. SELECT 查询](#1541-select-查询)
      - [1.5.4.2. WHERE 子句](#1542-where-子句)
        - [1.5.4.2.1. LIKE 使用](#15421-like-使用)
        - [1.5.4.2.2. IS NULL 和 IS NOT NULL](#15422-is-null-和-is-not-null)
      - [1.5.4.3. order by 子句](#1543-order-by-子句)
      - [1.5.4.4. GROUP BY 子句](#1544-group-by-子句)
      - [1.5.4.5. 分页查询](#1545-分页查询)
      - [1.5.4.6. 多子句查询](#1546-多子句查询)
  - [1.6. 函数](#16-函数)
    - [1.6.1. 统计/合计函数](#161-统计合计函数)
      - [1.6.1.1. 统计函数 - COUNT](#1611-统计函数---count)
        - [1.6.1.1.1. COUNT(*) 和 COUNT(列) 的区别](#16111-count-和-count列-的区别)
      - [1.6.1.2. 合计函数 - SUM](#1612-合计函数---sum)
      - [1.6.1.3. 合计函数 - AVG](#1613-合计函数---avg)
      - [1.6.1.4. 合计函数 - MAX / MIN](#1614-合计函数---max--min)
    - [1.6.2. 字符串函数](#162-字符串函数)
    - [1.6.3. 数学函数](#163-数学函数)
    - [1.6.4. 时间日期](#164-时间日期)
    - [1.6.5. 系统函数和加密](#165-系统函数和加密)
    - [1.6.6. 流程控制](#166-流程控制)
  - [1.7. 多表查询](#17-多表查询)
    - [1.7.1. 笛卡尔集](#171-笛卡尔集)
    - [1.7.2. 多表查询案例](#172-多表查询案例)
    - [1.7.3. 自连接](#173-自连接)
    - [1.7.4. 子查询](#174-子查询)
      - [1.7.4.1. 临时表](#1741-临时表)
      - [1.7.4.2. all操作符 和 any操作符](#1742-all操作符-和-any操作符)
      - [1.7.4.3. 多列子查询](#1743-多列子查询)
      - [1.7.4.4. 子查询练习](#1744-子查询练习)
    - [1.7.5. 合并查询](#175-合并查询)
    - [1.7.6. 外连接](#176-外连接)
    - [1.7.7. 内连接](#177-内连接)
  - [1.8. 约束](#18-约束)
    - [1.8.1. primary key（主键）](#181-primary-key主键)
      - [1.8.1.1. 新增/删除/修改 主键](#1811-新增删除修改-主键)
    - [1.8.2. not null (非空)](#182-not-null-非空)
    - [1.8.3. unique （唯一）](#183-unique-唯一)
    - [1.8.4. foreign key (外键)](#184-foreign-key-外键)
    - [1.8.5. check](#185-check)
    - [1.8.6. 约束相关练习](#186-约束相关练习)
    - [1.8.7. 自增长 auto_increment](#187-自增长-auto_increment)
      - [1.8.7.1. 修改自增长开始值](#1871-修改自增长开始值)
  - [1.9. 索引](#19-索引)
    - [1.9.1. 唯一索引（UNIQUE）](#191-唯一索引unique)
    - [1.9.2. 普通索引（INDEXs）](#192-普通索引indexs)
    - [1.9.3. 全文索引](#193-全文索引)
  - [1.10. 事物](#110-事物)

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

### 1.1.3. mysql 参考手册地址

[mysql5.7 参考手册地址:  https://dev.mysql.com/doc/refman/5.7/en/](https://dev.mysql.com/doc/refman/5.7/en/)

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

> *练习：* 创建数据库

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

- 显示当前所在数据库：
  
  ``` shell
  mysql> SELECT database();
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

### 1.3.1. 创建表

*建表语句：*

``` sql
CREATE TABLE table_name
(
  field1 datatype,
  field2 datatype,
  field3 datatype
) CHARACTER SET 字符集 COLLATE 校对规则 ENGINE 引擎 ;
```

- `field`：指列名；
- `datatype`：指列类型（字段类型）；
- `character set`：字符集，如果不指定则为所在数据库字符集；
- `collate`：校对规则，如果不指定则为所在数据库校对规则；
- `engine`：引擎；

> *练习1：* 在数据库`xgo_02`创建表`user`

``` sql
CREATE TABLE `user`
(
  `id` int,
  `name` varchar(255),
  `password` varchar(255),
  `birthday` date
) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```

> *练习2：* 创建一个员工表emp，选用适当的数据类型

| 字段       | 属性   | 说明     |
| ---------- | ------ | -------- |
| id         | 整形   |          |
| name       | 字符型 |          |
| sex        | 字符型 |          |
| birthday   | date   |          |
| entry_date | date   | 入职时间 |
| job        | 字符型 | 职位     |
| salary     | 小数型 | 薪资     |
| resume     | 文本   | 简历     |

> *练习2 - 解答：*

``` sql
CREATE TABLE emp (
  id INT,
  `name` VARCHAR(100),
  sex CHAR(1),
  birthday DATE,
  entry_date DATETIME COMMENT '入职时间',
  job VARCHAR(255) COMMENT '职位',
  salary DECIMAL(9,2) COMMENT '薪资',
  `resume` TEXT COMMENT '简历'
) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

INSERT INTO `emp` VALUES (1,'小妖怪','男','2000-11-11','2010-11-10 11:11:11','巡山的','3000.88','大王叫我来巡山');
```

#### 1.3.1.1. 使用LIKE进行表的创建

``` sql
CREATE TABLE my_tab02 LIKE emp;
```

### 1.3.2. 删除表

``` sql
DROP table_name;
```

### 1.3.3. 修改表

使用`ALTER TABLE`语句追加，修改，或删除列的语法。

- 添加列
  
  ``` sql
  ALTER TABLE table_name
  ADD (column datatype [DEFAULT expr]
    [,column datatype] ... );
  ```

- 修改列

  ``` sql
  ALTER TABLE table_name
  MODIFY (column datatype [DEFAULT expr]
    [,column datatype] ... );
  ```

- 删除列

  ``` sql
  ALTER TABLE table_name
  DROP (column);
  ```

- 修改表名

  ``` sql
  RENAME TABLE old_table_name TO new_table_name;
  ```

- 修改列名

  ``` sql
  ALTER TABLE table_name CHANGE old_column_name new_column_name datatype;
  ```

- 修改表字符集

  ``` sql
  ALTER TABLE table_name CHARACTER SET 字符集;
  --
  -- 注意，修改字符集后，新增的column使用新字符集；但是，原本column的字符集不会改变；
  ```

> *练习：*
>
> - 员工表`emp`中新增一个image列，varchar类型（在resume后面）；
> - 修改job列，使其长度为60；
> - 删除sex列；
> - 表名改为employee;
> - 修改表的字符集为utf8;
> - 列明name修改为user_name;
> 
> *练习 - 解答：*

``` sql

ALTER TABLE `emp` ADD `image` VARCHAR(255) AFTER `resume`;
ALTER TABLE `emp` MODIFY `job` VARCHAR(60);
ALTER TABLE `emp` DROP `sex`;
RENAME TABLE `emp` TO `employee`;
ALTER TABLE `employee` CHARACTER SET utf8 COLLATE utf8_bin;
ALTER TABLE `employee` CHANGE `name` `user_name` VARCHAR(50);
```

### 1.3.4. 查看表

- 查看表结构

  ``` sql
  DESC table_name;
  ```

- 查看表结构，包含comment

  ``` sql
  SHOW FULL COLUMNS FROM 表名;
  ```

- 查看完整信息
  
  ``` sql
  select * from information_schema.COLUMNS where table_name = '表名' and table_schema = '数据库名称';
  ```

### 1.3.5. 表复制

- 自我复制数据（蠕虫复制）
  - 有时，为了对某个sql语句进行效率测试，我们需要海量数据时，可以使用此方法为表创建海量数据。

> *练习 - 解答：*

``` sql
-- 为了对某个sql语句进行效率测试，我们需要海量数据时，可以使用此方法为表创建海量数据。

-- 创建表
CREATE TABLE my_tab01(
  id INT,
  `name` VARCHAR(32),
  sal DECIMAL(7,2),
  job VARCHAR(32),
  dept_no INT
);

-- 演示如何自我复制
-- 1，先把emp 表的记录复制到 my_tab01;
INSERT INTO my_tab01 (id, `name`, sal, job, dept_no)  
  SELECT e.emp_no, e.emp_name, e.sal, e.job, e.dept_no FROM emp e;
-- 2, 自我复制
INSERT INTO my_tab01 SELECT * FROM my_tab01;

SELECT COUNT(*) FROM my_tab01;
```

## 1.4. MySQL数据类型

### 1.4.1. 整数类型

| 数据类型                | 说明                                                                  | 备注                  |
| ----------------------- | --------------------------------------------------------------------- | --------------------- |
| TINYINT [UNSIGNED]      | 占1个字节。带符号的范围是-128到127，无符号0到255。默认是有符号        | 常用，表示boolean类型 |
| SMALLINT [UNSIGNED]     | 占2个字节。带符号的范围是-2^15到2^15-1，无符号0到2^16-1。默认是有符号 |
| MEDIUMINTINT [UNSIGNED] | 占3个字节。带符号的范围是-2^23到2^23-1，无符号0到2^24-1。默认是有符号 |
| INT [UNSIGNED]          | 占4个字节。带符号的范围是-2^31到2^31-1，无符号0到2^32-1。默认是有符号 | 常用                  |
| BIG [UNSIGNED]          | 占8个字节。带符号的范围是-2^63到2^63-1，无符号0到2^64-1。默认是有符号 | 常用，表示long 类型   |

### 1.4.2. 浮点类型

| 数据类型                | 说明                                                                                    | 备注 |
| ----------------------- | --------------------------------------------------------------------------------------- | ---- |
| FLOAT [UNSIGNED]        | 占4个字节。                                                                             |      |
| DOUBLE [UNSIGNED]       | 占8个字节，表示比 float 精度更大的小数                                                  |      |
| DECIMAL(M,D) [UNSIGNED] | 定点数M指定小数位的总长度，D表示小数点后面的位数；M最大65，默认是10；D最大30，默认是0； |      |

### 1.4.3. 文本类型、二进制类型

| 数据类型      | 说明                                               | 备注                                                                                                                 |
| ------------- | -------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| CHAR(size)    | 固定长度字符串，最大255个[字符]                    |                                                                                                                      |
| VARCHAR(size) | 可变长字符串，长度范围是0到2^16-1（65525）个[字节] | utf8编码最大21844个字符，utf8有1-3个字节用于记录大小，所以 size = (65535 - 3) / 3 = 21844个字符。utf8一个字符占3字节 |
| TEXT          | 文本，长度范围是0到2^16-1                          |                                                                                                                      |
| LONGTEXT      | 文本，长度范围是0到2^32                            |                                                                                                                      |
| BLOB          | 二进制数据，长度范围是0到2^16-1                    |                                                                                                                      |
| LONGBLOB      | 二进制数据，长度范围是0到2^32-1                    |                                                                                                                      |

- 字符串使用细节：
  
  - 细节1:
    - char(4) // 这个4表示字符数（最大255），不是字节，不管是中文还是字母都是放四个，按字符计算。
    - varchar(4) // 这个4表示也字符，但是这个字符占用多少字节是根据`字符编码`计算的，比如：utf8、gbk、big5 他们所占用字节数不同。
    - 不管是中文还是英文字母，都是最多存放4个，是按照字符存放的。
  - 细节2
    - char(4) 是定长（固定的大小），就是说，即使你 插入'ab'，也会占用分配的4个字符。
    - varchar(4) 是变长，就是说，如果插入了'ab'，实际占用空间大小并不是4个字符，而是按照实际占用空间来分配。
  - 细节3：什么时候使用char，什么时候使用varchar
    - 如果数据是定长，推荐使用char，比如：md5的密码，邮编，手机号，身份证号等。
    - 如果一个字的都长度是不确定的，我们使用varchar，比如留言，文章
    - 查询速度：char > varchar
  - 细节4
    - 在存放文本时，也可以使用Text数据类型，可以将Text列是为varchar列，注意text不能有默认值，大小0-2^16字节；
    - 如果希望存放更多字符，可以选择MEDIUMTEXT 0-2^24 或者 LONGTEXT 0-2^32;

### 1.4.4. 日期

| 数据类型  | 说明                                                                                | 备注 |
| --------- | ----------------------------------------------------------------------------------- | ---- |
| YEAR      | 年类型；范围：YYYY（1901/2155）                                                     |      |
| DATE      | 日期类型；范围：YYYY-MM-DD（1000-01-01/9999-12-31）                                 |      |
| TIME      | 时间类型；范围：HH:MM:SS（'-838:59:59'/'838:59:59'）                                |      |
| DATETIME  | 日期时间；范围：YYYY-MM-DD HH:MM:SS（1000-01-01 00:00:00/9999-12-31 23:59:59    Y） |      |
| TIMESTAMP | 时间戳；范围：YYYYMMDD HHMMSS（1970-01-01 00:00:00/2037 年某时）                    |      |

> ***datetime与timestamp的区别***
>
> 在实际应用的很多场景中，MySQL的这两种日期类型都能够满足我们的需要，存储精度都为秒，但在某些情况下，会展现出他们各自的优劣。
> 下面就来总结一下两种日期类型的区别。
>
> 1.DATETIME的日期范围是1001——9999年，TIMESTAMP的时间范围是1970——2038年。
>
> 2.DATETIME存储时间与时区无关，TIMESTAMP存储时间与时区有关，显示的值也依赖于时区。在mysql服务器，
操作系统以及客户端连接都有时区的设置。
>
> 3.DATETIME使用8字节的存储空间，TIMESTAMP的存储空间为4字节。因此，TIMESTAMP比DATETIME的空间利用率更高。
>
> 4.DATETIME的默认值为null；TIMESTAMP的字段默认不为空（not null）,默认值为当前时间（CURRENT_TIMESTAMP），
>
> 如果不做特殊处理，并且update语句中没有指定该列的更新值，则默认更新为当前时间。

## 1.5. CRUD

### 1.5.1. Insert

``` sql
INSERT INTO table_name [(column [, column ... ])]
VALUES (value [, value ... ]);
```

- 细节说明：

  - 插入的数据应与字段的数据类型相同；
  - 数据的长度应在列的规定范围内；
  - 在`values`中列出的数据位置必须与被加入的列的排列位置相对于；
  - 列可以插入空值【前提是该字段允许为空】;
  - `INSERT INTO table_name (column...) VALUES (),(),()...` 形式添加多条记录；
  - 如果是给表中的所有字段添加数据，可以不写前面的字段名称；
  - 默认值的使用，当不给某个字段值时，如果有默认值就会添加，否则报错。

> *练习：*
>
> - 创建一张商品表(id int , goods_name varchar(64), price decimal) ;
> - 添加2条记录
>
> *练习 - 解答：*

``` sql
CREATE TABLE `goods` (
  `id` INT(11),
  `goods_name` VARCHAR(64),
  `price` DECIMAL(8,2)
);

INSERT INTO `goods` (`id`, `goods_name`, `price`)
VALUES 
  (1, '华为手机', 5999.99),
  (2, '苹果手机', 9999.99);
```

### 1.5.2. Update

``` sql
UPDATE table_name 
  SET column_name_1 = expr_1 [, column_name_2 = expr_2 ... ] 
  [ WHERE where_definition ] ;
```

- 细节说明：

  - UPDATE 语法可以用新值更新原有表行中的各列;
  - SET 子句指要修改哪些列和要给予哪些值;
  - WHERE 子句指定应更新哪些行。如没有 WHERE 子句，则更新所有的行（记录），因此要小心；
  - 如果需要修改多个字段，可以通过 SET 字段1=值1,字段2=值2 ...

> *练习：*

``` SQL
-- 在创建的employee表中进行记录修改
-- 1，将所有员工薪水修改为5000元。【如果没带where 条件，会修改所有的记录，因此要小心】
UPDATE `employee` SET `salary` = 5000;
-- 2，将姓名为 小妖怪 的员工薪水修改为 3000元；
UPDATE `employee` SET `salary` = 3000 WHERE `user_name`='小妖怪';
-- 3，将 老妖怪 的薪水在原有基础上增加1000元；
INSERT INTO `employee` VALUES (2,'老妖怪','1990-01-01','2000-10-10 10:10:10','捶背的',5000,'给大王捶背的',NULL);

UPDATE `employee` SET `salary` = `salary`+1000 WHERE `user_name`='老妖怪';

SELECT * FROM `employee`;
```

### 1.5.3. Delete

``` sql
DELETE FROM table_name [WHERE where_definition];
```

- 细节说明：

  - 如果不使用where子句，将删除表中所有数据。

> *练习：*

``` SQL
-- 删除表中名称为'老妖怪'的记录。
DELETE FROM `employee` WHERE `user_name`='老妖怪';
-- 删除表中所有记录。
DELETE FROM `employee`;
```

#### 1.5.3.1. 清空表中的数据 TRUNCATE

``` SQL
TRUNCATE [table_name]
```

#### 1.5.3.2. 删除表中的重复记录

> *练习：*

``` SQL
-- 创建一张表 my_tab02;
DROP TABLE IF EXISTS my_tab02;
CREATE TABLE my_tab02 LIKE emp;
-- 插入两次emp数据进my_tab02
INSERT INTO my_tab02 SELECT * FROM emp;
INSERT INTO my_tab02 SELECT * FROM emp;

-- 删除重复记录，思路：
/*
  （1）创建一张临时表 my_tmp, 该表的结构和 my_tab02一样
  （2）把my_tab02 的记录 通过 district 关键字处理后的记录复制到 my_tmp
  （3）清除掉my_tab02 记录
  （4）把 my_tmp 表的记录复制到 my_tab02
  （5）drop 掉 临时表my_tmp
*/
CREATE TABLE my_tmp LIKE my_tab02;
INSERT INTO my_tmp SELECT DISTINCT * FROM my_tab02;
TRUNCATE my_tab02;
INSERT INTO my_tab02 SELECT * FROM my_tmp;
DROP TABLE my_tmp;
SELECT * FROM my_tab02;
```

### 1.5.4. Select

> *用于查询练习的表和数据：*

``` SQL
DROP TABLE IF EXISTS `dept` ;
CREATE TABLE `dept` (
  dept_no INT UNSIGNED NOT NULL COMMENT '部门编号',
  dept_name VARCHAR(64) NOT NULL COMMENT '部门编号',
  loc VARCHAR(64) NOT NULL COMMENT '位置'
) COMMENT '部门表';

INSERT INTO `dept` VALUES 
  (10,'ACCOUNTING','NEW YORK'),
  (20,'RESEARCH','DALLAS'),
  (30,'SALES','CHICAGO'),
  (40,'OPERATIONS','BOSTON');

DROP TABLE IF EXISTS `emp` ;
CREATE TABLE `emp` (
  emp_no INT UNSIGNED NOT NULL COMMENT '编号',
  emp_name VARCHAR(64) NOT NULL COMMENT '名字',
  job VARCHAR(64) NOT NULL COMMENT '工作',
  mgr INT UNSIGNED COMMENT '上级编号',
  hire_date DATE NOT NULL COMMENT '入职时间',
  sal DECIMAL(7,2) NOT NULL COMMENT '薪水',
  comm DECIMAL(7,2) COMMENT '红利',
  dept_no INT UNSIGNED NOT NULL COMMENT '部门编号'
) COMMENT '员工表';

INSERT INTO `emp` VALUES 
  (7369,'SMITH','CLERK',7902,'1990-12-17',800,NULL,20),
  (7499,'ALLEN','SALESMAN',7698,'1991-2-20',1600,300,30),
  (7521,'WARD','SALESMAN',7698,'1991-2-22',1250,500,30),
  (7566,'JONES','MANGER',7839,'1991-4-2',2975,NULL,20),
  (7654,'MARTIN','SALESMAN',7698,'1991-9-28',1250,1400,30),
  (7698,'BLAKE','MANAGER',7839,'1991-5-1',2850,NULL,30),
  (7782,'CLARK','MANAGER',7839,'1991-6-9',2450,NULL,10),
  (7788,'SCOTT','ANALYST',7566,'1997-4-19',3000,NULL,20),
  (7839,'KING','PRESIDENT',NULL,'1991-11-17',5000,NULL,16),
  (7844,'TURNER','SALESMAN',7698,'1991-9-8',1500,NULL,30),
  (7900,'JAMES','CLERK',7698,'1991-12-3',950,NULL,30),
  (7902,'FORD','ANALYST',7566,'1991-12-3',3000,NULL,20),
  (7934,'MILLER','CLERK',7782,'1992-1-23',1300,NULL,10);

DROP TABLE IF EXISTS `sal_grade`;
CREATE TABLE `sal_grade` (
  grade INT UNSIGNED NOT NULL COMMENT '级别',
  low_sal DECIMAL(7,2) NOT NULL COMMENT '最低工资',
  hight_sal DECIMAL(7,2) NOT NULL COMMENT '最高工资'
) COMMENT '工资级别表';

INSERT INTO `sal_grade` VALUES 
  (1,700,1200),
  (2,1201,1400),
  (3,1401,2000),
  (4,2001,3000),
  (5,3001,9999);

```

#### 1.5.4.1. SELECT 查询

``` sql
-- 基本使用
SELECT [DISTINCT] *|{column_1,column_2 ...} FROM table_name;
```

``` sql
-- 使用表达式对查询的列进行运输
SELECT [DISTINCT] *|{column_1 | expression,column_2 | expression ...} FROM table_name;
```

``` sql
-- 在SELECT语句中可以使用as语句
SELECT column_name AS 别名 FROM table_name;
```

- 注意事项：

  - SELECT 指定查询哪些列的数据。
  - column 指定列名。
  - `*` 代表查询所有列。
  - FROM 指定查询哪张表。
  - DISTINCT 可选，指显示结果时，是否去掉重复数据。

> *新建数据，用于查询：*

``` sql
-- 创建新的表 student 
CREATE TABLE student (
  id INT(11) NOT NULL ,
  `name` VARCHAR(64) NOT NULL ,
  `chinese` DECIMAL(5,2),
  `english` DECIMAL(5,2),
  `math` DECIMAL(5,2)
);

INSERT INTO student VALUES (1,'韩顺平',89,78,90);
INSERT INTO student VALUES (2,'张飞',67,98,56);
INSERT INTO student VALUES (3,'宋江',87,78,77);
INSERT INTO student VALUES (4,'关羽',88,98,90);
INSERT INTO student VALUES (5,'赵云',82,84,67);
INSERT INTO student VALUES (6,'欧阳锋',55,85,45);
INSERT INTO student VALUES (7,'黄蓉',75,65,30);
```

> *练习：*

``` SQL
-- 查询表中所有学生的信息。
SELECT * FROM student;
-- 查询表中所有学生的姓名和对应的英语成绩。
SELECT `name`, `english` FROM student;
-- 过滤表中重复数据 distinct
SELECT DISTINCT * FROM student;
-- 要查询的记录，没过字段都相同，才会去重
SELECT DISTINCT `english` FROM student;
-- 
-- 统计每个学生的总分
SELECT  `name`, (`chinese` + `english` + `math` ) FROM student;
-- 在所有学生总分加10分的情况
SELECT  `name`, (`chinese` + `english` + `math` ) + 10 FROM student;
-- 使用别名表示学生分数
SELECT  `name`, (`chinese` + `english` + `math` ) AS 'total_score' FROM student;
```

#### 1.5.4.2. WHERE 子句

- 在where子句中经常使用的运算符

<table>
    <tr>
        <th>类型</th><th>符号</th><th>说明</th>
    </tr>
    <tr>
        <td rowspan="5">比较运算符</td><td> >，>=，<，<=，<>，!= </td><td>大于，大于等于，小于，小于等于，不等于</td>
    </tr>
    <tr>
        <td>BETWEEN ... AND ...</td><td>显示在某一个区间的值</td>
    </tr>
    <tr>
        <td>IN(set)</td><td>显示在in列表中的值，例：IN(1,2)</td>
    </tr>
    <tr>
        <td>LIKE 'abc' ; NOT LIKE 'abc'</td><td>模糊查询</td>
    </tr>
    <tr>
        <td>IS NULL ; IS NOT NULL</td><td>判断是否为空/非空</td>
    </tr>
    <tr>
        <td rowspan="3">逻辑运输符</td><td>AND</td><td>多个条件同时成立</td>
    </tr>
    <tr>
        <td>OR</td><td>多个条件任一成立</td>
    </tr>
    <tr>
        <td>NOT</td><td>不成立，例: WHERE NOT(salary > 100)</td>
    </tr>
</table>

> *练习：*

``` SQL
-- 查询姓名为赵云的学生成绩。
SELECT * FROM student WHERE `name`='赵云';
-- 查询英语成绩大于90分的同学。
SELECT * FROM student WHERE `english` > 90;
-- 查询总分大于200分的所有同学
SELECT *, (`chinese` + `english` + `math`) AS 'total_score' FROM student WHERE  (`chinese` + `english` + `math`) > 200;
-- 
-- 查询math大于60，并且 id大于4的学生成绩
SELECT * FROM student WHERE `math` > 60 AND `id`>4;
-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student WHERE `english` > `chinese` ;
-- 查询总分大于200分，并且 数学成绩小于语文成绩的，姓韩的学生
SELECT * FROM student WHERE (`chinese` + `english` + `math`) > 200 AND `math` < `chinese` AND `name` LIKE '韩%';
-- 查询英语分数在 80-90 之间的同学。
SELECT * FROM student WHERE `english` BETWEEN 80 AND 90 ;  -- BETWEEN ... AND ... 是闭区间，包含两头 。
-- 查询数学分为89,90,91的同学。
SELECT * FROM student WHERE `math` IN (89,90,91) ;
-- 查询数学分>80，语文分>80的同学
SELECT * FROM student WHERE `math` > 80  AND `chinese` > 80 ;

```

##### 1.5.4.2.1. LIKE 使用

- 如何使用like操作符：
  - `%`：表示0到多个字符；
  - `_`：表示单个字符；

> *练习：*

``` SQL
-- 查询 首字母为S的员工
SELECT * FROM emp WHERE emp_name LIKE 'S%';
-- 查询 第三个字母为O的所有员工
SELECT * FROM emp WHERE emp_name LIKE '__O%';
```

##### 1.5.4.2.2. IS NULL 和 IS NOT NULL

``` SQL
-- 查询 没有上级的雇员的情况
SELECT * FROM emp WHERE mgr IS NULL;
-- 查询 有分红的雇员
SELECT * FROM emp WHERE comm IS NOT NULL;

```

#### 1.5.4.3. order by 子句

``` sql
-- 使用 order by 子句排序查询结果
SELECT column_1, column_2 .. FROM table_name ORDER BY column ASC|DESC;
```

- 说明

  - ORDER BY 指定排序的列，排序的列即可以时表中的列名，也可以是`别名`
  - ASC 升序【默认】，DESC 降序
  - ORDER BY 子句应位于SELECT 语句的结尾。

> *练习：*

``` SQL
-- 对数学成绩排序后输出【升序】
SELECT * FROM student ORDER BY `math`;
-- 对总分按从高到低的顺序输出
SELECT *,(`chinese` + `english` + `math`) AS 'total_score'FROM student ORDER BY `total_score` DESC;
-- 对姓李的学生成绩排序输出【升序】
SELECT *,(`chinese` + `english` + `math`) AS 'total_score'FROM student WHERE `name` LIKE '李%' ORDER BY `total_score`;

-- 按照部门号升序而雇员的工资将序排列，显示雇员信息
SELECT * FROM emp ORDER BY dept_no ASC, sal DESC ;
```

#### 1.5.4.4. GROUP BY 子句

``` sql
-- 使用 GROUP BY 子句对列进行分组； 使用 HAVING 子句对分组后的结果进行过滤
SELECT column_1, column_2 .. FROM table_name GROUP BY column HAVING ...;
```

- 说明

  - GROUP BY 用于对查询的结果分组统计。
  - HAVING 子句用于限制分组显示结果。

> *练习：*

``` SQL
-- 查询每个部门的平均工资和最高工资
SELECT dept_no, AVG(sal) AS dept_avg_sal, MAX(sal) AS dept_max_sal FROM `emp` GROUP BY dept_no ;
-- 查询每个部门的每种岗位的平均工资和最低工资
SELECT dept_no,job, AVG(sal) AS dept_avg_sal, MIN(sal) AS dept_min_sal FROM `emp` GROUP BY dept_no, job ;
-- 查询平均工资低于2000的部门编号和它的平均工资
SELECT dept_no, AVG(sal) AS dept_avg_sal FROM `emp` GROUP BY dept_no HAVING dept_avg_sal < 2000;
```

> *加强练习：*

``` SQL
-- 查询每种岗位的雇员总数，平均工资。
SELECT job, COUNT(emp_no), AVG(sal) FROM emp GROUP BY job;

-- 查询雇员总数，以及获得补助的员工数，就是 comm 列为null。
SELECT  COUNT(*), COUNT(comm) FROM emp ; -- 注意：count会排除null
-- 查询雇员总数，以及没有获得补助的员工数，就是 comm 列为非null。
SELECT  COUNT(*), COUNT(IF(comm IS NULL, 1, NULL)) FROM emp ;
SELECT  COUNT(*), COUNT(*) - COUNT(comm) FROM emp ;

-- 查询管理者的总人数
SELECT COUNT(DISTINCT mgr) FROM emp ; -- 注意：count会排除null
SELECT DISTINCT mgr FROM emp ; -- 显示6个
SELECT mgr FROM emp GROUP BY mgr; -- 显示6个

-- 查询雇员工资的最大差额
SELECT MAX(sal), MIN(sal), MAX(sal) - MIN(sal) FROM emp ;
```

#### 1.5.4.5. 分页查询

``` SQL
-- limit 简单使用
SELECT ... LIMIT [rows];
-- 表示只取前出rows行

-- 分页查询：
SELECT ... LIMIT [start],[rows];
-- 表示从 start+1 行开始取，取出rows行,start 从0开始计算
```

> *练习：*

``` SQL
-- 按雇员的emp_no号升序取出，每页显示3条记录，请分别显示 第一页，第二页，第三页
-- page:1 , start = (1-1)*3 = 0
SELECT * FROM emp ORDER BY emp_no LIMIT 0,3;
-- page:2 , start = (2-1)*3 = 3
SELECT * FROM emp ORDER BY emp_no LIMIT 3,3;
-- page:3 , start = (3-1)*3 = 6
SELECT * FROM emp ORDER BY emp_no LIMIT 6,3;
```

#### 1.5.4.6. 多子句查询

``` SQL
-- 多子句查询
SELECT column_1, column_2, column_3.. FROM table_name
    WHERE condition
    GROUP BY column 
    HAVING condition
    ORDER BY column
    LIMIT start , rows ;
```

> *练习：*

``` SQL
-- 查询各个部门的平均工资，并且是大于1000的，并且按照平均工资从高到低排序，取出前两行记录
SELECT dept_no, AVG(sal) AS avg_sal FROM emp 
  GROUP BY dept_no 
  HAVING avg_sal > 1000 
  ORDER BY avg_sal DESC 
  LIMIT 2;
```

## 1.6. 函数

### 1.6.1. 统计/合计函数

#### 1.6.1.1. 统计函数 - COUNT

``` sql
-- COUNT 返回行的总数
SELECT COUNT(*) | COUNT(列名) FROM table_name [WHERE where_definition] 
```

> *练习：*

``` SQL
-- 统计一个班级共有多少学生？
SELECT COUNT(*) FROM student;
-- 统计数学成绩大于90的学生有多少个？
SELECT COUNT(*) FROM student WHERE `math`>90;
-- 统计总分大于250的人数
SELECT COUNT(*) FROM student WHERE (`chinese`+`english`+`math`)>250;
```

##### 1.6.1.1.1. COUNT(*) 和 COUNT(列) 的区别

- 解释
  - COUNT(*)：返回满足条件的记录的行数
  - COUNT(列)：统计满足条件的某列有多少个，但是会排除为null

> *演示：*

``` SQL
CREATE TABLE t17 (
  `name` VARCHAR(64)
);

INSERT INTO t17 VALUES ('tom'),('jack'),('mary'),(NULL);

SELECT COUNT(*) FROM t17; -- 返回：4
SELECT COUNT(`name`) FROM t17; -- 返回：3
```

#### 1.6.1.2. 合计函数 - SUM

``` sql
-- SUM 函数返回满足 wh#re 条件的行的和；一般使用在数值列
SELECT SUM(列名) [,SUM(列名) ...] FROM table_name [WHERE where_definition] 
```

> *练习：*

``` SQL
-- 统计一个班级数学总成绩
SELECT SUM(`math`) FROM student;
-- 统计一个班级语文、英语、数学各科的总成绩
SELECT SUM(`chinese`),SUM(`english`),SUM(`math`) FROM student;
-- 统计一个班级语文、英语、数学的成绩总和
SELECT SUM(`chinese` + `english` + `math`) FROM student;
-- 统计一个班级语文成绩的平均分
SELECT SUM(`chinese`) / COUNT(*) FROM student;
```

#### 1.6.1.3. 合计函数 - AVG

``` sql
-- AVG 函数返回满足 where 条件的一列的平均值
SELECT AVG(列名) [,AVG(列名) ...] FROM table_name [WHERE where_definition] 
```

> *练习：*

``` SQL
-- 求一个班级数学平均分
SELECT AVG(`math`) FROM student;
-- 求一个班总分平均分
SELECT AVG(`chinese` + `english` + `math`) FROM student;
```

#### 1.6.1.4. 合计函数 - MAX / MIN

``` sql
-- max / min 函数返回满足where条件的一列的最大/最小值
SELECT MAX/MIN(列名) [,MAX/MIN(列名) ...] FROM table_name [WHERE where_definition] 
```

> *练习：*

``` SQL
-- 求班级最高分和最低分（数值范围在统计中特别有用）
SELECT MAX(`chinese` + `english` + `math`) AS 'max_total_score',
       MIN(`chinese` + `english` + `math`) AS 'min_total_score'
       FROM student;
```

### 1.6.2. 字符串函数

| 函数                                | 说明                                               |
| ----------------------------------- | -------------------------------------------------- |
| CHARSET(str)                        | 返回字符串集，返回 utf8 , gbk ...                  |
| CONCAT(str [,...])                  | 连接字串                                           |
| INSTR(str,substr)                   | 返回substr在str中出现的位置，没有返回0             |
| UCASE(str)                          | 转换成大写                                         |
| LCASE(str)                          | 转换成小写                                         |
| LEFT(str,length)                    | 从str中的左边起取length个字符                      |
| RIGHT(str,length)                   | 从str中的右边起取length个字符                      |
| LENGTH(str)                         | str长度                                            |
| REPLACE(str,search_str,replace_str) | 在str中用replace_str替换search_str                 |
| STRCMP(str1,str2)                   | 逐字符比较两个字符串大小                           |
| SUBSTRING(str,position [, length])  | 从str的position开始【从1开始计算】，取length个字符 |
| TRIM(str) LTRIM(str) RTRIM(str)     | 去除空格，左端空格，右端空格                       |

> *练习：*

``` SQL
-- 以首字母小写的方式显示所有员工的emp的姓名
SELECT CONCAT(LCASE(LEFT(emp_name,1)), SUBSTRING(emp_name,2)) AS new_emp_name FROM emp ;
```

### 1.6.3. 数学函数

| 函数                        | 说明                                                                                                                                   |
| --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| ABS(num)                    | 绝对值                                                                                                                                 |
| BIN(decimal_num)            | 十进制转二进制                                                                                                                         |
| CEILING(num)                | 向上取整，得到比num2大的最小整数                                                                                                       |
| CONV(num,from_base,to_base) | 进制转换                                                                                                                               |
| FLOOR(num)                  | 向下取整，得到比num小的最大整数                                                                                                        |
| FORMAT(num,decimal_places)  | 保留小数位                                                                                                                             |
| HEX(decimal_num)            | 转十六进制                                                                                                                             |
| LEAST(num_1,num_2 [,..])    | 求最小值                                                                                                                               |
| MOD(numerator,denominator)  | 求余                                                                                                                                   |
| RAND([seed])                | 随机数；其范围是：0 ≦ v ≦ 1.0 。 rand()返回一个随机浮点值v，范围在0到1之间。若已指定一个整数参数N,则它被用作种子值，用来参赛重复序列。 |

> *练习：*

``` SQL
-- ABS(num) 绝对值
SELECT ABS(-10) ; -- 10

-- BIN(decimal_num) 十进制转二进制
SELECT BIN(3) ; -- 11
-- HEX(decimal_num) 转十六进制
SELECT HEX(26) ; -- 1A
-- CONV(num,from_base,to_base) 进制转换
-- 下面的含义是： 8 是十进制的8，转成8进制输出
SELECT CONV(8,10,8) ; -- 10

-- CEILING(num) 向上取整，得到比num2大的最小整数
SELECT CEILING(1.1) ; -- 2
-- FLOOR(num) 向下取整，得到比num小的最大整数
SELECT FLOOR(1.1) ; -- 1

-- MOD(numerator,denominator)求余
SELECT MOD(10,3) ; -- 1
-- RAND([seed]) 其范围是：0 ≦ v ≦ 1.0 。
SELECT RAND() ; -- 0.1685401212131047
SELECT RAND(3) ; -- 0.9057697559760601

-- FORMAT(num,decimal_places)	保留小数位
SELECT FORMAT(0.9057697559760601,2) ; -- 0.91

-- LEAST(num_1,num_2 [,..]) 求最小值
SELECT LEAST(1,2,3,0.5) ; -- 0.5

```

### 1.6.4. 时间日期

| 函数                                    | 说明                                              |
| --------------------------------------- | ------------------------------------------------- |
| CURRENT_DATE()                          | 当前日期                                          |
| CURRENT_TIME()                          | 当前时间                                          |
| CURRENT_TIMESTAMP()                     | 当前时间戳                                        |
| DATE(datetime)                          | 返回datetime的日期部分                            |
| DATE_ADD(date2,INTERVAL d_value d_type) | 在date2中加上日期或时间                           |
| DATE_SUB(date2,INTERVAL d_value d_type) | 在date2中减去日期或时间                           |
| DATEDIFF(date1,date2)                   | 两个日期差（结果是天）                            |
| TIMEDIFF(date1,date2)                   | 两个时间差（多少小时多少分钟多少秒）              |
| NOW()                                   | 当前时间                                          |
| YEAR / MONTH / DAY / DATE(datetime)     | 年月日                                            |
| UNIX_TIMESTAMP()                        | 返回1970-1-1 到现在的秒数                         |
| FROM_UNIXTIME()                         | 可以把一个unix_timestamp 秒数，转成指定格式的日期 |
| DATE_FORMAT(date,format)                | 日期格式化，返回一个string                        |


- 说明

  - `DATE_ADD()` 中的 `interval` 后面的 `d_type` 可以是 `YEAR`, `MONTH`, `DAY`, `HOUR`, `MINUTE`, `SECOND`。
  - DATEDIFF() 得到的是天数，而且是 date1 - date2 的天数，因此可以取负数 。
  - DATE() DATE_ADD() DATE_SUB() DATEDIFF() 函数的日期类型可以是 date, datetime, timestamp

> *练习：*

``` SQL
-- DDL
CREATE TABLE msg (
  id INT(11) NOT NULL , 
  content VARCHAR(64) NOT NULL COMMENT '内容',
  send_time DATETIME NOT NULL COMMENT '发送时间'
) COMMENT '消息表';
-- DML
INSERT INTO msg VALUES 
  (1,'北京新闻',CURRENT_TIMESTAMP()),
  (2,'上海新闻',NOW()),
  (3,'广州新闻',NOW());

-- DQL
-- 显示所有新闻信息，发布日期只显示 日期，不显示时间
SELECT id , content , DATE(send_time) FROM msg;
-- 查询在10分钟内发布的新闻
SELECT * FROM msg WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE) >= NOW();
SELECT * FROM msg WHERE DATE_ADD(NOW(), INTERVAL -10 MINUTE) <= send_time;
SELECT * FROM msg WHERE DATE_SUB(NOW(), INTERVAL 10 MINUTE ) <= send_time;
-- 在mysql的sql语句中求出 2011-11-11 和 1990-1-1  相差多少天
SELECT DATEDIFF('2011-11-11','1990-01-01');
SELECT DATEDIFF('2022-12-31',CURRENT_DATE());
-- 在mysql的sql语句中求出你活了多少天？
SELECT DATEDIFF(CURRENT_DATE(),'1990-01-04');
-- 如果你能活到80岁，求出你还能活多少天？
SELECT DATEDIFF(DATE_ADD('1990-01-04', INTERVAL 80 YEAR),CURRENT_DATE());

-- YEAR(date) MONTH(date) DATE(date)
SELECT YEAR(NOW()) AS 'YEAR', MONTH(NOW()) AS 'MONTH' , DAY(NOW()) AS 'DAY' , DATE(NOW()) AS 'DATE';

-- UNIX_TIMESTAMP() 返回1970-1-1 到现在的毫秒数
SELECT UNIX_TIMESTAMP();
SELECT UNIX_TIMESTAMP() / 365 / 24 / 3600; -- 计算 1970-1-1 到现在多少年
-- FROM_UNIXTIME() 可以把一个unix_timestamp 秒数，转成指定格式的日期 
SELECT FROM_UNIXTIME(1655824383,'%Y-%m-%d %h:%i:%s.%x');

-- 日期格式化，返回一个字符串
SELECT DATE_FORMAT(NOW(),'%Y-%m-%d %h:%i:%s');
```

### 1.6.5. 系统函数和加密

| 函数          | 说明                                                                   |
| ------------- | ---------------------------------------------------------------------- |
| USER()        | 查询用户                                                               |
| DATABASE()    | 数据库名称                                                             |
| MD5(str)      | 为字符串算出一个 MD5 32位的字符串                                      |
| PASSWORD(str) | 从原文密码str计算并返回密码字符串，通常用于对mysql数据库的用户密码加密 |

> *练习：*

``` SQL
-- DDL
CREATE TABLE user (
  id INT(11) NOT NULL , 
  name VARCHAR(64) NOT NULL COMMENT '用户名',
  pwd CHAR(32) NOT NULL COMMENT '密码'
) COMMENT '用户表';

-- DML
INSERT INTO user VALUES (1,'gx',MD5('123456'));

-- DQL
-- USER() 查询用户: 用户@IP地址，可以查看登录到mysql的有哪些用户，以及登陆的IP
SELECT USER();
-- DATABASE() 数据库名称
SELECT DATABASE();
-- MD5(str) 为字符串算出一个 MD5 32位的字符串 
SELECT MD5('123456');
SELECT LENGTH(MD5('123456'));
-- PASSWORD(str)
SELECT PASSWORD('1234');
SELECT * FROM mysql.user;

```

### 1.6.6. 流程控制

| 函数                                                                    | 说明                                                                     |
| ----------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| IF(expr1,expr2,expr3)                                                   | 如果expr1为true，则返回expr2，否则返回expr3                              |
| IFNULL(expr1,expr2)                                                     | 如果expr1不为空，则返回expr1，否则返回expr2                              |
| SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; | 如果expr1为 true，d返回expr2，如果expr3为true，返回expr4，否则返回 expr5 |

> *练习：*

``` SQL
-- DQL
-- IF(expr1,expr2,expr3)
SELECT IF(TRUE,'true','false');
SELECT IF(FALSE,'true','false');
-- IFNULL(expr1,expr2)
SELECT IFNULL(comm,0) FROM emp;
-- CASE WHEN THEN ELSE END
SELECT emp_name,CASE WHEN sal>700 AND sal<1200 THEN '1级' ELSE '高于1级' END FROM emp;

-- 查询emp表，如果 comm 是null , 则显示0.0
SELECT emp_name, sal, IFNULL(comm,'0.0') AS comm FROM emp ;
-- 如果emp表的 job 是 clerk 则显示 职员，如果是 manager 则显示 经理 ， 如果是 salesman 则显示 销售人员 ， 其他正常显示
SELECT emp_name, CASE WHEN job='CLERK' THEN '职员' WHEN job='MANAGER' THEN '经理' WHEN job='SALESMAN' THEN '销售人员' ELSE job END AS 'job' FROM emp ;

```

## 1.7. 多表查询

多表查询是指基于两个和两个以上的表查询。在实际应用中，查询单个表可能不能满足需求。

### 1.7.1. 笛卡尔集

> *练习：*

``` SQL
-- ？显示雇员名，雇员工资及所在部门的名字【笛卡尔集】
SELECT * FROM emp e, dept d; -- 【笛卡尔集】
SELECT e.emp_name, e.sal, d.dept_name FROM emp e , dept d WHERE e.dept_no = d.dept_no;
```

- 说明，在默认情况下，对两张表进行查询，规则如下：
  - 从第一张表中，取出一行和第二张表的每一行进行组合，返回结果【含有两种表的所有列】
  - 一共返回的记录数 = 第一张表的行数 * 第二张表的行数
  - 这样的多表查询默认处理返回的结果，称为 **【笛卡尔集】**

> *技巧：* 多表查询的条件不能少于 *表的个数-1*，否则会出现笛卡尔集。

### 1.7.2. 多表查询案例

> *练习：*

``` SQL
-- 如何显示部门号为10到部门名、员工名 和 工资
SELECT d.dept_no, d.dept_name, e.emp_name, e.sal FROM emp e , dept d WHERE e.dept_no = d.dept_no AND d.dept_no = 10;
-- 显示各个员工的姓名，工资，及其工资级别
SELECT e.emp_name, e.sal, sg.grade FROM emp e , sal_grade sg WHERE e.sal >= sg.low_sal AND e.sal <= sg.hight_sal;
-- 显示雇员名，雇员工资及所在部门的名字，并按部门排序【降序】
SELECT e.emp_name, e.sal, d.dept_name FROM emp e, dept d WHERE e.dept_no = d.dept_no ORDER BY d.dept_name DESC;
```

### 1.7.3. 自连接

自连接是指在同一张表的连接查询【将同一张表看做两张表】。

> *练习：*

``` SQL
-- 查询雇员名字和他上级的名字
SELECT e1.emp_name, e2.emp_name AS mgr_name FROM emp e1, emp e2 WHERE e1.mgr = e2.emp_no;
```

### 1.7.4. 子查询

- 什么是子查询？
  - 子查询是指嵌入在其他sql语句中的select语句，也叫嵌套查询
- 单行子查询
  - 单行子查询是指只返回一行数据的子查询语句
- 多行子查询
  - 多行子查询指返回多行数据的子查询，使用关键字`IN`

> *练习：*

``` SQL
-- 查询显示与SMITH同一个部门的所有员工
SELECT * FROM emp e WHERE e.dept_no = (SELECT e1.dept_no FROM emp e1 WHERE e1.emp_name = 'SMITH');
-- 查询和部门10的工作相同的雇员的名字、岗位、工资、部门号，但是不含10部门自己的.
SELECT DISTINCT e.job FROM emp e WHERE e.dept_no = 10;
SELECT e.emp_name, e.job, e.sal, e.dept_no FROM emp e WHERE  e.dept_no <> 10 AND e.job IN (SELECT DISTINCT e.job FROM emp e WHERE e.dept_no = 10);
```

#### 1.7.4.1. 临时表

子查询当做临时表使用。

> *练习：*

``` SQL
-- 查询各部门工资最高的人
  -- 查询某部门工资最高的人
SELECT e.dept_no, MAX(e.sal) AS 'max_sal' FROM emp e GROUP BY e.dept_no;

SELECT e.* FROM emp e , 
  (SELECT e1.dept_no, MAX(e1.sal) AS 'max_sal' FROM emp e1 GROUP BY e1.dept_no) e2
WHERE  e.dept_no = e2.dept_no AND e.sal = e2.max_sal ORDER BY dept_no;

-- 查询各部门工资前三的员工
SELECT e.* FROM emp e 
WHERE (
  SELECT COUNT(DISTINCT e1.sal) FROM emp e1 WHERE e1.dept_no = e.dept_no AND e1.sal > e.sal
) < 3 ORDER BY dept_no , sal DESC;
```

#### 1.7.4.2. all操作符 和 any操作符

> *练习：all操作符*

``` SQL
-- 查询工资比部门30的所有员工的工资高的员工的姓名、工资和部门号
SELECT e.emp_name, e.sal, e.dept_no FROM emp e WHERE e.sal > ALL(SELECT sal FROM emp WHERE dept_no=30);
-- 也可以使用max函数代替
SELECT e.emp_name, e.sal, e.dept_no FROM emp e WHERE e.sal > (SELECT MAX(DISTINCT sal) FROM emp WHERE dept_no=30);
```

> *练习：any操作符*

``` SQL
-- 查询工资比部门30的其中一个员工的工资高的员工的姓名、工资和部门号
SELECT e.emp_name, e.sal, e.dept_no FROM emp e WHERE e.sal > ANY(SELECT sal FROM emp WHERE dept_no=30);
-- 也可以使用MIN函数代替
SELECT e.emp_name, e.sal, e.dept_no FROM emp e WHERE e.sal > (SELECT MIN(DISTINCT sal) FROM emp WHERE dept_no=30);
```

#### 1.7.4.3. 多列子查询

`多列子查询`是指查询返回多个列数据的子查询语句。

> *练习：*

``` SQL
-- 查询与ALLEN的部门和岗位完全相同的所有雇员（并且不含ALLEN本人）
SELECT * FROM emp WHERE (dept_no, job) = (SELECT dept_no, job FROM emp WHERE emp_name='ALLEN') AND emp_name<>'ALLEN';
 ```

#### 1.7.4.4. 子查询练习

> *练习：*

``` SQL
-- 查找每个部门工资高于本部门平均工资的雇员信息
  -- 普通子查询方式
SELECT e.* FROM emp e WHERE e.sal > (SELECT avg(e1.sal) FROM emp e1 WHERE e1.dept_no = e.dept_no);
  -- 临时表方式
SELECT e.* FROM emp e, (SELECT dept_no, AVG(sal) AS avg_sal FROM emp GROUP BY dept_no) t2 WHERE e.dept_no = t2.dept_no AND e.sal > t2.avg_sal;

-- 查询每个部门工资最高的雇员信息
  -- 临时表方式
SELECT e.* FROM emp e, (SELECT dept_no, MAX(sal) AS avg_sal FROM emp GROUP BY dept_no) t2 WHERE e.dept_no = t2.dept_no AND e.sal = t2.avg_sal;
  -- 统计工资在部门中排名的方式：比如部门最高工资就意味着部门中工资大于等于自己工资的只有一个人（自己）；
SELECT e.* FROM emp e WHERE (SELECT COUNT(DISTINCT sal) FROM emp e1 WHERE e1.dept_no=e.dept_no AND e1.sal>=e.sal ) = 1 ;

-- 查询每个部门的信息（包括：部门名，编号，地址）和人员数量
SELECT d.dept_no, d.dept_name, d.loc, t.dept_count FROM dept d ,
  (SELECT dept_no, COUNT(emp_no) AS dept_count FROM emp GROUP BY dept_no) t
WHERE d.dept_no = t.dept_no;
```

### 1.7.5. 合并查询

在实际应用中，为了合并多个 select 语句的结果，可以使用合集操作符号 `union` , `union all`;

- union all 
  - 该操作符用于取得两个结果集的并集。当使用该操作符时，不会取消重复行。
- union
  - 该操作符用于取得两个结果集的并集。会去除重复记录。

> *练习：*

``` SQL
-- UNION ALL 不去重
SELECT emp_name, sal, job FROM emp WHERE sal>2500 
UNION ALL
SELECT emp_name, sal, job FROM emp WHERE job='MANAGER';
-- UNION 去重
SELECT emp_name, sal, job FROM emp WHERE sal>2500 
UNION
SELECT emp_name, sal, job FROM emp WHERE job='MANAGER';
```

### 1.7.6. 外连接

- 外连接
  - 左外连接（如果左侧的表完全显示我们就说是左外连接）
  - 右外连接（如果右侧的表完全显示我们就说是右外连接）

> *练习：*

``` SQL
-- 创建表 stu
CREATE TABLE stu (id INT, name VARCHAR(32));
INSERT INTO stu VALUES (1, 'jack'),(2, 'tom'),(3, 'kity'),(4, 'nono');
-- 创建表 exam
CREATE TABLE exam (id INT, grade INT);
INSERT INTO exam VALUES (1, 56),(2, 76),(11, 8);

-- 使用左外连接（显示所有人的成绩，如果没有成绩，也要显示该人的姓名和ID，成绩为空）
SELECT s.id, s.name, e.grade FROM stu s LEFT JOIN exam e ON s.id=e.id;
-- 右连接（显示所有成绩，如果没有名字匹配，显示空）
SELECT e.id, s.name, e.grade FROM stu s RIGHT JOIN exam e ON s.id=e.id;

-- 练习：列出部门名称和一下部门的员工信息（名字和工作），同时列出哪些没有员工的部门
-- 左连接
SELECT d.dept_name, e.emp_name, e.job FROM dept d LEFT JOIN emp e ON d.dept_no = e.dept_no ORDER BY d.dept_no;
-- 右连接
SELECT d.dept_name, e.emp_name, e.job FROM emp e RIGHT JOIN dept d  ON d.dept_no = e.dept_no ORDER BY d.dept_no;
```

### 1.7.7. 内连接

> *练习：*

``` SQL
-- 查询雇员信息，以及雇员所在部门信息
-- INNER JOIN
SELECT * FROM emp e INNER JOIN dept d ON e.dept_no = d.dept_no;
-- 使用多表查询加where条件，等同于 inner join
SELECT * FROM emp e , dept d WHERE e.dept_no = d.dept_no;
```

## 1.8. 约束

约束用于确保数据库的数据满足特定的商业规则。

在mysql中，约束包括：`not null`、`unique`、`primary key`、`foreign key` 和 `check` 五种

### 1.8.1. primary key（主键）

``` sql
-- 基本使用
字段名 字段类型 primary key 
```

用于唯一的标示表行的数据，当定义主键约束后，*该列不能重复*。

> *练习：*

``` SQL
-- 主键的使用
CREATE TABLE t17 (
  `id` INT PRIMARY KEY COMMENT '表示id列是主键',
  `name` VARCHAR(32),
  `email` VARCHAR(64)
);
-- 添加数据
INSERT INTO t17 VALUES (1,'jack','jack@123.com');
-- INSERT INTO t17 VALUES (1,'tom','tom@123.com'); -- 报错：主键重复
-- INSERT INTO t17 VALUES (NULL,'xxx','xxx@123.com'); -- 报错：主键不能为空

-- 创建复合主键
CREATE TABLE t17_1 (
  `id` INT COMMENT '表示id列是主键',
  `name` VARCHAR(32),
  `email` VARCHAR(64),
  PRIMARY KEY (`id`,`name`)
);
```

- 主键的细节
  - primary key 不能重复而且不能为null；
  - 一张表最多只能有一个主键，但可以是复合主键；
  - 定义主键的方式有两种：
    1. 直接在字段名后指定：`字段名 字段类型 PRIMARY KEY`
    2. 在表定义最后写 PRIMARY KEY (列名...)
  - 提醒：在实际开发中，美国表往往都会设计一个主键。

#### 1.8.1.1. 新增/删除/修改 主键

假设现在新建一张表，结构如下：

``` SQL
CREATE TABLE t17_2 (
  `id` INT,
  `name` VARCHAR(32),
  `email` VARCHAR(64)
);
```

> *练习：*

``` SQL
-- 新增主键
-- 将没有主键的表t17_2 中 id 字段设为主键
ALTER TABLE t17_2 ADD PRIMARY KEY (`id`);
```

> *练习：*

``` SQL
-- 删除主键
-- 将没有主键的表t17_2 中 id 字段设为主键
ALTER TABLE t17_2 DROP PRIMARY KEY;
```

> *练习：*

``` SQL
-- 修改主键，先删除表现有的主键，再新增
ALTER TABLE t17_2 DROP PRIMARY KEY;
ALTER TABLE t17_2 ADD PRIMARY KEY(`id`,`name`);
```

### 1.8.2. not null (非空)

如果在列上定义了`NOT NULL`，那么当插入数据时，必须为列提供数据。

### 1.8.3. unique （唯一）

当定义了唯一约束后，该列值时不能重复的。

- unique 使用细节
  - 如果没有指定`NOT NULL`，则 UNIQUE 字段可以有多个NULL ;
  - 一张表可以有多个 UNIQUE 字段 ;
  - 如果一个列（字段），是 UNIQUE NOT NULL 使用效果类似 PRIMARY KEY ;

> *练习：*

``` SQL
-- 创建 字段包含 unique 的 表
CREATE TABLE t18 (
  id INT UNIQUE ,
  `name` VARCHAR(32)
);

-- 测试：id相同的两条数据能不能插入
INSERT INTO t18 VALUES (1,'TOM');
-- INSERT INTO t18 VALUES (1,'JACK'); -- 报错：ERROR 1062 (23000): Duplicate entry '1' for key 'id'

-- 测试：如果没有指定`NOT NULL`，则 UNIQUE 字段可以有多个NULL
INSERT INTO t18 VALUES (NULL,'JERRY');
INSERT INTO t18 VALUES (NULL,'JERRY');


```

### 1.8.4. foreign key (外键)

foreign key (外键) 用于定义主表和从表之间的关系：外键约束要定义在从表上，主表则必须具有主键约束或事unique约束；当定义外键约束后，要求外键列数据必须在主表的主键列存在或是为null。

``` SQL
-- 语法
FOREIGN KEY (本表字段名) REFERENCES 主表名(主键名或unique字段名)
```

- foreign key (外键) —— 细节说明
  1. 外键指向的表的字段，要求是primary key 或者是 unique；
  2. 表的类型是innodb，这样的表才支持外键；
  3. 外键字段的类型要和主键字段的类型一致（长度可以不同）；
  4. 外键字段的值，比心在主键字段中出现过，或者为null [前提是外键字段允许为null]；
  5. 一旦建立外键的关系，数据不能随意删除；

> *练习：*

``` SQL
-- 创建主表
CREATE TABLE my_class (
  id INT PRIMARY KEY COMMENT '班级ID',
  `name` VARCHAR(32) COMMENT '班级名称'
);
-- 创建外键表
CREATE TABLE my_student (
  id INT PRIMARY KEY COMMENT '学生ID',
  `name` VARCHAR(32) COMMENT '学生姓名',
  class_id INT COMMENT '班级ID',
  FOREIGN KEY (class_id) REFERENCES my_class(id)
);

-- 插入数据
INSERT INTO my_class VALUES (1,'班一'),(2,'班二');
INSERT INTO my_student VALUES (1,'张三',1),(2,'李四',1),(3,'王五',2);
-- 尝试插入一个班级ID不存在的学生
-- INSERT INTO my_student VALUES (4,'赵六',3); -- ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails

-- 尝试插入一个外键为空的学生
INSERT INTO my_student VALUES (4,'钱七',NULL);
```

### 1.8.5. check

check 用于强制行数据必须满足的条件。例如：在sal列上定义了check约束，并要求sal列值在1000~2000之间，如果不在1000~2000之间就会提示出错。

> 注意： oracle 和 sql server 均支持check，但是mysql 5.7 目前还不支持 check ， 只做语法校验，但不会生效。

``` SQL
-- 语法
列名 类型 check( check 条件 )
```

> *练习：*

``` SQL
CREATE TABLE t19 (
  id INT PRIMARY KEY ,
  `name` VARCHAR(32),
  sex VARCHAR(6) CHECK (sex IN('man','woman')),
  sal DECIMAL(7,2) CHECK (sal > 1000 AND sal < 2000)
);
-- 约束并没有生效
INSERT INTO t19 VALUES (1,'FOO','m',900);
```

### 1.8.6. 约束相关练习

> *练习：*

``` SQL
/*
商店售货表设计案例

现有一个商店的数据库shop_db，记录客户及其购买情况，由下面三个表组成：
商品goods (商品号goods_id，商品名goods_name，单价unit_price，商品类别category，供应商provider);
客户customer(客户号customer_id，姓名name，住址address，电邮email，性别sex，身份证card_id);
购买purchase(购买订单号order_id，客户号customer_id，商品号goods_id，购买数nums);

1，建表，在定义中要求声明【进行合理设计】：
（1），每个表的主外键；
（2），客户的姓名不能为空值；
（3），电邮不能重复；
（4），客户的性别【男】【女】
（5），单价unit_price 在 1.0 ～ 9999.99 之间
*/

CREATE DATABASE shop_db CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

USE shop_db;

DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
  goods_id INT UNSIGNED PRIMARY KEY COMMENT '商品号',
  goods_name VARCHAR(32) NOT NULL COMMENT '商品名',
  unit_price DECIMAL(6,2) COMMENT '单价' CHECK (unit_price>=1.0 AND unit_price<=9999.99) ,
  category VARCHAR(32) COMMENT '商品类别',
  `provider` VARCHAR(32) COMMENT '供应商'
)  COMMENT '商品表';

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  customer_id INT UNSIGNED PRIMARY KEY COMMENT '客户号',
  `name` VARCHAR(32) NOT NULL COMMENT '姓名',
  `address` VARCHAR(32) COMMENT '住址',
  `email` VARCHAR(32) UNIQUE COMMENT '电邮',
  `sex` VARCHAR(32) COMMENT '性别' CHECK (`sex` IN ('男','女')) ,
  `card_id` VARCHAR(32) COMMENT '身份证'
) COMMENT '客户表';

DROP TABLE IF EXISTS purchase;
CREATE TABLE purchase (
  order_id INT UNSIGNED PRIMARY KEY COMMENT '购买订单号',
  customer_id INT UNSIGNED COMMENT '客户号',
  goods_id INT UNSIGNED COMMENT '商品号',
  nums INT UNSIGNED COMMENT '购买数',
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (goods_id) REFERENCES goods (goods_id)
) COMMENT '购买表';
```

### 1.8.7. 自增长 auto_increment

在某张表中，存在一个id列（整数），我们希望在添加记录的时候，该列从1开始，自动的增长，可以使用 auto_increment

``` sql
-- 语法
字段名 类型 PRIMARY KEY AUTO_INCREMENT
```

- 使用细节
  1. 一般来说自增长是和primary key 配合使用的；
  2. 自增长也可以单独使用【但是需要配合一个unique】；
  3. 自增长修饰的字段为整数型的（虽然小数也可以，但是非常非常少这样使用）；
  4. 自增长默认从1开始，你也可以通过如下命令修改：`ALTER TABLE 表名 AUTO_INCREMENT = 新的开始值`；
  5. 如果你添加数据时，给自增长字段（列）指定的有值，则以指定的值为准；

> *练习：*

``` SQL
-- 创建表
CREATE TABLE t20_auto_increment (
  id INT PRIMARY KEY AUTO_INCREMENT ,
  `name` VARCHAR(32) 
);

-- 插入数据
-- 1，ID 为null 
INSERT INTO t20_auto_increment VALUES (null,'Aoo'); -- 插入成功，id = 1
-- 2，ID 不添加
INSERT INTO t20_auto_increment (`name`) VALUES ('Aoo'); -- 插入成功，id = 2
```

#### 1.8.7.1. 修改自增长开始值

``` SQL
ALTER TABLE [表名] AUTO_INCREMENT = [开始值]
```

> *练习：*

``` SQL
-- 修改自增长开始值
ALTER TABLE t20_auto_increment AUTO_INCREMENT = 100;

-- 插入数据
INSERT INTO t20_auto_increment (`name`) VALUES ('Coo'); -- 插入成功，id = 100

-- 测试指定ID值，然后再插入一条不指定的值，看看结果
INSERT INTO t20_auto_increment (id,`name`) VALUES (150,'Doo'); -- 插入成功，id = 150
INSERT INTO t20_auto_increment (`name`) VALUES ('Eoo'); -- 插入成功，id = 151

```

## 1.9. 索引

### 1.9.1. 唯一索引（UNIQUE）

### 1.9.2. 普通索引（INDEXs）

### 1.9.3. 全文索引

## 1.10. 事物
