package org.gx.chapter14.p02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetDemo01 {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee("tom", 18));
        set.add(new Employee("Jerry", 20));
        set.add(new Employee("tom", 18));
        System.out.println(set);
    }
}

class Employee {
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
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
