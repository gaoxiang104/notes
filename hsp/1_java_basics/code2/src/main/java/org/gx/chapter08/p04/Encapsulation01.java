package org.gx.chapter08.p04;

/**
 * 请大家看一个小程序(Encapsulation01.java)，不能随便查看人的年龄，工资等隐私，
 * 并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认·年龄，必须在1-120，年龄，
 * 工资不能直接查看，
 * name的长度在2-6之间·
 */
public class Encapsulation01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Jack aaaa");
        p.setAge(121);
        p.setSalary(888.88);
        System.out.println(p);
    }
}

class Person {
    private String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2 || name.length() > 6) {
            System.out.println("输入错误，名字范围：2 ～ 6");
            this.name = "无名氏";
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            System.out.println("输入错误，年龄范围：1 ～ 120");
            this.age = 3;
        } else {
            this.age = age;
        }
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append("\"age\":\"")
                .append(age).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
