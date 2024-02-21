package pers.xgo.onjava.chapter19_reflection.pets;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创建随机的 Pet 对象
 */
public abstract class Creator implements Supplier<Pet> {
    private Random rand = new Random(47);

    // 创建不同类型的Pet
    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());

        try {
            return types().get(n).getConstructor().newInstance();
        } catch (InstantiationException
                 | NoSuchMethodException
                 | IllegalAccessException
                 | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Pet> stream() {
        return Stream.generate(this);
    }

    public Pet[] array(int size) {
        return stream().limit(size).toArray(Pet[]::new);
    }

    public List<Pet> list(int size) {
        return stream().limit(size).collect(Collectors.toList());
    }
}
