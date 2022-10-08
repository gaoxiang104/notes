package pers.gx.homework;

/**
 * 7.设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。并创建对象，进行测试
 */
public class Homework07 {
    public static void main(String[] args) {
        Dog dog = new Dog("嘟嘟", "黄白", 1);
        dog.show();
    }
}

class Dog {

    private String name;
    private String color;
    private int age;

    public Dog() {

    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show(){
        System.out.println("name : " + this.name + ", color : " + this.color + ", age : " + this.age);
    }

}