package pers.xgo.onjava.chapter19_reflection.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends Creator {
    private static List<Class<? extends Pet>> types
            = new ArrayList<>();

    private static String[] typeNames = {
            "pers.xgo.onjava.chapter19_reflection.pets.Mutt",
            "pers.xgo.onjava.chapter19_reflection.pets.Pug",
            "pers.xgo.onjava.chapter19_reflection.pets.EgyptianMau",
            "pers.xgo.onjava.chapter19_reflection.pets.Manx",
            "pers.xgo.onjava.chapter19_reflection.pets.Cymric",
            "pers.xgo.onjava.chapter19_reflection.pets.Rat",
            "pers.xgo.onjava.chapter19_reflection.pets.Mouse",
            "pers.xgo.onjava.chapter19_reflection.pets.Hamster"
    };

    static {
        loader();
    }

    private static void loader() {
        for (String name : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        ForNamePetCreator creator = new ForNamePetCreator();
        creator.list(20).stream().forEach(System.out::println);
    }

}
