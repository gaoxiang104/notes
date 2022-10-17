package org.gx.chapter08.p20;

public class Homework13 {
    public static void main(String[] args) {
        Person[] arr = {
                new Student("小明", "男", 10, "S001"),
                new Student("小强", "男", 9, "S002"),
                new Teacher("王老师", "女", 25, 2),
                new Teacher("李老师", "女", 50, 32)
        };

        // 冒泡排序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Person p1 = arr[i];
                Person p2 = arr[j];
                if (p1.getAge() < p2.getAge()) {
                    arr[i] = p2;
                    arr[j] = p1;
                }
            }
        }

        for (Person person : arr) {
            System.out.println(person);
            f1(person);
            System.out.println("-------------------------------");
        }

    }

    static void f1(Person p) {
        if (p instanceof Student) {
            ((Student) p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("不认识的Person类型");
        }
    }
}
