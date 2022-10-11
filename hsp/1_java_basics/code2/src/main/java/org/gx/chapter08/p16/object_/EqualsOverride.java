package org.gx.chapter08.p16.object_;

public class EqualsOverride {
    public static void main(String[] args) {
        Person p1 = new Person("p1", 10, '男');
        Person p2 = new Person("p1", 10, '男');
        System.out.println(p1.equals(p2));
        Person p3 = new Person("p1", 10, '女');
        System.out.println(p1.equals(p3));

    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Person) {
            Person aObj = (Person) obj;

            return this.name.equals(aObj.name)
                    && this.age == aObj.age
                    && this.gender == aObj.gender;
        }

        return false;
    }
}
