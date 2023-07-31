package pers.xgo.onjava.chapter12_collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Person(String name) {
}

public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>(); // 宠物人

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(
                new Pet(), new Pet()
        ));
        petPeople.put(new Person("Kate"), Arrays.asList(
                new Pet(),new Pet()
        ));
        petPeople.put(new Person("Marilyn"), Arrays.asList(
                new Pet(),new Pet(),new Pet()
        ));
        petPeople.put(new Person("Luke"), Arrays.asList(
                new Pet(),new Pet()
        ));
        petPeople.put(new Person("Isaac"), Arrays.asList(
                new Pet()
        ));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.println(person.name() + " has :");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("    " + pet);
            }
        }
    }
}
