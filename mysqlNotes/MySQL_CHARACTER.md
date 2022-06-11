# 1. 查看 MySQL 字符集方法

- [1. 查看 MySQL 字符集方法](#1-查看-mysql-字符集方法)
  - [1.1. MySQL字符集设置](#11-mysql字符集设置)
  - [1.2. 查看MySQL数据库服务器和数据库MySQL字符集](#12-查看mysql数据库服务器和数据库mysql字符集)
  - [1.3. 查看MySQL所有database字符集](#13-查看mysql所有database字符集)
  - [1.4. 查看MySQL的table的字符集](#14-查看mysql的table的字符集)
  - [1.5. 查看MySQL数据表中列的字符集](#15-查看mysql数据表中列的字符集)

## 1.1. MySQL字符集设置

``` shell
系统变量：
- character_set_server : 默认的内部操作字符集
- character_set_client : 客户端来源数据使用的字符集
- character_set_connection : 连接层字符集
- character_set_results : 查询结果字符集
- character_set_database : 当前选中数据库的默认字符集
- character_set_system : 系统元数据（字段名等）字符集
- 还有以collation_开头的同上面对应的变量，用来描述字符序
```

## 1.2. 查看MySQL数据库服务器和数据库MySQL字符集

``` shell
mysql> SHOW VARIABLES LIKE 'character%';
+--------------------------+----------------------------+
| Variable_name            | Value                      |
+--------------------------+----------------------------+
| character_set_client     | utf8                       |
| character_set_connection | utf8                       |
| character_set_database   | utf8mb4                    |
| character_set_filesystem | binary                     |
| character_set_results    | utf8                       |
| character_set_server     | utf8mb4                    |
| character_set_system     | utf8                       |
| character_sets_dir       | /usr/share/mysql/charsets/ |
+--------------------------+----------------------------+
8 rows in set (0.01 sec)
```

## 1.3. 查看MySQL所有database字符集

``` shell
mysql> SELECT * FROM information_schema.SCHEMATA;
+--------------+--------------------+----------------------------+------------------------+----------+
| CATALOG_NAME | SCHEMA_NAME        | DEFAULT_CHARACTER_SET_NAME | DEFAULT_COLLATION_NAME | SQL_PATH |
+--------------+--------------------+----------------------------+------------------------+----------+
| def          | information_schema | utf8                       | utf8_general_ci        | NULL     |
| def          | mysql              | utf8mb4                    | utf8mb4_general_ci     | NULL     |
| def          | performance_schema | utf8                       | utf8_general_ci        | NULL     |
| def          | sys                | utf8                       | utf8_general_ci        | NULL     |
| def          | xgo-admin          | utf8mb4                    | utf8mb4_general_ci     | NULL     |
| def          | xgo_01             | utf8mb4                    | utf8mb4_general_ci     | NULL     |
| def          | xgo_02             | utf8                       | utf8_general_ci        | NULL     |
| def          | xgo_03             | utf8mb4                    | utf8mb4_bin            | NULL     |
+--------------+--------------------+----------------------------+------------------------+----------+
8 rows in set (0.03 sec)
```

## 1.4. 查看MySQL的table的字符集

``` shell
mysql> SHOW TABLE STATUS FROM [数据库名];
```

注意：只能看到`table`的`Collation`值

## 1.5. 查看MySQL数据表中列的字符集

``` shell
mysql> SHOW FULL COLUMNS FROM t1;
+-------+--------------+--------------------+------+-----+---------+-------+---------------------------------+---------+
| Field | Type         | Collation          | Null | Key | Default | Extra | Privileges                      | Comment |
+-------+--------------+--------------------+------+-----+---------+-------+---------------------------------+---------+
| id    | int(11)      | NULL               | YES  |     | NULL    |       | select,insert,update,references |         |
| name  | varchar(255) | utf8mb4_general_ci | YES  |     | NULL    |       | select,insert,update,references |         |
+-------+--------------+--------------------+------+-----+---------+-------+---------------------------------+---------+
2 rows in set (0.01 sec)
```