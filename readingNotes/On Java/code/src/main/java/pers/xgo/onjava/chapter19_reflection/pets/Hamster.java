package pers.xgo.onjava.chapter19_reflection.pets;

/** 仓鼠 */
public class Hamster extends Rodent {
    public Hamster() {
    }

    public Hamster(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Class<Hamster> hamsterClass = Hamster.class;
        String canonicalName = hamsterClass.getCanonicalName();
        System.out.println(canonicalName);
    }
}
