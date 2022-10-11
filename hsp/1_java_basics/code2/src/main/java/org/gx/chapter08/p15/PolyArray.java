package org.gx.chapter08.p15;

public class PolyArray {
    public static void main(String[] args) {
        Person[] personArray = {
                new Person("p1", 3),
                new Student("s1", 6),
                new Student("s2", 7),
                new Teacher("t1", 30),
                new Teacher("t2", 31)
        };

        for (Person person : personArray) {
            System.out.println(person.say());

            if (person instanceof Student) {
                System.out.println(((Student) person).study());
            } else if (person instanceof Teacher) {
                System.out.println(((Teacher) person).teach());
            }

        }
    }
}

class Person {
    private String name;
    private int age;

    public String say() {
        return "Person : " + getName() + " say()";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}

class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String say() {
        return "Student : " + getName() + " say()";
    }

    public String study() {
        return "Student : " + getName() + " study()";
    }
}

class Teacher extends Person {

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String say() {
        return "Teacher : " + getName() + " say()";
    }

    public String teach() {
        return "Teacher : " + getName() + " teach()";
    }
}