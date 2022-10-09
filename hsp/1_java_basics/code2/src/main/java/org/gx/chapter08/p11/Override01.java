package org.gx.chapter08.p11;

public class Override01 {
    public static void main(String[] args) {
        Student student = new Student("Jame", 11, "S001", 80);
        student.say();
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
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

    public void say() {
        System.out.print("name : " + name + ", age : " + age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append('}');
        return sb.toString();
    }
}

class Student extends Person {

    private String id;
    private double score;

    public Student() {
    }

    public Student(String id, double score) {
        this.id = id;
        this.score = score;
    }

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void say() {
        super.say();
        System.out.println(", id : " + id + ", score : " + score);
    }
}
