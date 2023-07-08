package org.gx.onjava.chapter11_innerclass;
// 保存一个对象序列

interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name){
        // 一个局部内部类
        class LocalCounter implements Counter {
            public LocalCounter() {
                // 局部内部类可以有构造器
                System.out.println("LocalCounter()");
            }


            @Override
            public int next() {
                System.out.println(name); // 访问局部的final变量
                return count++;
            }
        }

        return new LocalCounter();
    }

    Counter getCounter2(final String name){
        return new Counter() {
            // 匿名内部类不能有具名的构造器，
            // 只有一个实例初始化部分
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner"),
                c2 = lic.getCounter2("Anonymous inner");
        for (int i = 0; i <5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
