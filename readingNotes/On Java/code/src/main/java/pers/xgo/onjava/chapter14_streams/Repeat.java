package pers.xgo.onjava.chapter14_streams;
// 取代简单的 for 循环，这里有一个 repeat() 工具函数
import java.util.stream.IntStream;

public class Repeat {
    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }
}
