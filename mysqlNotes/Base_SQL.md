# 常用基础SQL

## 创建表

``` SQL
DROP TABLE IF EXISTS [table_name]
CREATE TABLE [table_name] (
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    gmt_create DATETIME COMMENT '创建时间',
    gmt_modified DATETIME COMMENT '更新时间'
) COMMENT='[comment]' CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
```