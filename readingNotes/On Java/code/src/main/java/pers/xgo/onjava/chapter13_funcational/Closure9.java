package pers.xgo.onjava.chapter13_funcational;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

//  {无法通过编译}
public class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        ai = new ArrayList<>();
        // 错误：Variable used in lambda expression should be final or effectively final
        // return () -> ai;
        return () -> null;
    }
}
