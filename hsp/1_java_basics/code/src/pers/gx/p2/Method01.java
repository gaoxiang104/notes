package pers.gx.p2;

public class Method01 {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.speak();
        System.out.println("p1.cal01() = " + p1.cal01());
        System.out.println("p1.cal02(10) = " + p1.cal02(10));
        System.out.println("p1.getSum(1,2) = " + p1.getSum(1,2));
    }
}

class Person {
    String name;
    int age;

    // 输出：我是一个好人
    public void speak() {
        System.out.println("我是一个好人！");
    }
    // 计算从1+..+1000的结果
    public int cal01() {
       int result = 0;
       for(int i = 1; i <= 1000; i++){
            result += i;
       } 
       return result;
    }
    // 计算从1+..+n的结果
    public int cal02(int n) {
       int result = 0;
       for(int i = 1; i <= n; i++){
            result += i;
       } 
       return result;
    }
    // 计算两个数的和
    public int getSum(int x, int y) {
        return x + y;
    }
}
