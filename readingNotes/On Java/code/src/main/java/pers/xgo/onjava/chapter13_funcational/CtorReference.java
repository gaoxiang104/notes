package pers.xgo.onjava.chapter13_funcational;

class Dog{
    String name;
    int age = -1; // For "unknown"
    Dog() { name = "stray"; }
    Dog(String name) { this.name = name; }
    Dog(String name, int age) { this.name = name; this.age = age; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String name);
}

interface Make2Args {
    Dog make(String name, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new; // [1]
        Make1Arg m1a = Dog::new; // [2]
        Make2Args m2a = Dog::new; // [3]

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
    }
}
