# 1. 日期查询相关方法整理

- [1. 日期查询相关方法整理](#1-日期查询相关方法整理)
  - [1.1. 【周】](#11-周)
    - [1.1.1. 获取某日期的所在【周】的【周一】日期](#111-获取某日期的所在周的周一日期)
    - [1.1.2. 获取某日期的【N周前】的【周一】日期](#112-获取某日期的n周前的周一日期)


## 1.1. 【周】

### 1.1.1. 获取某日期的所在【周】的【周一】日期

``` sql
SELECT DATE (NOW() - INTERVAL (DAYOFWEEK(NOW()) - 2) DAY)   AS current_week_first_day;
```

- `DAYOFWEEK(NOW())` 获取当前是周几；注意：`1`是`周日`；
  - `DAYOFWEEK(NOW()) - 1` 表示：今天是 **`【周几】`** ;
  - `NOW() - INTERVAL (DAYOFWEEK(NOW()) - 2) DAY` ： 表示获得当前日期所在【周】的【周一】日期；

### 1.1.2. 获取某日期的【N周前】的【周一】日期

``` SQL
SELECT DATE (NOW() - INTERVAL (DAYOFWEEK(NOW()) - 2) DAY) - INTERVAL 3*7 DAY AS `DATE`;
```

- 先获取某日期的所在【周】的【周一】日期，再减去【N周】的【DAY】，例如这里演示是 【3周前的周一】；