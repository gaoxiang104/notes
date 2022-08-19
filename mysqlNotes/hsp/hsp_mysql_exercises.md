# 1. 韩顺平讲 MySQL 练习

- [1. 韩顺平讲 MySQL 练习](#1-韩顺平讲-mysql-练习)

``` SQL
-- 2，查询dept表和emp表的结构
SHOW FULL COLUMNS FROM dept;
SHOW FULL COLUMNS FROM emp;

-- 3，使用简单查询语句完成：
--    (1) 显示所有部门名称
SELECT dept_name FROM dept;
--    (2) 显示所有雇员名及其全年收入，13月（工资+补助），并指定列名“年收入”
SELECT emp_name, (sal + IFNULL(comm,0))*13 AS '年收入' FROM emp;

-- 4，限制查询数据。
--    (1) 显示工资超过2850的雇员姓名和工资。
SELECT emp_name, sal FROM emp WHERE sal>2850;
--    (2) 显示工资不在1500和2850之间的所有雇员名和工资。
SELECT emp_name, sal FROM emp WHERE sal NOT BETWEEN 1500 AND 2850;
--    (3) 显示编号为7566的雇员姓名及所在部门编号。
SELECT emp_name, dept_no FROM emp WHERE emp_no=7566;
--    (4) 显示部门10和30中工资超过1500的雇员及工资。
SELECT emp_name, sal FROM emp WHERE dept_no IN (10,30) AND sal > 1500;
--    (5) 显示无管理者的雇员及岗位。
SELECT emp_name, job FROM emp WHERE mgr IS NULL;
--    (6) 显示管理者的雇员及岗位。
SELECT DISTINCT e1.emp_name, e1.job FROM emp e1 LEFT JOIN emp e2 ON e1.emp_no = e2.mgr;

-- 5，排序数据。
--    (1) 显示在1991年2月1日到1991年5月1日之间入职的雇员名，岗位及雇佣日期，并以雇佣日期进行排序。
SELECT emp_name, job, hire_date FROM emp WHERE hire_date BETWEEN '1991-02-01' AND '1991-05-01' ORDER BY hire_date;
--    (2) 显示获得补助的所有雇员名，工资及补助，并以工资降序排序。
SELECT emp_name, sal, comm FROM emp WHERE comm IS NOT NULL ORDER BY sal DESC;


-- 6，根据：emp员工表写出正确SQL
--    (1) 选择部门30中的所有员工.
SELECT * FROM emp WHERE dept_no = 30;
--    (2) 列出所有办事员(CLERK)的姓名，编号和部门编号.
SELECT emp_no, emp_name, dept_no FROM emp WHERE job = 'CLERK';
--    (3) 找出佣金高于薪金的员工.
SELECT * FROM emp WHERE comm > sal;
--    (4) 找出佣金高于薪金60%的员工.
SELECT * FROM emp WHERE comm > (sal*0.6);
--    (5) 找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK)的详细资料.
SELECT * FROM emp WHERE (dept_no=10 AND job='MANAGER') OR (dept_no=20 AND job='CLERK');
--    (6) 找出部门10中所有经理(MANAGER),部门20中所有办事员(CLERK),还有既不是经理又不是办事员但其薪金大于或等于2000的所有员工的详细资料.
SELECT * FROM emp WHERE (dept_no=10 AND job='MANAGER') OR (dept_no=20 AND job='CLERK') OR (job NOT IN ('MANAGER','CLERK') AND sal >=2000);
--    (7) 找出收取佣金的员工的不同工作.
SELECT DISTINCT job FROM emp WHERE comm IS NOT NULL;
--    (8) 找出不收取佣金或收取的佣金低于100的员工.
SELECT * FROM emp WHERE comm IS NULL OR comm < 100;
--    (9) 找出各月倒数第3天受雇的所有员工.
SELECT * FROM emp WHERE hire_date = DATE_ADD(LAST_DAY(hire_date), INTERVAL -2 DAY);  -- 月倒数第3天 = 月最后一天 - 2天；为什么减2天？因为包含第三天，所以只能减2，不能减3； 
--    (10) 找出早于12年前受雇的员工.
SELECT * FROM emp WHERE DATE_ADD(NOW(), INTERVAL -12 YEAR) > hire_date;
--    (11) 以首字母小写的方式显示所有员工的姓名.
SELECT CONCAT( LCASE(LEFT(emp_name,1)), SUBSTRING(emp_name,2)) AS emp_name_l FROM emp;
--    (12) 显示正好为5个字符的员工的姓名.
SELECT * FROM emp WHERE LENGTH(emp_name)=5;

-- 7，根据：emp员工表写出正确SQL homework03.sql
--    (1) 显示不带有"R"的员工的姓名.
SELECT * FROM emp WHERE INSTR(emp_name, 'R') = 0;
--    (2) 显示所有员工姓名的前三个字符.
SELECT SUBSTRING(emp_name,1,3) FROM emp;
--    (3) 显示所有员工的姓名,用a替换所有"A"
SELECT REPLACE(emp_name,'A','a') FROM emp;
--    (4) 显示满10年服务年限的员工的姓名和受雇日期.
SELECT emp_name, hire_date FROM emp WHERE hire_date < DATE_ADD(NOW(), INTERVAL -10 YEAR);
--    (5) 显示员工的详细资料,按姓名排序.
SELECT * FROM emp ORDER BY emp_name;
--    (6) 显示员工的姓名和受雇日期,根据其服务年限,将最老的员工排在最前面.
SELECT emp_name, hire_date FROM emp ORDER BY hire_date;
--    (7) 显示所有员工的姓名、工作和薪金,按工作降序排序,若工作相同则按薪金排序。
SELECT emp_name, job, sal FROM emp ORDER BY job DESC, sal DESC;
--    (8) 显示所有员工的姓名、加入公司的年份和月份,按受雇日期所在月排序,若月份相同则将最早年份的员工排在最前面.
SELECT emp_name, YEAR(hire_date) AS 'year', MONTH(hire_date) AS 'month' FROM emp ORDER BY `month`, `year`;
--    (9) 显示在一个月为30天的情况所有员工的日薪金,忽略余数.
SELECT emp_name , FLOOR(sal/30) AS day_sal FROM emp;
--    (10) 找出在(任何年份的)2月受聘的所有员工。
SELECT emp_name, hire_date FROM emp WHERE MONTH(hire_date)=2;
--    (11) 对于每个员工,显示其加入公司的天数.
SELECT emp_name, DATEDIFF(now(),hire_date) FROM emp;
--    (12) 显示姓名字段的任何位置包含"A"的所有员工的姓名.
SELECT * FROM emp WHERE INSTR(emp_name, 'A') <> 0;
--    (13) 以年月日的方式显示所有员工的服务年限.(大概)
SELECT emp_name, FLOOR(DATEDIFF(now(),hire_date) / 356) AS 'year', FLOOR(DATEDIFF(now(),hire_date) %365 /30) AS 'MONTH', FLOOR(DATEDIFF(now(),hire_date) %30) AS 'day' FROM emp;

```
