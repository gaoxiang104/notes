package pers.xgo.onjava.chapter13_funcational;

public class RecursiveFactorial {
    static IntCall fact; // 因式

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}
