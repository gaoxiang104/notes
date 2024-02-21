package pers.xgo.onjava.chapter19_reflection.pets;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 某种类型的人
 */
public class Individual implements Comparable<Individual> {

    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }


    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String argFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) { // simple name 不相等
            return firstCompare;
        }
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return o.id < id ? -1 : (o.id == id ? 0 : 1);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual
                && Objects.equals(id, ((Individual) obj).id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
