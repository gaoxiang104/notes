package pers.xgo.onjava.chapter13_funcational;

@FunctionalInterface
public interface TirFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
