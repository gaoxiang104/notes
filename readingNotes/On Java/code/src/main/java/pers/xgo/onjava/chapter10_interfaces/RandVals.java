package pers.xgo.onjava.chapter10_interfaces;

import java.util.Random;

// 用非常量初始化表达式来初始化接口
public interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt();
    long RANDOM_LONG = RAND.nextLong();
    double RANDOM_DOUBLE = RAND.nextDouble();
}
