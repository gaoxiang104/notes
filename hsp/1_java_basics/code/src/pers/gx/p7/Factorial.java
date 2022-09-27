package pers.gx.p7;

/**
 * 阶乘
 */
public class Factorial {
    public static void main (String args[]) {
        T t = new T();
        int result = t.factorial(5);
        System.out.println("factorial(5) = " + result);
    }
/* output :
factorial(5) = 120
*/

}

class T {
    public int factorial(int n) {
        if(1 == n){
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}