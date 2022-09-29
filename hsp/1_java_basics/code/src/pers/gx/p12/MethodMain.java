package pers.gx.p12;

public class MethodMain {
    public static void main (String[] args) {
        Methods mt = new Methods();
        mt.m(3);
        mt.m(2, 3);
        mt.m("gx");

        System.out.println(mt.max(2, 3));
        System.out.println(mt.max(2.1, 3.1));
        System.out.println(mt.max(2, 3, 4));
    }
}

class Methods {
    int m(int n) {
        System.out.println("int m(int n)");
        return n * n;
    }
    
    int m(int x, int y) {
        System.out.println("int m(int x, int y)");
        return x * y;
    }

    String m(String s){
        System.out.println("String m(String s)");
        return s;
    }

    int max(int x, int y) {
        System.out.println("int max(int x, int y)");
        if(x > y){
            return x;
        } else {
           return y;
        }
    }

    double max(double x, double y) {
        System.out.println("int max(int x, int y)");
        if(x > y){
            return x;
        } else {
           return y;
        }
    }

    int max(int x, int y, int z) {
        System.out.println("int max(int x, int y, int z) ");
        int n = max(x, y);
        if(n > z){
            return n;
        } else {
           return z;
        }
    }
}