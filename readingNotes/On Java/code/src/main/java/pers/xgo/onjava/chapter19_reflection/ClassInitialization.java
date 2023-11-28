package pers.xgo.onjava.chapter19_reflection;

import java.util.Random;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception{
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref");
        // 不会触发初始化
        System.out.println(Initable.STATIC_FINAL);
        // 触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 触发初始化
        System.out.println(Initable2.staticNonFinal);
        Class<?> initable3 = Class.forName("pers.xgo.onjava.chapter19_reflection.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
/* OUTPUT :
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
 */