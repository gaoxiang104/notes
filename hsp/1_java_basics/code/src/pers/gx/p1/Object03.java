package pers.gx.p1;

public class Object03 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "小明";
        p1.age = 10;

        System.out.println("name = " + p1.name + ", age = " + p1.age);
    }
}

class Person {
    String name;
    int age;
}