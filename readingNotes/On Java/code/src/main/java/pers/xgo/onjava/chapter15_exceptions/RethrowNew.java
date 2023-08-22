package pers.xgo.onjava.chapter15_exceptions;
// 重新抛出一个与所捕获的异常不同的对象

class OneException extends Exception{
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception{
    public TwoException(String message) {
        super(message);
    }
}

public class RethrowNew {
    public static void f() throws OneException{
        System.out.println("origination the exception in f()");
        throw new OneException("thrown form f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace();
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
