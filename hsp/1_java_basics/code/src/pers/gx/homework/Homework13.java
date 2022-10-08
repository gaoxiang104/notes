package pers.gx.homework;

/**
 * 13.将对象作为参数传递给方法。 Homework13.java
    题目要求:
    (1)定义一个Circle类，包含一个double型的radius属性代表圆的半径，—findArea()
    方法返回圆的面积。
    (2)定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下:
    public void printAreas(Circle c, int times)
    //方法签名
    (3)在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
    例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
    (4)在main方法中调用printAreas(）方法，调用完毕后输出当前半径值。程序运行结果
    如图所示
 */
public class Homework13 {
    public static void main(String[] args) {
       Circle13 c = new Circle13();
       PassObject p = new PassObject();
       p.printAreas(c, 5);
    }
}

class Circle13 {
    int radius;

    public double findArea(){
        return radius * radius * 3.14;
    }
}

class PassObject {
    public void printAreas(Circle13 c, int times) {
        if(null == c || 0 > times){
            throw new RuntimeException("参数错误");
        }
        if(0 == times){
            return;
        } else {
            printAreas(c, times-1);
            c.radius = times;
            System.out.println(times + "： 面积 = " + c.findArea());
        }
    }
}