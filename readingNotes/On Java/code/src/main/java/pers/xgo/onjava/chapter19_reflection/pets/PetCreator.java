package pers.xgo.onjava.chapter19_reflection.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用字面量
 */
public class PetCreator extends Creator {

    public static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class
            ));

    // 随机生成的类型
    private static final List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
                    ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
        List<Pet> pets = new PetCreator().list(7);
        System.out.println(pets);
    }
}
/* output:
[class pers.xgo.onjava.chapter19_reflection.pets.Mutt, class pers.xgo.onjava.chapter19_reflection.pets.Pug, class pers.xgo.onjava.chapter19_reflection.pets.EgyptianMau, class pers.xgo.onjava.chapter19_reflection.pets.Manx, class pers.xgo.onjava.chapter19_reflection.pets.Cymric, class pers.xgo.onjava.chapter19_reflection.pets.Rat, class pers.xgo.onjava.chapter19_reflection.pets.Mouse, class pers.xgo.onjava.chapter19_reflection.pets.Hamster]
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
 */