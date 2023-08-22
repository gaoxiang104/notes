package pers.xgo.onjava.chapter15_exceptions;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("e.getMessage() : " + e.getMessage());
            System.out.println("e.getLocalizedMessage() : " + e.getLocalizedMessage());
            System.out.println("e.toString() : " + e);
            System.out.println("e.printStackTrace() : ");
            e.printStackTrace();
        }
    }
}
