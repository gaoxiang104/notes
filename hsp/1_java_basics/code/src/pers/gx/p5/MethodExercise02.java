package pers.gx.p5;

public class MethodExercise02 {
    public static void main(String args[]) {
        // 编写一个方法 copyPerson, 可以复制一个Person对象， 返回复制的对象。 克隆对象
        Person p1 = new Person();
        p1.name="Jack";
        p1.age=10;
        System.out.println("p1 : " + p1);
        System.out.println("p1.name = " + p1.name + ",p1.age = " + p1.age);
        MyTools myTools = new MyTools();
        Person p2 = myTools.copyPerson(p1);
        System.out.println("p2 : " + p2);
        System.out.println("p2.name = " + p2.name + ",p2.age = " + p2.age);
        Person p3 = p1;
        System.out.println("p3 : " + p3);
        System.out.println("p3.name = " + p3.name + ",p3.age = " + p3.age);
    }
/* output : 
p1 : pers.gx.p5.Person@16b4a017
p1.name = Jack,p1.age = 10
p2 : pers.gx.p5.Person@5479e3f
p2.name = Jack,p2.age = 10
p3 : pers.gx.p5.Person@16b4a017 // 说明 p3 和 p1 是引用的同一个对象
p3.name = Jack,p3.age = 10
*/
}

class Person {
    String name;
    int age;
}

class MyTools {
    public Person copyPerson(Person p){
        Person result = new Person();
        result.name = p.name;
        result.age = p.age;
        return result;
    }
}