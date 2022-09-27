package pers.gx.p8;

/**
 * 斐波那契数列
 */
public class LeonardoFibonacci {
    public static void main (String args[]) {
        T t = new T();
        int result = t.leonardoFibonacci(7);
        System.out.println("leonardoFibonacci(7) = " + result);
    }
/* output :
leonardoFibonacci(7) = 13
*/

}

class T {

    /**
    * 斐波那契数列：1、1、2、3、5、8、13、21、34、……
    * 思路分析：
    * 1. 当n = 1 斐波那契数 是1
    * 2. 当n = 2 斐波那契数 是1
    * 3. 当n >= 3 斐波那契数 是前两个数的和
    */
    public int leonardoFibonacci(int n) {
        if(n >= 1){
            if(2 == n || 1 == n){
                return 1;
            } else {
                return leonardoFibonacci(n - 1) + leonardoFibonacci(n - 2);
            }
        } else {
            System.out.println("n需要>=1");
            return -1;
        }
        
    }
}
