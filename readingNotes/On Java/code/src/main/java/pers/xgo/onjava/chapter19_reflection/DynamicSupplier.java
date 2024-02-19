package pers.xgo.onjava.chapter19_reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/** 动态供应商 */

class Id {
    private static long counter;
    public final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }

    public Id() {}
}

public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(Id.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
/* OUTPUT:
10
11
12
13
14
 */