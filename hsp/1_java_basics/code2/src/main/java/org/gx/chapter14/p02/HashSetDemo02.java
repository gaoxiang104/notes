package org.gx.chapter14.p02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetDemo02 {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee("tom", 2000.00, new MyDate(1994, 1, 1)));
        set.add(new Employee("Jerry", 3000.00, new MyDate(1992, 11, 11)));
        set.add(new Employee("tom", 1800.00, new MyDate(1994, 1, 1)));
        System.out.println(set);
    }

    static class Employee {
        private String name;
        private Double sal;
        private MyDate birthday;

        public Employee(String name, Double sal, MyDate birthday) {
            this.name = name;
            this.sal = sal;
            this.birthday = birthday;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, birthday);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"sal\":")
                    .append(sal);
            sb.append(",\"birthday\":")
                    .append(birthday);
            sb.append('}');
            return sb.toString();
        }
    }

    static class MyDate {
        int year;
        int month;
        int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyDate myDate = (MyDate) o;
            return year == myDate.year && month == myDate.month && day == myDate.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(year).append("年").append(month).append("月").append(day).append("日");
            return sb.toString();
        }
    }
}


