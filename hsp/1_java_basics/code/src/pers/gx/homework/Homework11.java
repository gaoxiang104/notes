package pers.gx.homework;

/**
 * 11.在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，调用语句为：System.out.println(method(method(10.0,20.0),100);
 */
public class Homework11 {
    public static void main(String[] args) {
       A11 a11 = new A11();
       System.out.println(a11.method(a11.method(10.0,20.0),100));
    }
}

class A11 {

    int method(double n, double m) {
        return (int)(n + m);
    }

    int method(int n, int m) {
        return n + m;
    }

}