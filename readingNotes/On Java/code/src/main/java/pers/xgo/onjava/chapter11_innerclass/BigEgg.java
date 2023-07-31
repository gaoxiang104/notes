package pers.xgo.onjava.chapter11_innerclass;
// 内部类不能被重写

class Egg {
    private Yolk y;

    protected class Yolk { // 蛋黄
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg{
    public class Yolk{
        public Yolk(){
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
/* output
New Egg()
Egg.Yolk()
 */