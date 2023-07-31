package pers.xgo.onjava.chapter13_funcational;

// lambda 实现 斐波那契数列
public class RecursiveFibonacci {
    IntCall fib;

    RecursiveFibonacci() {
//        fib = n -> n == 0 ? 0 :
//                   n == 1 ? 1 :
//                   fib.call(n - 1) + fib.call(n - 2);
        fib = n -> {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return fib.call(n - 1) + fib.call(n - 2);
        };
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(rf.fibonacci(i));
        }
    }
}
