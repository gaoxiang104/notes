package pers.gx.homework;

/**
 * 1，编写类A01，定义方法max，实现求某个double数组的最大值，并返回
 */
public class Homework01 {
    public static void main(String[] args) {
        double[] list = new double[]{1.1, 2.2, 3.3, 4.4};
        A01 a01 = new A01();
        System.out.println("max : " + a01.max(list));
    }
}

class A01 {
    public double max(double[] list) {
        if(list.length <= 0){
            throw new RuntimeException("参数错误");
        }
        double result = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] > result){
                result = list[i];
            }
        }
        return result;
    }
}