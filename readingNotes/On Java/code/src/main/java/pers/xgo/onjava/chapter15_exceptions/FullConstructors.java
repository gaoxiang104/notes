package pers.xgo.onjava.chapter15_exceptions;

class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException form f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException form g()");
        throw new MyException("Originated in g");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
