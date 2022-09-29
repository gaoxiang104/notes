package pers.gx.p14;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Jack", 10);
        Person p2 = new Person("Jack", 10);
        if(p1.compareTo(p2)){
            System.out.println("p1 和 p2 相等");
        } else {
            System.out.println("p1 和 p2 不相等");
        }
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(Person p){
        return this.name.equals(p.name)  && this.age == p.age;
    }
}