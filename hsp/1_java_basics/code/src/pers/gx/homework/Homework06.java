package pers.gx.homework;

/**
 * 6，编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试
 */
public class Homework06 {
    public static void main(String[] args) {
        Cale c = new Cale(3, 2.5);
        System.out.println("3, 2.5 sum : " + c.sum());
        System.out.println("3, 2.5 difference : " + c.difference());
        System.out.println("3, 2.5 multiplication : " + c.multiplication());
        System.out.println("3, 2.5 quotient : " + c.quotient());

        Cale c1 = new Cale(1, 0);
        System.out.println("1, 0 quotient : " + c1.quotient());


    }
}

class Cale {

    private double n;
    private double m;

    public Cale(double n, double m) {
        this.n = n;
        this.m = m;
    }

    public double sum(){
        return n + m;
    }

    public double difference(){
        return n - m;
    }

    public double multiplication(){
        return n * m;
    }

    public double quotient(){
        if(m == 0){
            throw new RuntimeException("错误：除数为0");
        }
        return n / m;
    }
   
}