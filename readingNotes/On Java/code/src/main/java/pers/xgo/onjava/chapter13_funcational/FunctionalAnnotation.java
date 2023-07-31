package pers.xgo.onjava.chapter13_funcational;

@FunctionalInterface
interface Functional{
    String goodbye(String s);
}

interface FunctionalNoAnn{
    String goodbye(String s);
}

/*
@FunctionalInterface
interface NotFunctional{
    String goodbye(String s);
    String helle(String s);
}
产生错误：
Multiple non-overriding abstract methods found in interface
*/

public class FunctionalAnnotation {
    public String goodbye(String s){
        return "Goodbye" + s;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        // Functional fac = fa; // 不兼容
        Functional fl = a -> "Goodbye" + a;
        FunctionalNoAnn fnal = a -> "Goodbye" + a;
    }
}
