package org.gx.chapter08.p13.poly.exercise;

public class PolyExercise01 {
    public static void main(String[] args) {
        double d = 13.4; // ok
        long l = (long)d; // ok
        System.out.println(l); // 13
        int in = 5; // ok
//        boolean b = (boolean) in; // 不对，boolean 不能转成 int ， 编译错误
        Object obj = "hello"; // OK，向上转型
        String objStr = (String) obj;// OK，向下转型
        System.out.println(objStr);// hello
        Object objPri = new Integer(5); // ok
//        String str = (String) objPri; // 不对，String 不能转成 Integer， 运行时异常 ClassCastException
        Integer str1 = (Integer) objPri; // OK
    }
}
