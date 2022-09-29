package pers.gx.p11;

/**
 * 方法重载
 */
public class MyCalculator {

    public int calculator(int x, int y) {
        return x + y;
    }

    public double calculator(int x, double y) {
         return x + y;
    }

    public double calculator(double x, int y) {
         return x + y;
    }

    public int calculator(int x, int y, int z) {
        return x + y + z;
    }

}
