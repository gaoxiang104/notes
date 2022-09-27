package pers.gx.p6;

/**
 * 递归
 */
public class Recursion01 {
    public static void main(String[] args) {
        T t = new T();
        t.test(4);
    }
}

class T {
    public void test(int n) {
        if(n > 2) {
            test(--n);
        }
        System.out.println("n=" + n);
    }
}