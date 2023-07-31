package pers.xgo.onjava.chapter06_housekeeping;

/**
 * 在类定义里指定初始化
 */

class Bowl { // 碗
    /**
     * @param marker 标记
     */
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);

}

class Cupboard { // 橱柜
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
/* OUTPUT :
bowl(1)
bowl(2)
Table()
f1(1)
bowl(4)
bowl(5)
bowl(3)
Cupboard()
f1(2)
main creating new Cupboard()
bowl(3)
Cupboard()
f1(2)
main creating new Cupboard()
bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
 */