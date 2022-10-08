package pers.gx.homework;

/**
 * 8. 写出程序执行的结果
 */
public class Homework08 {
    public static void main(String[] args) {
        new Test().count1(); // 输出： count1=10
        Test t1 = new Test();
        t1.count1(); // 输出： count1=10
        t1.count2(); // 输出： count2=10
    }
}

class Test {

    int count = 9;

    public void count1() {
        count = 10;
        System.out.println("count1=" + count);
    }

    public void count2() {
        count = 10;
        System.out.println("count2=" + count++);
    }

}