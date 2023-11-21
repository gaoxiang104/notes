package pers.xgo.onjava.chapter19_reflection.toys;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {
} // 有电的

interface Waterproof {
} // 可以装水的

interface Shoots {
} // 可以射击的

class Toy {
    public Toy() {
    }

    public Toy(int i) {
    }
}

// 益智玩具
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.printf("Class name: %s is interface? [%s] \n", cc.getName(), cc.isInterface());
        System.out.printf("Simple name: %s \n", cc.getSimpleName());
        System.out.printf("Canonical name : %s \n", cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;

        try {
            c = Class.forName("pers.xgo.onjava.chapter19_reflection.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass(); // 父类
        Object obj = null;
        try {
            obj = up.getConstructor().newInstance();
            printInfo(obj.getClass());
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate");
        }
    }
}
/* OUTPUT:
Class name: pers.xgo.onjava.chapter19_reflection.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : pers.xgo.onjava.chapter19_reflection.toys.FancyToy
Class name: pers.xgo.onjava.chapter19_reflection.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : pers.xgo.onjava.chapter19_reflection.toys.HasBatteries
Class name: pers.xgo.onjava.chapter19_reflection.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : pers.xgo.onjava.chapter19_reflection.toys.Waterproof
Class name: pers.xgo.onjava.chapter19_reflection.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : pers.xgo.onjava.chapter19_reflection.toys.Shoots
Class name: pers.xgo.onjava.chapter19_reflection.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : pers.xgo.onjava.chapter19_reflection.toys.Toy
 */