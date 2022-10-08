package pers.gx.homework;

/**
 * 5，定义一个圆类Circle,定义属性：半径，提供显示圆周长功能的方法，提供显示圆面积的方法 
 */
public class Homework05 {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println("perimeter : " + c.perimeter());
        System.out.println("area : " + c.area());
    }
}

class Circle {

    private double r;
    private double pi = 3.14;

    public Circle(double r) {
        this.r = r;
    }

    /**
     * 周长 
     */
    public double perimeter(){
        if(r <= 0){
            throw new RuntimeException("参数r错误");
        }
        return 2 * r * pi;
    }

    /**
     * 面积
     */
    public double area(){
        if(r <= 0){
            throw new RuntimeException("参数r错误");
        }
        return r * r * pi;
    }
   
}