package pers.xgo.onjava.chapter14_streams;

import java.util.Random;
import java.util.stream.Stream;

public class RandomGenerators {
    public static <T> void show(Stream<T> stream) {
        stream.limit(4)
                .forEach(System.out::println);
        System.out.println("++++++++");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        show(random.ints().boxed());
        show(random.longs().boxed());
        show(random.doubles().boxed());
        // 控制上下边界：
        show(random.ints(10,20).boxed());
        show(random.longs(50 ,100).boxed());
        show(random.doubles(20,30).boxed());
        // 控制流的大小
        show(random.ints(2).boxed());
        show(random.longs(2).boxed());
        show(random.doubles(2).boxed());
        // 控制流的大小和边界
        show(random.ints(3,3,9).boxed());
        show(random.longs(3,12,22).boxed());
        show(random.doubles(3,11.5,12.3).boxed());
    }
}
