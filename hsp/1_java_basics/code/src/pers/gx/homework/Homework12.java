package pers.gx.homework;

/**
 * 12.创建一个Employee类， 属性有(名字，性别，年龄，职位，薪水)，提供3个构造方法，可以初始化（1）(名字，性别，年龄，职位，薪水)，(2)(名字，性别，年龄)（3)(职位，薪水)，要求充分复用构造器
 */
public class Homework12 {
    public static void main(String[] args) {
       Employee emp1 = new Employee("Aoo", "男", 30, "销售", 3000.0);
       System.out.println(emp1);
       Employee emp2 = new Employee("Boo", "女", 20);
       System.out.println(emp2);
    }
}

class Employee {

    String name;
    String sex;
    int age;
    String job;
    double sal;

    public Employee(String name, String sex, int age, String job, Double sal){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }

    public Employee(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("name : ").append(this.name).append(", ");
        sb.append("sex : ").append(this.sex).append(", ");
        sb.append("age : ").append(this.age).append(", ");
        sb.append("job : ").append(this.job).append(", ");
        sb.append("sal : ").append(this.sal).append("");
        return sb.toString();
    }
}