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
    - [1.3.1. 创建表](#131-创建表)
    - [1.3.2. 删除表](#132-删除表)
    - [1.3.3. 修改表](#133-修改表)
    - [1.3.4. 查看表](#134-查看表)
  - [1.4. MySQL数据类型](#14-mysql数据类型)
    - [1.4.1. 整数类型](#141-整数类型)
    - [1.4.2. 浮点类型](#142-浮点类型)
    - [1.4.3. 文本类型、二进制类型](#143-文本类型二进制类型)
    - [1.4.4. 日期](#144-日期)
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

### 1.3.2. 删除表

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
