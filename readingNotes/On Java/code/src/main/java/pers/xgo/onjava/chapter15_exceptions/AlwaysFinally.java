package pers.xgo.onjava.chapter15_exceptions;
// finally 总会执行

class FourException extends Exception{}

public class AlwaysFinally {
    public static void main(String[] args) {
        System.out.println("Entering first try block");
        try {
            System.out.println("Entering second try block");
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Gaught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}
/* output:
Entering first try block
Entering second try block
finally in 2nd try block
Gaught FourException in 1st try block
finally in 1st try block
 */